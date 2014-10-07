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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HPShoppingBasket {

	private Map<Book, Integer> booksInBasket;

	public HPShoppingBasket() {
		this.booksInBasket = new HashMap<Book, Integer>();
	}

	public void add(Book book) {
		Integer count = this.booksInBasket.get(book);
		if (count == null) {
			count = 0;
		}
		this.booksInBasket.put(book, count + 1);
	}

	public Double getFinalPrice() {
		double price = 0.0D;
		Map<Book, Integer> booksToProcess = new HashMap<Book, Integer>(this.booksInBasket);
		while (booksToProcess.size() > 0) {
			int diffBooksCount = 0;
			Iterator<Entry<Book, Integer>> iterator = booksToProcess.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Book, Integer> bookToProcess = iterator.next();
				if (diffBooksCount == 4 && booksToProcess.size() == 4) {
					break;
				}
				if (bookToProcess.getValue() == 1) {
					iterator.remove();
				} else {
					bookToProcess.setValue(bookToProcess.getValue() - 1);
				}
				diffBooksCount++;
			}
			if (diffBooksCount == 1) {
				price += 8D;
			} else if (diffBooksCount == 2) {
				price += 15.2D;
			} else if (diffBooksCount == 3) {
				price += 21.6D;
			} else if (diffBooksCount == 4) {
				price += 25.6D;
			} else {
				price += 30D;
			}
		}
		return price;
	}

}
