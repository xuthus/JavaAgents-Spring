## Java Agents demo

#### with Spring context initialization inside of the agent

(successful story)

(preface)

Someday I need to run some code in the existing java application...

(main story)

This demo application consists of 2 modules:
* one for the java agent;
* another one for the testing application.

Project contains a lot of messy code to show some information about an environment of the java agent.

What did I dig?

1. java agents run in the same class path like the main application. App has access to agent classes, the agent has access to app classes;
2. java agents use application class loader - same as in main applications;
3. java agents can implement Instrumentation API but it is not obligatory.

In this example java agent initializes Spring context, and stores it in static field.
The java agent finds class by interface described in the agent but implemented in the application, and calls its method.

Main application uses already initialized Spring context to get the same class instance and run it.

**to run example** build the code using maven:

`mvn clean package`

then copy all jars to `test` folder and run `testagent.cmd` (`testagent.sh`)


(conclusion)

It works :) 