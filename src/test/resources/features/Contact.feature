@regression
Feature:
  As an end user
    I want a contact us page
    So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |
    And I confirm message is sent
    And I am not receiving any confirmation message

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs                                  |
      | message | please contact me I want to find out more |
    And I got server error