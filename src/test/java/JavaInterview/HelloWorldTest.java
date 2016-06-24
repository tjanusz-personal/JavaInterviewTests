package test.java.JavaInterview;

import main.java.JavaInterview.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tjanusz929 on 6/22/16.
 */
public class HelloWorldTest {

    @Test
    public void HelloWorldReturnsHelloString() {
        HelloWorld world = new HelloWorld();
        assertEquals("Hello", world.sayHello());
    }

}