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
		res.append(" ");
		Element secondElement = exp.getSecondElement();
		if (secondElement instanceof Value) {
			res.append(((Value) secondElement).getValue());
		} else {
			printExpressionPostfix((Expression) secondElement, res);
		}
		res.append(" ");
		res.append(exp.getOperator());
	}

	private Expression extractExpression(Scanner scanner) {
		Element firstElement = null;
		Element secondElement = null;
		String firstElementStr = scanner.next();
		if (firstElementStr.startsWith("(")) {
			String firstElementString = extractParenthesisBlock(firstElementStr, scanner);
			firstElement = extractExpression(new Scanner(firstElementString));
		} else {
			firstElement = new Value(Integer.parseInt(firstElementStr));
		}
		String operator = scanner.next();
		String secondElementStr = scanner.next();
		if (secondElementStr.startsWith("(")) {
			String secondElementString = extractParenthesisBlock(secondElementStr, scanner);
			secondElement = extractExpression(new Scanner(secondElementString));
		} else {
			secondElement = new Value(Integer.parseInt(secondElementStr));
		}
		Expression lastFoundExp = new Expression(operator, firstElement, secondElement);
		while (scanner.hasNext()) {
			operator = scanner.next();
			secondElementStr = scanner.next();
			if (secondElementStr.startsWith("(")) {
				String secondElementString = extractParenthesisBlock(secondElementStr, scanner);
				secondElement = extractExpression(new Scanner(secondElementString));
			} else {
				secondElement = new Value(Integer.parseInt(secondElementStr));
			}
			lastFoundExp = new Expression(operator, lastFoundExp, secondElement);
		}
		scanner.close();
		return lastFoundExp;
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
