# SimpleRestArchetype
A maven archetype to quickly setup a RESTful webservice powered by Jetty + Jersey + Spring DI

# Why a maven Archetype?
Because I'm lazy and I want to have a simple way to quickly spin up a REST server and start prototyping.

# What does the archetype create?
It creates a simple maven application composed of a parent pom and two modules: client and server. 
The client at the moment is empty.

The server module uses Jetty 9 as a container and Jersey 2.18 to manage the REST endpoints. The dependency injection is managed by Spring 4 and the Spring context is hooked to the Jersey servlet context, so to be able to inject Spring beans inside the Jersey resources.

The Jetty server is configured and started by the main method.

The archetype creates also a sample test that starts up the real Jetty server, so each test is potentially able to verify the actual behaviour of the production application.

# How to use it
Download the archetype.
```
cd <path-to-downloaded-folder>/SimpleRestArchetype
mvn install
cd <folder-where-you-want-to-create-the-project>
mvn archetype:generate -DarchetypeCatalog=local
```
and then input the number related to the downloaded archetype.
