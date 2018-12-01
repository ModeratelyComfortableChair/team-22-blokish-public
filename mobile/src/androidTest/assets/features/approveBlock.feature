#Feature 2
Feature: Approve Block Placement
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

    #Covers scenarios 2,3,6,7,8
  Scenario Outline: I try to approve an invalid block placement
    Given it is <round>
    When I select an available block
    And drag it to a <position> on the board
    And I release it
    Then I should see the approve button
    And the approve button is non_clickable

    #Note: the Upper_Left_Corner is always the red player's corner
    Examples:
      |round      | position
  first_round | Upper_Right_Corner
  non_first_round | position which meets with the corner of another of my pieces, but is on another piece
  non_first_round | position which meets with the corner of another of my pieces, but has a side that lines up on another piece of my pieces

  Scenario Outline: I try to approve a valid block placement
    Given it is <round>
    When I select an available block
    And drag it to a <position> on the board
    And I release it
    And I click on the approve button
    Then the floating block gets placed on the board

    Examples:
      |round      | position
      first_round | Upper_Left_Corner
      non_first_round | position which meets with the corner of another of my pieces, and isn’t on another piece or at the side of another piece