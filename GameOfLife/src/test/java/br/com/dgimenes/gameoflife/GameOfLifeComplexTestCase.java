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
package br.com.dgimenes.gameoflife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameOfLifeComplexTestCase {
	private static final int ROWS = 4;
	private static final int COLUMNS = 5;

	@Test
	public void testFirstComplexBoard() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(1, 2, Board.CellStatus.ALIVE);
		board.put(1, 3, Board.CellStatus.ALIVE);
		board.put(2, 1, Board.CellStatus.ALIVE);
		board.put(2, 2, Board.CellStatus.ALIVE);
		board.put(2, 3, Board.CellStatus.ALIVE);
		board = new NextBoardBuilder(board).build();
		
		assertEquals(Board.CellStatus.DEAD, board.get(0, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(1, 0));
		assertEquals(Board.CellStatus.ALIVE, board.get(1, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 2));
		assertEquals(Board.CellStatus.ALIVE, board.get(1, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(2, 0));
		assertEquals(Board.CellStatus.ALIVE, board.get(2, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 2));
		assertEquals(Board.CellStatus.ALIVE, board.get(2, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(3, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 1));
		assertEquals(Board.CellStatus.ALIVE, board.get(3, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 4));
	}
	
	@Test
	public void testSecondComplexBoard() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(1, 1, Board.CellStatus.ALIVE);
		board.put(1, 3, Board.CellStatus.ALIVE);
		board.put(2, 1, Board.CellStatus.ALIVE);
		board.put(2, 3, Board.CellStatus.ALIVE);
		board.put(3, 2, Board.CellStatus.ALIVE);
		board = new NextBoardBuilder(board).build();
		
		assertEquals(Board.CellStatus.DEAD, board.get(0, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(1, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(2, 0));
		assertEquals(Board.CellStatus.ALIVE, board.get(2, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 2));
		assertEquals(Board.CellStatus.ALIVE, board.get(2, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(3, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 1));
		assertEquals(Board.CellStatus.ALIVE, board.get(3, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 4));
	}
	
	@Test
	public void testThirdComplexBoard() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(2, 1, Board.CellStatus.ALIVE);
		board.put(2, 3, Board.CellStatus.ALIVE);
		board.put(3, 2, Board.CellStatus.ALIVE);
		board = new NextBoardBuilder(board).build();
		
		assertEquals(Board.CellStatus.DEAD, board.get(0, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(1, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(2, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 1));
		assertEquals(Board.CellStatus.ALIVE, board.get(2, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(3, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 1));
		assertEquals(Board.CellStatus.ALIVE, board.get(3, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 4));
	}
	
	
	@Test
	public void testFourthComplexBoard() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(2, 2, Board.CellStatus.ALIVE);
		board.put(3, 2, Board.CellStatus.ALIVE);
		board = new NextBoardBuilder(board).build();
		
		assertEquals(Board.CellStatus.DEAD, board.get(0, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(0, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(1, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(1, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(2, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(2, 4));
		
		assertEquals(Board.CellStatus.DEAD, board.get(3, 0));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 1));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 2));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 3));
		assertEquals(Board.CellStatus.DEAD, board.get(3, 4));
	}
}
