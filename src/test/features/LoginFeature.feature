Feature: LoginFeature
  Scenario: Successful Login With Valid Credentials
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And When User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout Button
    Then Page Title should be "Your Store. Login"
    And close Browser