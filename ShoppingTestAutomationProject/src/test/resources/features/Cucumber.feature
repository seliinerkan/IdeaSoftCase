Feature: Shopping Cart Functionality

  // Scenario: Adding a product to the shopping cart and verifying the cart contents


  Background:
    Given I visit the website "https://testcase.myideasoft.com/"
    And I search for the product "ürün"
    And I select the first product from the search results
    And I select 5 item from dropdown menu
    When I add the selected items to the cart



  Scenario: Adding a product to the shopping cart
    Then I should see notification message on the screen
    Then I should see "SEPETİNİZE EKLENMİŞTİR" message

  Scenario: Verifying the cart contents
    When I navigate to the cart page
    Then The cart should contain 5 items of the selected product





