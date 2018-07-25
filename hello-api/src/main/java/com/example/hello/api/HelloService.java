package com.example.hello.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.*;

/**
 * The hello service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the HelloService.
 */
public interface HelloService extends Service {

    /**
     * Example:
     * curl http://localhost:9000/hello
     */
    ServiceCall<NotUsed,String> helloWorld();

    @Override
    default Descriptor descriptor() {
        return named("hello").withCalls(
                namedCall("hello", this::helloWorld)
        ).withAutoAcl(true);
    }
}

