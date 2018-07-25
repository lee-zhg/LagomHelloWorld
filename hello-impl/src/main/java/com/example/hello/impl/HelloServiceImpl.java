package com.example.hello.impl;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

import com.example.hello.api.HelloService;

/**
 * Implementation of the HelloService.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public ServiceCall<NotUsed, String> helloWorld() {
        return notUsed -> completedFuture("Hello World");
    }
}



 