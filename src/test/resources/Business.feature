@Business
Feature: A new business
  This is a new business

  Scenario: A User ask the business logo
    Given a new business is formed
    When asked for logo
    Then should show logo

  Scenario: A User place an Order
    Given a new business is formed
    When a User places an Order
    Then Order count shall increment by 1

  Scenario Outline: A User place variable number of Orders

    Given a new business is formed
    When a User places <orderCnt> Order
    Then Order count shall be <expectedOrderCnt>
    Then initBusiness should not run

    Examples:
      | orderCnt | expectedOrderCnt |
      | 1        | 1                |
      | 2        | 2                |
      | 2        | 2                |
      | 4        | 4                |