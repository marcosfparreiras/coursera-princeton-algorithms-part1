# Specification
Here is the programming assignment [specification](http://coursera.cs.princeton.edu/algs4/assignments/percolation.html) that describes the assignment requirements.

# How to run the full experiment?
1- Inside the Docker container, compile the files:
```
javac-algs4 Percolation.java \
            PercolationStats.java \
            PercolationClient.java \
            PercolationStatsClient.java
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
# java-algs4 PercolationClient 200 100

Experiment size: n = 200; trials = 200
mean: 0.592775
stddev: 0.036253
95% confidence interval: 0.587751, 0.597799
```

# How to run the test instance for Percolation?
```
# java-algs4 PercolationClient

Initial Configuration
  0  0  0
  0  0  0
  0  0  0
--------------------

Intermediary Configuration
  0  1  0
  1  0  0
  0  0  0
(2,2) is open?, false
(2,2) is full?, false
--------------------

Final Configuration
  0  1  0
  1  1  1
  0  0  1

(2,2) is open?, true
(2,2) is full?, true
percolates?, true
--------------------
```

