CodingDojo
==========

Solution for some common Coding Dojo problems.

##HarryPotter

To try and encourage more sales of the 5 different Harry Potter books they sell, a bookshop has decided to offer discounts of multiple-book purchases. 

One copy of any of the five books costs 8 EUR. 

If, however, you buy two different books, you get a 5% discount on those two books.

If you buy 3 different books, you get a 10% discount. 

If you buy 4 different books, you get a 20% discount.

If you go the whole hog, and buy all 5, you get a huge 25% discount. 

Note that if you buy, say, four books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR. 

Your mission is to write a piece of code to calculate the price of any conceivable shopping basket (containing only Harry Potter books), giving as big a discount as possible.

For example, how much does this basket of books cost?

2 copies of the first book
2 copies of the second book
2 copies of the third book
1 copy of the fourth book
1 copy of the fifth book

One way of group these 8 books is:
 1 group of 5 --> 25% discount (1st,2nd,3rd,4th,5th)
+1 group of 3 --> 10% discount (1st,2nd,3rd)
This would give a total of
 5 books at a 25% discount
+3 books at a 10% discount
Giving
 5 x (8 - 2.00) == 5 x 6.00 == 30.00
+3 x (8 - 0.80) == 3 x 7.20 == 21.60
For a total of 51.60

However, a different way to group these 8 books is:
 1 group of 4 books --> 20% discount  (1st,2nd,3rd,4th)
+1 group of 4 books --> 20% discount  (1st,2nd,3rd,5th)
This would give a total of
 4 books at a 20% discount
+4 books at a 20% discount
Giving
 4 x (8-1.60) == 4 x 6.40 == 25.60
+4 x (8-1.60) == 4 x 6.40 == 25.60
For a total of 51.20

And 51.20 is the price with the biggest discount.

##TennisScoring

You task is to implement a tennis scoring program. Summary of tennis scoring:

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
   
2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
   
3. If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
   
4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.

##GameOfLife

Develop an algorithm that takes "one step" in the game of life. The behaviour examples may simply be the rules of the game:

1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.

2. Any live cell with more than three live neighbours dies, as if by overcrowding.

3. Any live cell with two or three live neighbours lives on to the next generation.

4. Any dead cell with exactly three live neighbours becomes a live cell.

You also have to think of things such as how to represent the board in a test-friendly way, and what "value" cells outside the board has. Or maybe the board does not have borders?

#License

The MIT License (MIT)

Copyright (c) 2014 Daniel Gimenes

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


