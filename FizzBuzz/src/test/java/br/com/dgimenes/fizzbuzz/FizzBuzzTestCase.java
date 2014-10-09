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
package br.com.dgimenes.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTestCase {

	@Test
	public void testFizzBuzzOf1() {
		String[] list = new FizzBuzz(1).getList();
		String[] expectedList = { "1" };
		assertArrayEquals(expectedList, list);
	}

	@Test
	public void testFizzBuzzOf2() {
		String[] list = new FizzBuzz(2).getList();
		String[] expectedList = { "1", "2" };
		assertArrayEquals(expectedList, list);
	}

	@Test
	public void testFizzBuzzOf3() {
		String[] list = new FizzBuzz(3).getList();
		String[] expectedList = { "1", "2", "Fizz" };
		assertArrayEquals(expectedList, list);
	}

	@Test
	public void testFizzBuzzOf4() {
		String[] list = new FizzBuzz(4).getList();
		String[] expectedList = { "1", "2", "Fizz", "4" };
		assertArrayEquals(expectedList, list);
	}

	@Test
	public void testFizzBuzzOf5() {
		String[] list = new FizzBuzz(5).getList();
		String[] expectedList = { "1", "2", "Fizz", "4", "Buzz" };
		assertArrayEquals(expectedList, list);
	}

	@Test
	public void testFizzBuzzOf15() {
		String[] list = new FizzBuzz(15).getList();
		String[] expectedList = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
				"14", "FizzBuzz" };
		assertArrayEquals(expectedList, list);
	}
	
	@Test
	public void testFizzBuzzOf20() {
		String[] list = new FizzBuzz(20).getList();
		String[] expectedList = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
				"14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz" };
		assertArrayEquals(expectedList, list);
	}

}
