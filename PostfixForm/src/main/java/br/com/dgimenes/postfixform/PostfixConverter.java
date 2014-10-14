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
