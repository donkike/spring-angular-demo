Spring/Angular Demo
===================

This is a sample application showing how to integrate [AngularJS](https://angularjs.org/) with a RESTful API developed in Java using [Spring Framework](http://spring.io/). You can read the tutorial [here](http://example.com).

Requirements
------------

This project uses [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [PostgreSQL](http://www.postgresql.org/) and requires [Maven](http://maven.apache.org/) to build. Also, you need to have the database created and configured as explained in the tutorial.

Run
---

You can start the application using the [Jetty plugin for Maven](http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html), just execute `mvn jetty:run`. Otherwise, the build produces a container-independent **WAR** that you can deploy to any servlet container.

Use
---

If you used the Jetty plugin, navigate to [http://localhost:8080](http://localhost:8080) to watch it work. Otherwise, refer to your servlet container's documentation to check the deployed url.

License
-------

This project is released under the [BSD 2-Clause License](http://opensource.org/licenses/BSD-2-Clause). Read the [LICENSE.txt](LICENSE.txt) file for details.

