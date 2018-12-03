#Feature 2
Feature: Approve Block Placement
#Note: piece and block refer to the same thing
  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

    #Covers scenarios 3,4,5
  Scenario Outline: I try to approve an invalid block placement
    Given it is <round>
    When I select an available block
    And drag it to a <position> on the board
    And I release it
    Then I should see the approve button
    And the approve button is non_clickable

    #Note: the Upper_Left_Corner is always the red player's corner

    Examples:
      |round          | position
      first_round     | top_right_corner
      non_first_round | position such that it is on top of an existing piece
      non_first_round | position such that the piece has a side that lines up against the side of another piece of my pieces
      non_first_round | position such that the piece does not connect by corner to another piece of my pieces

    #Covers scenarios 2,6
  Scenario Outline: I try to approve a valid block placement
    Given it is <round>
    When I select an available block
    And drag it to a <position> on the board
    And I release it
    And I click on the approve button
    Then the floating block gets placed on the board

    Examples:
      |round      | position
      first_round | top_left_corner
      non_first_round | position such that the piece connects by corner to another piece of my pieces, and does not share any sides with it or rest on top of another existing piece