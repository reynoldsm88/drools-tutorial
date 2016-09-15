Basic Drools + Maven tutorial
====

Building
----------
mvn clean install - resolve dependencies, build project, run unit tests

Maven
---------------------------
The main Maven configuration is in pom.xml at the root of the project. In here you will specify a description of what the build of the project should be like.
Maven has a default build lifcycle that is documented here, this will be run against your configuration every time you run the build.

The build lifecycle is documented here: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html

The POM file format is XML, and defined here: https://maven.apache.org/pom.html

Drools
---------
The project is implemented as a domain model with basic data types for an online retail use case. In the src/main/resources section you will find a folder
with a package name on it, and underneath that a DRL file. This is where the rules for the application are defined. In addition, you will find the
configuration to make the Drools framework discover it's resources in the src/main/resources/META-INF directory. Kmodule.xml is a Drools specific
configuration file for specifying how to configure Drools packages as well as specify where to find rules resources.

Overall single page Drools documentation (includes DRL language as well as KIE API, and kmodule.xml documentation):
http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html_single/index.html

JUnit Tests
----------
Right now there isn't any real application code that uses the rules. To see an example of how you would execute rules and operate on the results there are
two JUnit tests inside of src/test/java. These unit tests will automatically run as part of the Maven build, and you can execute them directly from Eclipse
by selecting "Run as -> JUnit test" from the Dropdown menu next to the green run arrow in Eclipse.

In these test's you will see how your Java program interacts with the KIE API, which the unified API that wraps all of the various components of the Drools/JBPM suite
of products.

