package com.example.hello.impl;

import org.junit.Test;

import com.example.hello.api.HelloService;
import com.example.hello.impl.HelloServiceImpl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    @Test
    public void helloWorld_shouldReturnTheExpectedResult() throws Exception {
		    HelloServiceImpl service = new HelloServiceImpl();
			
            String msg1 = service.helloWorld().invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("Hello World", msg1); // default greeting
    }
}


