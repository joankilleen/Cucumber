/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package implementation;

public class Checkout {
	int count = 0;
	int price = 0;
    public void add(int count, int price) { 
    	this.price = price;
    	this.count += count;
    }

    public int total() { 
        return price*count;
    }
}