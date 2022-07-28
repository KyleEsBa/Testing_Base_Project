@Login
Feature: Login into Library CT application
  User Story: As a user, I should be able to login to LibraryCT

  Background:
    Given user is on the login page

  Scenario Outline: User can login into the application
    When user enters a valid "<email>" username
    Then user should see "Login - Library" as title of the page
    And user enters a valid "<password>" password
    And user click on the Sign In button
    Then user should see "Library" as title of the page

    @Student
    Examples: Credentials for student
      | email            | password |
      | student2@library | zyxa10vg |

    @Librarian
    Examples: Credentials for librarian
      | email              | password |
      | librarian2@library | uYrhHmmj |