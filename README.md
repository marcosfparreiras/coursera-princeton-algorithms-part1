# About it
This project holds the assignments for the course Algorithms, part 1, from Princeton University on Coursera. The course can be reached [clicking here](https://www.coursera.org/learn/introduction-to-algorithms/home/welcome).

# Running the test application to explore the Checkstyle and Findbugs
Go to the hello directory:
```
cd /usr/src/hello
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
root:/usr/src/hello username$ checkstyle-algs4 HelloWorld.java
Running checkstyle on HelloWorld.java:
Starting audit...
Audit done.
```

To run Findbugs, type the following command in the Terminal:
```
root:/usr/src/hello username$ findbugs-algs4 HelloWorld.class
Running findbugs on HelloWorld.class:
```