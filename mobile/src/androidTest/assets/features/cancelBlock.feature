#Feature 3
Feature: Cancel Block Placement
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

    #Covers scenarios 4,5,9,10,11
  Scenario Outline: I try to cancel a block placement
    Given it is <round>
    When I select an available block
    And drag it to a position <position> on the board
    And release it
    And click on the cancel button
    Then the floating block goes back to my set of available pieces

  Examples:
    |round      | position
    first_round | Upper_Left_Corner
    first_round | Upper_Right_Corner
    non_first_round | position which meets with the corner of another of my pieces, and isn’t on another piece or at the side of another piece  | clickable
    non_first_round | position which meets with the corner of another of my pieces, but is on another piece  | clickable
    non_first_round | position which meets with the corner of another of my pieces, but has a side that lines up along another piece of my pieces  | clickable