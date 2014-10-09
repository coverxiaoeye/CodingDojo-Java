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

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.dgimenes.gameoflife.Board.CellStatus;

public class GameOfLifeBoardTestCase {
	private static final int ROWS = 5;
	private static final int COLUMNS = 5;
	
	@Test
	public void testPutGetCellStatus_Alive() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(2, 2, Board.CellStatus.ALIVE);
		CellStatus result = board.get(2,2);
		assertEquals(Board.CellStatus.ALIVE, result);
	}
	
	@Test
	public void testPutGetCellStatus_Dead() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.ALIVE).build();
		board.put(2, 2, Board.CellStatus.DEAD);
		CellStatus result = board.get(2,2);
		assertEquals(Board.CellStatus.DEAD, result);
	}

	@Test
	public void testCountLiveNeighbourCells_UpLeftCorner_ExpectedZero() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(0, 0, Board.CellStatus.ALIVE);
		int liveNeighbourCells = board.countLiveNeighbour(0, 0);
		assertEquals(0, liveNeighbourCells);
	}
	
	@Test
	public void testCountLiveNeighbourCells_UpLeftCorner_ExpectedAll3() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(0, 0, Board.CellStatus.ALIVE);
		board.put(0, 1, Board.CellStatus.ALIVE);
		board.put(1, 0, Board.CellStatus.ALIVE);
		board.put(1, 1, Board.CellStatus.ALIVE);
		int liveNeighbourCells = board.countLiveNeighbour(0, 0);
		assertEquals(3, liveNeighbourCells);
	}
	
	@Test
	public void testCountLiveNeighbourCells_Middle_ExpectedZero() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(2, 2, Board.CellStatus.ALIVE);
		int liveNeighbourCells = board.countLiveNeighbour(2, 2);
		assertEquals(0, liveNeighbourCells);
	}
	
	@Test
	public void testCountLiveNeighbourCells_Middle_ExpectedAll8() {
		Board board = new BoardBuilder(ROWS, COLUMNS, Board.CellStatus.DEAD).build();
		board.put(2, 2, Board.CellStatus.ALIVE);
		board.put(1, 1, Board.CellStatus.ALIVE);
		board.put(1, 2, Board.CellStatus.ALIVE);
		board.put(1, 3, Board.CellStatus.ALIVE);
		board.put(2, 1, Board.CellStatus.ALIVE);
		board.put(2, 3, Board.CellStatus.ALIVE);
		board.put(3, 1, Board.CellStatus.ALIVE);
		board.put(3, 2, Board.CellStatus.ALIVE);
		board.put(3, 3, Board.CellStatus.ALIVE);
		int liveNeighbourCells = board.countLiveNeighbour(2, 2);
		assertEquals(8, liveNeighbourCells);
	}
}
