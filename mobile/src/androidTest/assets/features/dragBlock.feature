Feature: Drag Block Placement

  Background:
    Given an ongoing Game
    And it is my turn to move
    And I have pieces available

  Scenario:
    When I select an available piece
    And drag it to a position on the board
    And I release it
    Then The piece should be on the board.