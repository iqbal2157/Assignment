Feature: CRUD operations

  @crud @create
  Scenario: Check user can add computer
    Given user is on add computer page
    When user enter the computer details to add
    And click on Add_Computer_Button
    Then User get the success message - Done! Computer Computer_name has been created
    And user can see new entry in table with valid data

  @crud @update
  Scenario: Check user can Update computer
    Given user is on Update computer page
    When user enter the computer details to edit
    And click on Update_This_Computer_Button
    Then User get the success message - Done! Computer Computer_name has been updated
    And user can see record in table with updated data

  @crud @delete
  Scenario: Check Deletion
    Given user is on Delete computer page
    When click on Delete_This_Computer_Button
    Then User get the success message - Done! Computer has been deleted
    And user don't see deleted record anymore