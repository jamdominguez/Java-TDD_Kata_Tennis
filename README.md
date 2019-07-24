# Java-TDD_Kata_Tennis
Simple java local application, using Test Driven Development methodology.

**Level: MEDIUM**

Setup:
 - JDK 1.8.0_191
 - IDE IntelliJ Idea
 - Maven (IntellliJ Idea)
 - JUnit 4

Reference TDD Katas: [TDD Kata](https://www.programmingwithwolfgang.com/tdd-kata/)



# 1. Introduction
  TDD is a methodology that let implement efficient code. To use TDD in a project, all team members musth think in TDD mode, from functional analist to junior developer.
  The TDD paradigm consist in:
  1. Take funtional requirements like technical test cases
  2. Implement an basic unit test case
  3. Write the minimun code to pass the test case
  4. Refactoring the code
  5. Repeat the poings 2, 3 and 4 to cover all requirements.

In this example I will develop a simple application using TDD. Imagine you take the next requirements:
___
This kata is about implementing a simple tennis game. I came up with it while thinking about Wii tennis, where they have simplified tennis, so each set is one game. The scoring system is rather simple:

  1. Each player can have either of these points in one game 0 15 30 40
  2. If you have 40 and you win the ball you win the game, however, there are special rules.
  3. If both have 40 the players are deuce.
    3.1. After deuce, the winner of a ball will have advantage and game ball.
    3.2. If the player with advantage wins the ball he wins the game
    3.3. If the player without advantage wins they are back at deuce.
  4. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
  5. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
  6. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
  7. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.
___
Now we must think in basic unit test to cover every cases... 
