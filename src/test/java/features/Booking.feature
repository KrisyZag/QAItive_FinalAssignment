Feature: Booking reservation

  Scenario: Booking destination
    Given I am on Booking home page
    And I choose language sr
    And I add destination Tara
    And I add start 31 januar 2022 and end date 2 februar 2022
    And I add guests with child age 5 godina
    And I click on search button
    And I verify that for atribute placeholder location Tara
    And I verify dates from ponedeljak, 31. januar 2022. to sreda, 2. februar 2022.
    And I verify adultCount 2 odrasla, childrenCount 1 dete, roomCount 2 jedinice
    And I choose apartment apartments-dm
    And I checked header in new tab Apartments DM