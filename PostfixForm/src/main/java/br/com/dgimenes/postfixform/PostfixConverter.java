package br.com.dgimenes.postfixform;

import java.util.Scanner;

public class PostfixConverter {

	private String infixExpressionString;

	public PostfixConverter(String infixExpressionString) {
		this.infixExpressionString = infixExpressionString;
	}

	public String getPostfixForm() {
		Expression exp = extractExpression(this.infixExpressionString);
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
		}
		res.append(" ");
		res.append(exp.getOperator());
	}

	private Expression extractExpression(String infixExpressionString) {
		Scanner scanner = new Scanner(infixExpressionString);
		String firstElementStr = scanner.next();
		if (firstElementStr.startsWith("(")) {
			firstElementStr = firstElementStr.replaceAll("\\(","");
		}
		Integer firstValue = Integer.parseInt(firstElementStr);
		String operator = scanner.next();
		String secondElementStr = scanner.next();
		if (secondElementStr.endsWith(")")) {
			secondElementStr = secondElementStr.replaceAll("\\)","");
		}
		Integer secondValue = Integer.parseInt(secondElementStr);
		Expression lastFoundExp = new Expression(operator, new Value(firstValue), new Value(secondValue));
		while (scanner.hasNext()) {
			operator = scanner.next();
			secondValue = scanner.nextInt();
			lastFoundExp = new Expression(operator, lastFoundExp, new Value(secondValue));
		}
		scanner.close();
		return lastFoundExp;
	}

}
