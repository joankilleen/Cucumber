/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package hooks;

import cucumber.api.java.Before;

import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ResetHooks {

    @Before
    public void deleteFruitFile() throws Exception {
        Path path = FileSystems.getDefault().getPath("fruit.json");
        Files.deleteIfExists(path);
    }
}