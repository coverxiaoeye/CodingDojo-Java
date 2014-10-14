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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstElement == null) ? 0 : firstElement.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((secondElement == null) ? 0 : secondElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expression other = (Expression) obj;
		if (firstElement == null) {
			if (other.firstElement != null)
				return false;
		} else if (!firstElement.equals(other.firstElement))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (secondElement == null) {
			if (other.secondElement != null)
				return false;
		} else if (!secondElement.equals(other.secondElement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expression [operator=" + operator + ", firstElement=" + firstElement + ", secondElement="
				+ secondElement + "]";
	}
}
