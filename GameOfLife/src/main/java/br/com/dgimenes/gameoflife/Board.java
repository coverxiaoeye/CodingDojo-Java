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

public class Board {

	private CellStatus[][] cells;
	private int columns;
	private int rows;

	public enum CellStatus {
		ALIVE, DEAD
	}

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		cells = new CellStatus[rows][columns];
	}
	
	public void fillBoardWithStatus(CellStatus status) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = status;
			}
		}
	}

	public void put(int row, int column, CellStatus status) {
		cells[row][column] = status;
	}

	public int countLiveNeighbour(int row, int column) {
		int alive = 0;
		alive += countLiveVerticalNeighbours(row, column);
		alive += countLiveHorizontalNeighbours(row, column);
		alive += countLiveDiagonalNeighbours(row, column);
		return alive;
	}

	private int countLiveDiagonalNeighbours(int row, int column) {
		int alive = 0;
		// top left
		if (row > 0 && column > 0 && this.cells[row - 1][column - 1] == CellStatus.ALIVE) {
			alive++;
		}
		// top right
		if (row > 0 && column < this.columns - 1 && this.cells[row - 1][column + 1] == CellStatus.ALIVE) {
			alive++;
		}
		// bottom left
		if (row < this.rows - 1 && column > 0 && this.cells[row + 1][column - 1] == CellStatus.ALIVE) {
			alive++;
		}
		// bottom right
		if (row < this.rows - 1 && column < this.columns - 1 && this.cells[row + 1][column + 1] == CellStatus.ALIVE) {
			alive++;
		}
		return alive;
	}

	private int countLiveHorizontalNeighbours(int row, int column) {
		int alive = 0;
		if (row < this.rows - 1 && this.cells[row + 1][column] == CellStatus.ALIVE) {
			alive++;
		}
		if (row > 0 && this.cells[row - 1][column] == CellStatus.ALIVE) {
			alive++;
		}
		return alive;
	}

	private int countLiveVerticalNeighbours(int row, int column) {
		int alive = 0;
		if (column < this.columns - 1 && this.cells[row][column + 1] == CellStatus.ALIVE) {
			alive++;
		}
		if (column > 0 && this.cells[row][column - 1] == CellStatus.ALIVE) {
			alive++;
		}
		return alive;
	}

	public CellStatus get(int row, int column) {
		return this.cells[row][column];
	}

	public int getColumns() {
		return this.columns;
	}
	
	public int getRows() {
		return this.rows;
	}

}
