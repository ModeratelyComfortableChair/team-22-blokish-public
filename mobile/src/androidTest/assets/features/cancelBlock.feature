#Feature 3
Feature: Cancel Block Placement
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

    #Covers scenarios 8,9,10,11,12,13
  Scenario Outline: I try to cancel a block placement
    Given it is <round>
    When I select an available block
    And drag it to a position <position> on the board
    And release it
    And click on the cancel button
    Then the floating block goes back to my set of available pieces

  Examples:
    |round          | position
    first_round     | top_left_corner
    first_round     | top_right_corner
    non_first_round | position such that the piece connects by corner to another piece of my pieces, and isn’t on or at the side of another piece of my pieces
    non_first_round | position such that the piece is on top of another piece
    non_first_round | position such that the piece has a side that lines up against the side of another piece of my pieces
    non_first_round | position such that the piece does not connect by corner to another piece of my pieces