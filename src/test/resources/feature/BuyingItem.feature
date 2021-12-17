@BuyingItemFeature
Feature: Buying item
  A user wants to buy an item

  Scenario: Buying an item with the card pay
    Given Launch Application "https://weathershopper.pythonanywhere.com"
    Then User sees a URL GUI
    When User clicks on the buy moisturisers button
    Then User sees a Moisturisers page
    When User clicks on the Add Button on first moisturiser
    Then User sees cart changes from empty to "1 item(s)" item
    When User clicks on the cart in the top right corner
    Then User sees a checkout page
    When User clicks on the Pay with Card button
    Then Application switch to "stripe_checkout_app"
    Then User sees a new window to enter the card details
    When User enters the "abc@gmail.com", "123","12" and "456"
    When User clicks on the close button
    And User closes the page
