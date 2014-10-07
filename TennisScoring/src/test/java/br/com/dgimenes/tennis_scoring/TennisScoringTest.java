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

import junit.framework.TestCase;

public class TennisScoringTest extends TestCase {

	public TennisScoringTest(String name) {
		super(name);
	}

	public void testScoringDeuce0x0() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.LOVE);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.LOVE);
		assertEquals("deuce", score.printScore());
	}

	public void testScoringDeuce1x1() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.FIFTEEN);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.FIFTEEN);
		assertEquals("deuce", score.printScore());
	}

	public void testScoringDeuce2x2() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.THIRTY);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.THIRTY);
		assertEquals("deuce", score.printScore());
	}

	public void testScoringDeuce3x3() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.FORTY);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.FORTY);
		assertEquals("deuce", score.printScore());
	}
	
	public void testScoringAdvantageToOne1x0() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.FIFTEEN);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.LOVE);
		assertEquals("advantage to player one", score.printScore());
	}
	
	public void testScoringAdvantageToOne2x0() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.THIRTY);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.LOVE);
		assertEquals("advantage to player one", score.printScore());
	}

	public void testScoringAdvantageToOne3x0() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.FORTY);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.LOVE);
		assertEquals("advantage to player one", score.printScore());
	}
	
	public void testScoringAdvantageToTwo0x1() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.LOVE);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.FIFTEEN);
		assertEquals("advantage to player two", score.printScore());
	}
	
	public void testScoringAdvantageToTwo0x2() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.LOVE);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.THIRTY);
		assertEquals("advantage to player two", score.printScore());
	}
	
	public void testScoringAdvantageToTwo0x3() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.LOVE);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.FORTY);
		assertEquals("advantage to player two", score.printScore());
	}
	
	public void testScoringAdvantageToTwo1x2() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.FIFTEEN);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.THIRTY);
		assertEquals("advantage to player two", score.printScore());
	}
	
	
	public void testScoringAdvantageToTwo2x3() {
		TennisScore score = new TennisScore();
		score.setPointsForPlayer(TennisScore.Player.ONE, TennisScore.Points.THIRTY);
		score.setPointsForPlayer(TennisScore.Player.TWO, TennisScore.Points.FORTY);
		assertEquals("advantage to player two", score.printScore());
	}
}
