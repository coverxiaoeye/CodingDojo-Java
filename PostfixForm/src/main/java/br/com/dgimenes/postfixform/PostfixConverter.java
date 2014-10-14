/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Daniel Gimenes
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the ("Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED ("AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package br.com.dgimenes.postfixform;

import java.util.Scanner;

public class PostfixConverter {

	private String infixExpressionString;

	public PostfixConverter(String infixExpressionString) {
		this.infixExpressionString = infixExpressionString;
	}

	public String getPostfixForm() {
		Expression exp = extractExpression(new Scanner(infixExpressionString));
		StringBuilder res = new StringBuilder();
		printExpressionPostfix(exp, res);
		return res.toString();
	}

	private void printExpressionPostfix(Expression exp, StringBuilder res) {
		Element firstElement = exp.getFirstElement();
		if (firstElement instanceof Value) {
			res.append(((Value) firstElement).getValue());
		} else {
			printExpressionPostfix((Expression) firstElement, res);
		}
		Element secondElement = exp.getSecondElement();
		// we might have just a firstElement, which is a number or expression in
		// parenthesis
		if (secondElement != null) {
			res.append(" ");
			if (secondElement instanceof Value) {
				res.append(((Value) secondElement).getValue());
			} else {
				printExpressionPostfix((Expression) secondElement, res);
			}
			res.append(" ");
			res.append(exp.getOperator());
		}
	}

	// Needs refactoring...
	private Expression extractExpression(Scanner scanner) {
		Expression lastFoundExp = null;
		Element firstElement = null;
		String firstElementStr = scanner.next();
		if (firstElementStr.startsWith("(")) {
			String firstElementString = extractParenthesisBlock(firstElementStr, scanner);
			firstElement = extractExpression(new Scanner(firstElementString));
		} else {
			firstElement = new Value(Integer.parseInt(firstElementStr));
		}
		// we might have just a firstElement, which is a number or expression in
		// parenthesis
		if (scanner.hasNext()) {
			String operator = scanner.next();
			Element secondElement = null;
			do {
				String secondElementStr = scanner.next();
				String nextOperator = null;
				if (scanner.hasNext()) {
					nextOperator = scanner.next();
				}
				if (secondElementStr.startsWith("(")) {
					String secondElementString = extractParenthesisBlock(secondElementStr + " " + nextOperator, scanner);
					secondElement = extractExpression(new Scanner(secondElementString));
					if (scanner.hasNext()) {
						nextOperator = scanner.next();
					}
					if (nextOperator != null && compareOperatorPriority(nextOperator, operator) > 0) {
						String nextBlock = scanner.next();
						if (nextBlock.startsWith("(")) {
							secondElementString = "(" + secondElementString + ") " + nextOperator + " ("
									+ extractParenthesisBlock(nextBlock, scanner) + ")";
						} else {
							secondElementString = "(" + secondElementString + ") " + nextOperator + " " + nextBlock;
						}
						secondElement = extractExpression(new Scanner(secondElementString));
					}
				} else {
					secondElement = new Value(Integer.parseInt(secondElementStr));
					if (nextOperator != null && compareOperatorPriority(nextOperator, operator) > 0) {

						String secondElementString = secondElementStr + " " + nextOperator + " " + scanner.next();
						secondElement = extractExpression(new Scanner(secondElementString));
						if (scanner.hasNext()) {
							nextOperator = scanner.next();
						}
					}
				}
				lastFoundExp = new Expression(operator, lastFoundExp == null ? firstElement : lastFoundExp,
						secondElement);
				operator = nextOperator;
			} while (scanner.hasNext());
		} else {
			lastFoundExp = new Expression(null, firstElement, null);
		}
		scanner.close();
		return lastFoundExp;
	}

	private int compareOperatorPriority(String nextOperator, String operator) {
		return getOperatorPriorityValue(nextOperator) - getOperatorPriorityValue(operator);
	}

	private int getOperatorPriorityValue(String operator) {
		if (operator.equals("+")) {
			return 1;
		} else if (operator.equals("-")) {
			return 1;
		} else if (operator.equals("*")) {
			return 2;
		} else if (operator.equals("/")) {
			return 2;
		}
		return 0;
	}

	private String extractParenthesisBlock(String startBlock, Scanner scanner) {
		StringBuilder sb = new StringBuilder();
		sb.append(startBlock);
		int openParenthesis = countChar('(', startBlock);
		while (openParenthesis > 0 && scanner.hasNext()) {
			String nextBlock = scanner.next();
			openParenthesis += countChar('(', nextBlock);
			openParenthesis -= countChar(')', nextBlock);
			sb.append(" ").append(nextBlock);
		}
		String withoutOutmostParenthesis = sb.toString().substring(1, sb.toString().length() - 1);
		return withoutOutmostParenthesis;
	}

	private int countChar(char c, String startBlock) {
		int count = 0;
		for (int i = 0; i < startBlock.length(); i++) {
			if (startBlock.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

}
