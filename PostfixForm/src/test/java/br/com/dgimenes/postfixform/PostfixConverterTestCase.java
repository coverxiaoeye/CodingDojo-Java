package br.com.dgimenes.postfixform;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixConverterTestCase {
	
	// Without Parenthesis

	@Test
	public void testExpression_NoParenthesis_OneOperator_Plus() {
		String expression = "2 + 2";
		String expectedPostfixFormExp = "2 2 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_OneOperator_Minus() {
		String expression = "3 - 1";
		String expectedPostfixFormExp = "3 1 -";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_OneOperator_Times() {
		String expression = "190 * 2";
		String expectedPostfixFormExp = "190 2 *";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_OneOperator_Division() {
		String expression = "309 / 3";
		String expectedPostfixFormExp = "309 3 /";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_Simple1() {
		String expression = "1 + 3 + 2";
		String expectedPostfixFormExp = "1 3 + 2 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_Simple2() {
		String expression = "1 * 3 / 2";
		String expectedPostfixFormExp = "1 3 * 2 /";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_Simple3() {
		String expression = "1 * 3 / 2 + 1 + 3 + 4";
		String expectedPostfixFormExp = "1 3 * 2 / 1 + 3 + 4 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_4_OperatorPriority() {
		String expression = "1 + 2 + 3 * 4";
		String expectedPostfixFormExp = "1 2 + 3 4 * +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_5_OperatorPriority() {
		String expression = "1 + 2 + 3 * 4 + 2";
		String expectedPostfixFormExp = "1 2 + 3 4 * + 2 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_NoParenthesis_TwoOperators_6_JustANumber() {
		String expression = "1";
		String expectedPostfixFormExp = "1";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	
	// With Parenthesis
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_1() {
		String expression = "(2 + 3) + 1";
		String expectedPostfixFormExp = "2 3 + 1 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_2() {
		String expression = "2 + (3 + 1)";
		String expectedPostfixFormExp = "2 3 1 + +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_3() {
		String expression = "(2 + 3) + (3 + 1)";
		String expectedPostfixFormExp = "2 3 + 3 1 + +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_4() {
		String expression = "3 * (2 + 5)";
		String expectedPostfixFormExp = "3 2 5 + *";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_5_OperatorPriority() {
		String expression = "((2 + 3) / 4) + (3 + 1) * 4";
		String expectedPostfixFormExp = "2 3 + 4 / 3 1 + 4 * +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_6_OperatorPriority() {
		String expression = "((2 + 3) / 4) + (3 + 1) * (4 + 1)";
		String expectedPostfixFormExp = "2 3 + 4 / 3 1 + 4 1 + * +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_7_Complex() {
		String expression = "(((2 + 3) / 4) + (4 + 4)) + 5 / 2";
		String expectedPostfixFormExp = "2 3 + 4 / 4 4 + + 5 2 / +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
	
	@Test
	public void testExpression_WithParenthesis_TwoOperators_8_UselessParenthesis() {
		String expression = "(((((2 + 3)))))";
		String expectedPostfixFormExp = "2 3 +";
		PostfixConverter converter = new PostfixConverter(expression);
		String postfixForm = converter.getPostfixForm();
		assertEquals(expectedPostfixFormExp, postfixForm);
	}
}
