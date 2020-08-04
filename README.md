# Reactive agent template

This is a template for a reactive agent, for students of an Intelligent Agents
or introduction to Artificial Intelligence course.

It uses the Logist platform that was developed by people at the EPFL lab on top
of the Repast simulation platform.

To run this project, you just need to execute

    gradlew run

on Windows, or

     ./gradlew run

on a UNIX operating system.

The command line arguments can be edited in the `build.gradle` file:

    run.setArgsString('-a config/agents.xml config/reactive.xml reactive-random')

New agents should be added to the `config/agents.xml` file, and the agent's
participation should be triggered by adding the name of the agent to the end
of the argument list.
