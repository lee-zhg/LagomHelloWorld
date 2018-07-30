[![Build Status](https://travis-ci.org/IBM/VirtualHelpDesk.svg?branch=master)](https://travis-ci.org/IBM/VirtualHelpDesk)[![Build Status]
![IBM Cloud Deployments](https://metrics-tracker.mybluemix.net/stats/337b997dfa50a8fd390e129af44b2035/badge.svg)

# Hello World in Lagom for Java and sbt
Through this mini Lagom for Java project, you start your journey of Lagom framework. You'll setup a basic development environment, and explore and test the Hello World sample code.

<br>

## Flow
1. Setup development environment.
1. Explore the Hello World project. 
1. Test the Hello World project. 
1. Deploy the Hello World project. 

![Demo](doc/source/images/architecture.png)


<br>

## With Watson

Want to take your Watson app to the next level? Looking to leverage Watson Brand assets? Join the [With Watson](https://www.ibm.com/watson/with-watson) program which provides exclusive brand, marketing, and tech resources to amplify and accelerate your Watson embedded commercial solution.


<br>

## Included components

* [Lightbend Lagom](https://www.lagomframework.com/documentation/1.4.x/java/Home.html): a micro service development framework .
* [sbt(simple build tool)](https://www.scala-sbt.org/): interactive build tool


<br>

## Featured technologies
* [Micro Servive](https://developer.ibm.com/code/technologies/microservices/): Collection of fine-grained, loosely coupled services using a lightweight protocol to provide building blocks in modern application composition in the cloud.
* [Java](https://developer.ibm.com/code/technologies/java/): A secure, object-oriented programming language for creating applications.

<br>

# Watch the Video

[![](doc/source/images/PlayVideo.png)](https://youtu.be/MjyX6vntejI)


<br>

# Steps


## Deploy to IBM Cloud

[![Deploy to IBM Cloud](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/IBM/virtualhelpdesk)


<br>

## Before you begin

* Create an IBM Cloud account
    * [Sign up][sign_up] in IBM Cloud, or use an existing account. Your account must have available space for at least 1 app and 1 service.
* Make sure that you have the following prerequisites installed:
    * The [Cloud Foundry][cloud_foundry] command-line client

      Note: Ensure that you Cloud Foundry version is up to date


<br>


## Downloading Hello World sample code

Download the [Hellp World sample code](https://github.com/lee-zhg/LagomHelloWorld). And, unzip it to a folder such as \lightbend\hello.


<br>

## Prerequisites

Before starting with Lagom, check to make sure that you have the correct versions of a Java Development Kit (JDK) and build tool. Your build tool must also have internet access.


<br>


### Setting up JDK

Before setting up the development environment, verify that you have a Java Development Kit (JDK) version 8 and that your machine is configured correctly.


Check the JDK version by running java and javac from the command line:

    ```bash
    java -version
    javac -version
    ```
For java, the command should return with the major version number of 1.8. For example,

```bash
java version "1.8.0_172"
Java(TM) SE Runtime Environment (build 1.8.0_172-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.172-b11, mixed mode)
```

for javac, the command should return something similar to:

```bash
javac 1.8.0_172
```

If you do not have the correct JDK installed, download it from the [Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

If you have the correct JDK installed, but the console cannot find java or javac, you can configure your machine by setup environment variables on your system. Pages below provide tips and examples for configuring Java:

* [Linux](https://stackoverflow.com/questions/33860560/how-to-set-java-environment-variables-using-shell-script)
* [iOS](http://osxdaily.com/2015/07/28/set-enviornment-variables-mac-os-x/)
* [Windows](https://stackoverflow.com/questions/1672281/environment-variables-for-java-installation)


<br>

### Setting up sbt

[sbt](https://www.scala-sbt.org/)(simple build tool) is a build tool for Java and Scala. Lagom recommends using sbt 1.x.

1. Download [sbt](https://www.scala-sbt.org/download.html). For example, sbt-1.1.6.msi.

1. Install sbt. For exmaple, on Windows platform, start sbt installation by double clicking sbt-1.1.6.msi. Take all default and complete the installation. 


<br>

### Setting up Eclipse

Complete this section if you prefer to use Eclipse IDE while working with Logam.

1. Download and install/unzip the prepackaged and preconfigured [Scala IDE for Eclipse](http://scala-ide.org/download/sdk.html) for your platform. It's also possible to configure and use your existing Eclipse environment.

1. Install Lombok support for Eclipse. 

    * Shutdown Eclipse.
    * Download [Lombok.jar](https://projectlombok.org/download).
    * Execute [Lombok.jar](https://projectlombok.org/download). This initiates the installer. Follow the instructions to complete the installation.

        ```bash
        java -jar lombok.jar
        ```
    ![](photos/lombok.png)

    * Start Eclipse.
    * Additional information is available at https://projectlombok.org/setup/eclipse


1. Open Lagom project in Eclipse

    * Open a command window
    * Navigate to the root directory of your Lagom project. For example, /lightbend/hello
    * start sbt session with the sbt command
    * Within sbt session, execute command

        ```bash
        eclipse with-source=true
        ......
        [info] Successfully created Eclipse project files for project(s):
        [info] hello-api
        [info] hello-impl
        ```
    * Import the Lagom project in Eclipse IDE. Import... -> General -> Existing Projects into Workspace. On the Import page browse to the Lagom project root folder and import it, for example, \lightbend\hello. Both hello-api and hello-impl are imported as shown below.

    ![](photos/eclipse.png)


<br>

## Exploring the Hello World code

Every service built in Lagom contains at least two parts: an API project and an implementation project.

The API project contains the service interface, also known as the descriptor, along with all the data models that the interface uses, e.g. request and response messages. The API project can be depended on and consumed by other services.

The implementation project will naturally also depend on the API project, in order to implement it.

The Hello World sample code has one service, called hello. It has an api project hello-api and an implementation project, hello-impl.

The rest of this section discusses important files for the Hello World sample code.


<br>

### File /hello-api/src/main/java/com/example/hello/api/HelloService.java

```bash
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
```

Microservices promise their behavior through their API. Lagom's Service API is used to communicate this promise.

Services are defined by creating a Service Interface. Service Interfaces extend com.lightbend.lagom.javadsl.api.Service. They declare a set of methods that provide the API for the service. They also declare a descriptor that maps the individual methods into HTTP endpoints.

In the Hello World sample code, service "HelloService" is defined. It has one API "helloWorld". It's mapped to HTTP endpoint /hello. So, you can easily test it through url http://localhost:9000/hello after implementation.


<br>

### File /hello-impl/src/main/java/com/example/hello/impl/HelloServiceImpl.java

```bash
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
```

With the API and it's descriptor in place you have promised the services behaviour. Now it is time to fulfill that promise.

To fulfill the promise made by the Api, you implement the interface. This provides a concrete class where you will define behavior for each ServiceCall.

A service call is defined by providing a lambda. The parameter for the lambda is the Request type. The return type of the Lambda is a CompletionStage that contains the Response type. This can be done trivially using the CompletableFuture.completedFuture method.


<br>

### File /hello-impl/src/main/java/com/example/hello/impl/HelloModule.java

```bash
package com.example.hello.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

import com.example.hello.api.HelloService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class HelloModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        bindService(HelloService.class, HelloServiceImpl.class);
    }
}
```

Lagom uses Guice for dependency injection. It comes from the Playframework which Lagom is built on top of. This decouples dependencies from their implementations. Client code doesn't need to change just because the implementation code is changed.

Java modules are created that bind implementations of various dependencies. Guice then injects those dependencies where needed.

To create a module with Guice, you extend the com.google.inject.AbstractModule and implement the com.lightbend.lagom.javadsl.server.ServiceGuiceSupport. You then override the configure method. The configure method instructs Guice on how to bind specific dependencies. In the Hello World sample code, HelloServiceImpl depends on HelloService.


<br>

### File /hello-impl/src/main/resources/application.conf

```bash
play.modules.enabled += com.example.hello.impl.HelloModule
```

Once a module(HelloModule.java) is created, it must be enabled through configuration in file /hello-impl/src/main/resources/application.conf. The play.modules.enabled configuration can be used to enable each of your modules. Once the module is created and enabled, the Lagom application can be run.


<br>

### File /hello-impl/src/test/java/com/example/hello/impl/HelloServiceTest.java

```bash
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
```

HelloServiceTest.java provides a quick testing option.


<br>

### File /.sbtopts

```bash
-J-Xms512M
-J-Xmx4096M
-J-Xss2M
-J-XX:MaxMetaspaceSize=1024M
```

.sbtopts is used by sbt shell script.


<br>

### File /build.sbt

```bash
organization in ThisBuild := "com.example"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"

lazy val `hello` = (project in file("."))
  .aggregate(`hello-api`, `hello-impl`)

lazy val `hello-api` = (project in file("hello-api"))
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lombok
    )
  )

lazy val `hello-impl` = (project in file("hello-impl"))
  .enablePlugins(LagomJava)
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomLogback,
      lagomJavadslTestKit,
      lombok
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`hello-api`)

val lombok = "org.projectlombok" % "lombok" % "1.16.18"

def common = Seq(
  javacOptions in compile += "-parameters"
)
```

A build definition is defined in build.sbt, and it consists of a set of projects (of type Project). In the above example, "hello" project is defined in the current directory. It includes "hello-api" and "hello-impl" subprojects.

Subproject "hello-api" locates in "hello-api" folder. It depends on lagomJavadslApi and lombok library in this example.

Subproject "hello-impl" locates in "hello-impl" folder. It depends on lagomLogback, lagomJavadslTestKit and lombok library in this example. The Implementation project enables the LagomJava plugin and depends on the API project "hello-api". Unit test has dependency on lagomJavadslTestKit. Cassandra test requires lagomForkedTestSettings.


<br>

### File /project/build.properties

```bash
sbt.version=1.1.5
```

As part of your build definition you will specify the version of sbt that your build uses. This allows people with different versions of the sbt launcher to build the same projects with consistent results. To do this, create a file named project/build.properties that specifies the sbt version. 

If the required version is not available locally, the sbt launcher will download it for you. If this file is not present, the sbt launcher will choose an arbitrary version, which is discouraged because it makes your build non-portable.

<br>

### File /project/plugins.sbt

```bash
// The Lagom plugin
addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.4.7")

// Needed for importing the project into Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
```

A Lagom build must tell sbt to use the Lagom plugin. This is done by creating a file called project/plugins.sbt. The plugin provides all the necessary support for building, running, and deploying your Lagom application.

The second plugin in the above example is required when you intend to import a Lagom project into Eclipse.


<br>

### File /hello-impl/src/test/resources/logback.xml

```bash
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <conversionRule conversionWord="coloredLevel" converterClass="com.lightbend.lagom.internal.logback.ColoredLevel" />

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%date{"HH:mm:ss.SSS"} %coloredLevel %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <logger name="org.apache.cassandra" level="ERROR" />
    <logger name="com.datastax.driver" level="WARN" />

    <logger name="akka" level="WARN" />

    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>

</configuration>
```

Logback is intended as a successor to the popular log4j project. It's logging mechanism. logback.xml file defines how it's configured.


<br>

## Testing the Hello World code

To test the Hello World sample code,

1. Open a command window
1. Navigate to the root directory of your Lagom project. For example, /lightbend/hello
1. Start a sbt session
    ```bash
    sbt
    ```
1. Execute command "test"
    ```bash
    test
    ```
1. At the end of the testing, you should see the following messages.

    ```bash
    [info] Test run started
    [info] Test com.example.hello.impl.HelloServiceTest.helloWorld_shouldReturnTheExpectedResult started
    [info] Test run finished: 0 failed, 0 ignored, 1 total, 0.046s
    [info] Passed: Total 1, Failed 0, Errors 0, Passed 1
    ```


<br>

## Executing the Hello World code

To run the Hello World sample code,

1. Open a command window
1. Navigate to the root directory of your Lagom project. For example, /lightbend/hello
1. Start a sbt session
    ```bash
    sbt
    ```
1. Execute command runAll
    ```bash
    runAll
    ```
1. Issue url http://localhost:9000/hello in a browser. "Hello World" should be returned.


<br>

### Deploy the Hello World code to IBM Cloud








<br>

## License

This sample code is licensed under Apache 2.0.
Full license text is available in [LICENSE](LICENSE).


<br>

## Contributing

See [CONTRIBUTING](CONTRIBUTING.md).


<br>

## Open Source @ IBM

Find more open source projects on the
[IBM Github Page](http://ibm.github.io/).


[cf_docs]: (https://www.ibm.com/watson/developercloud/doc/common/getting-started-cf.html)
[cloud_foundry]: https://github.com/cloudfoundry/cli#downloads
[demo_url]: http://maximobot.mybluemix.net/
[doc_intents]: (http://www.ibm.com/watson/developercloud/doc/conversation/intent_ovw.shtml)
[docs]: http://www.ibm.com/watson/developercloud/doc/conversation/overview.shtml
[docs_landing]: (http://www.ibm.com/watson/developercloud/doc/conversation/index.shtml)
[node_link]: (http://nodejs.org/)
[npm_link]: (https://www.npmjs.com/)
[sign_up]: bluemix.net/registration


<br>

# Privacy Notice

Sample web applications that include this package may be configured to track deployments to [IBM Cloud](https://www.bluemix.net/) and other Cloud Foundry platforms. The following information is sent to a [Deployment Tracker](https://github.com/IBM/metrics-collector-service) service on each deployment:

* Node.js package version
* Node.js repository URL
* Application Name (`application_name`)
* Application GUID (`application_id`)
* Application instance index number (`instance_index`)
* Space ID (`space_id`) or OS username
* Application Version (`application_version`)
* Application URIs (`application_uris`)
* Cloud Foundry API (`cf_api`)
* Labels of bound services
* Number of instances for each bound service and associated plan information
* Metadata in the repository.yaml file

This data is collected from the `package.json` and `repository.yaml` file in the sample application and the `VCAP_APPLICATION` and `VCAP_SERVICES` environment variables in IBM Cloud and other Cloud Foundry platforms. This data is used by IBM to track metrics around deployments of sample applications to IBM Cloud to measure the usefulness of our examples, so that we can continuously improve the content we offer to you. Only deployments of sample applications that include code to ping the Deployment Tracker service will be tracked.


<br>

# Disabling Deployment Tracking

To disable tracking, simply remove require('metrics-tracker-client').track(); from the app.js file in the top level directory.
