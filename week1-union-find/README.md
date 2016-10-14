# Specification
Here is the programming assignment [specification](http://coursera.cs.princeton.edu/algs4/assignments/percolation.html) that describes the assignment requirements.

# Grade
This implementation scored `94/100`.

# How to run the full experiment?
1- Inside the Docker container, compile the files:
```
# javac-algs4 Percolation.java PercolationStats.java
```
2- Run it passing the desired parameters:
  - n: number of sites will be n^2
  - trials: number of trials over the experiment

Interface:
```
# java-algs4 PercolationStats n trials
```

Example:

In order to run an experiment with 200^2 sites, using 100 trials:
```
# java-algs4 PercolationStats 200 100
```
