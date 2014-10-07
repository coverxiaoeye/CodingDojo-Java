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
package br.com.dgimenes.harrypotter;

import junit.framework.TestCase;

public class HarryPotterTest extends TestCase {
	
	public void testBuyingAny1DiffBook_Book1() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		assertEquals(8D, basket.getFinalPrice());
	}
	
	public void testBuyingAny1DiffBook_Book2() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_2);
		assertEquals(8D, basket.getFinalPrice());
	}
	
	public void testBuyingAny1DiffBook_Book3() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_3);
		assertEquals(8D, basket.getFinalPrice());
	}
	
	public void testBuyingAny1DiffBook_Book4() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_4);
		assertEquals(8D, basket.getFinalPrice());
	}
	
	public void testBuyingAny1DiffBook_Book5() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_5);
		assertEquals(8D, basket.getFinalPrice());
	}
	
	public void testBuying2DiffBooks_1() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		assertEquals(15.2D, basket.getFinalPrice());
	}
	
	public void testBuying2DiffBooks_2() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		assertEquals(15.2D, basket.getFinalPrice());
	}
	
	public void testBuying3DiffBooks() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		assertEquals(21.6D, basket.getFinalPrice());
	}
	
	public void testBuying4DiffBooks() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_5);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		assertEquals(25.6D, basket.getFinalPrice());
	}

	public void testBuying5DiffBooks() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		basket.add(Book.HARRY_POTTER_BOOK_5);
		assertEquals(30D, basket.getFinalPrice());
	}
	
	public void testBuying2EqualBooks() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_1);
		assertEquals(16D, basket.getFinalPrice());
	}
	
	public void testBuying3Diff1EqualBooks_1() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_1);
		assertEquals(29.6D, basket.getFinalPrice());
	}
	
	public void testBuying3Diff1EqualBooks_2() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		basket.add(Book.HARRY_POTTER_BOOK_5);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		assertEquals(29.6D, basket.getFinalPrice());
	}
	
	public void testBuyingRepeatedBooks_1() {
		HPShoppingBasket basket = new HPShoppingBasket();
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_1);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_2);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_3);
		basket.add(Book.HARRY_POTTER_BOOK_4);
		basket.add(Book.HARRY_POTTER_BOOK_5);
		assertEquals(51.20D, basket.getFinalPrice());
	}
}
