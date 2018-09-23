/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementation.Checkout;

public class CheckoutSteps {
	Map<String, Checkout> checkouts = new HashMap();
	Map<String, Integer> prices = new HashMap();
    Checkout checkout = new Checkout();
    int bananaPrice = 0;

    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) throws Throwable {
    	prices.put(name, price);
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {
    	Integer price = prices.get(itemName);
    	assert(price != null);
    	Checkout checkout = checkouts.get(itemName);
    	if (checkout == null) {
    		checkout = new Checkout();
    	}
        checkout.add(itemCount, price);
        checkouts.put(itemName, checkout);
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
    	int totalCheckouts = 0;
    	for (Map.Entry<String, Checkout> checkoutEntry: checkouts.entrySet()){
    		Checkout checkout = checkoutEntry.getValue();
    		totalCheckouts += checkout.total();
    		
    	}
        assertEquals(total, totalCheckouts);    
    }
}
