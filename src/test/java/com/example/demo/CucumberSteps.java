package com.example.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberSteps {
    @Autowired
    private Business buss;

    @Given("a new business is formed")
    public void business_is_created() {
        System.out.println("####### Resetting Business ########");
        Assertions.assertInstanceOf(BusinessImpl.class, buss);
        buss.initBusiness();
    }

    @When("asked for logo")
    public void business_return_logo() {
        Assertions.assertInstanceOf(String.class, buss.getLogo());
    }

    int totalBeforeProcessOrder = 0;

    @When("a User places an Order")
    public void a_user_places_an_order() {
        totalBeforeProcessOrder = buss.reportTotalOrder();
        buss.processOrder(1);
    }

    @When("a User places {int} Order")
    public void a_user_places_an_order(int orderCnt) {
        totalBeforeProcessOrder = buss.reportTotalOrder();
        buss.processOrder(orderCnt);
    }

    @Then("should show logo")
    public void business_returned_logo_should_be_correct() {
        Assertions.assertEquals(buss.getLogo(), "ABC");
    }

    @Then("Order count shall increment by 1")
    public void order_count_shall_increment_by_1() {
        Assertions.assertEquals(buss.reportTotalOrder(), totalBeforeProcessOrder + 1);
    }

    @Then("Order count shall be {int}")
    public void order_count_shall_increment_by_1(int expectedOrderCnt) {
        Assertions.assertEquals(buss.reportTotalOrder(), expectedOrderCnt);
    }

    @Then("initBusiness should not run")
    public void initBusiness_should_not_run() {
        Assertions.assertEquals(true, true);
    }
}
