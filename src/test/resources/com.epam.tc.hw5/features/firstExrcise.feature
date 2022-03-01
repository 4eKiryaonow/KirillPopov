Feature: First Exercise
  Scenario: Different Elements Page Log test
    Given I open JDI Index Page
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements button in Service dropdown
    And I select checkboxes 'Water', 'Wind'
    And I select radio 'Selen'
    And I Select in dropdown 'Yellow'
    Then Log rows are displayed in Log Bar
    And checkbox name and its status are corresponding to selected
    And radio button name and it status is corresponding to selected
    And dropdown name and selected value is corresponding to selected
