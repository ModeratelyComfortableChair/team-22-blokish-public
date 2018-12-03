#Feature 1
Feature: Drag Block Placement
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

  #Covers Scenario 1
  Scenario: For any round, I drag a piece to any position on the board
    When I select an available piece
    And drag it to a position on the board
    And release it
    Then the piece should be on floating the board and waiting for confirmation or cancellation.