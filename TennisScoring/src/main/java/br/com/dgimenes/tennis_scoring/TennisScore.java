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
package br.com.dgimenes.tennis_scoring;

public class TennisScore {
	enum Points {
		LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3);

		private int value;

		private Points(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	enum Player {
		ONE, TWO
	}

	private Points playerOnePoints;
	private Points playerTwoPoints;

	public void setPointsForPlayer(Player player, Points points) {
		if (player == Player.ONE) {
			this.playerOnePoints = points;
		} else {
			this.playerTwoPoints = points;
		}
	}

	public String printScore() {
		if (this.playerOnePoints.getValue() > this.playerTwoPoints.getValue()) {
			return "advantage to player one";
		} else if (this.playerOnePoints.getValue() < this.playerTwoPoints.getValue()) {
			return "advantage to player two";
		}
		return "deuce";
	}

}
