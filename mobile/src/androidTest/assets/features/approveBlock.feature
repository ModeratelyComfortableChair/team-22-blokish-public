Feature: Approve Block Placement

  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

  Scenario Outline: I try to press approve button
    When I select an available piece <piece>
    And drag it to an invalid position <position>
    And I release it
    Then I should see the button to confirm
    And I result <result> click the button

    Examples:
      | piece            | position           | result  |
      | Lower_Left_Piece | Upper_Left_Corner  | can     |
      | Lower_Left_Piece | Upper_Right_Corner | can_not |