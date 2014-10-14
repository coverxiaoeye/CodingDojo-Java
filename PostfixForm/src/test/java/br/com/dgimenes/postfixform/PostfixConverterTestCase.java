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
