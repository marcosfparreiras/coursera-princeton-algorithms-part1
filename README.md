# About it
This project holds the assignments for the course Algorithms, part 1, from Princeton University on Coursera. The course can be reached [clicking here](https://www.coursera.org/learn/introduction-to-algorithms/home/welcome).

# Running the test application to explore the Checkstyle and Findbugs inside the Container
If you don't have Docker installed, please checkout the installation guide for [Docker](https://docs.docker.com/engine/installation/) and [Docker Compose](https://docs.docker.com/compose/install/).

Once you have both installed, set the container up by building and running it and:
```
user@local$ docker-compose build java
user@local$ docker-compose run java
```

A terminal will be opened for your container image.

Go to the hello directory:
```
root# cd /usr/src/hello
```

Compile it by typing the javac command below:
```
root:/usr/src/hello# javac HelloWorld.java
```

Run it, by typing the java command:
```
root:/usr/src/hello# java HelloWorld
Hello, World
```

To run Checkstyle, type the following command in the Terminal:
```
root:/usr/src/hello# checkstyle-algs4 HelloWorld.java
Running checkstyle on HelloWorld.java:
Starting audit...
Audit done.
```

To run Findbugs, type the following command in the Terminal:
```
root:/usr/src/hello# findbugs-algs4 HelloWorld.class
Running findbugs on HelloWorld.class:
```
