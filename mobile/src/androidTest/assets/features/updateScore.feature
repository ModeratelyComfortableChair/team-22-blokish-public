#Feature 4
Feature: Update Game Score
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

    #Covers scenario 12
  Scenario Outline: Successfully add block to the board and update my score
    Given my current score is <x>
    When I successfully add a block having <y> squares to the board
    Then I see that my score got updated to x+y


    #Note: the Upper_Left_Corner is always the red player's corner
  Examples:
    |x  |y
    |50 |4
