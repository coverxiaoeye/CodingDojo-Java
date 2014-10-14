package br.com.dgimenes.postfixform;

public class Expression implements Element {
	private String operator;
	private Element firstElement;
	private Element secondElement;

	public Expression(String operator, Element firstElement, Element secondElement) {
		super();
		this.operator = operator;
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	public String getOperator() {
		return operator;
	}

	public Element getFirstElement() {
		return firstElement;
	}

	public Element getSecondElement() {
		return secondElement;
	}
}
