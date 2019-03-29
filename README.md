# Algorithms - Princeton University

Thanks to Princeton University and Coursera.

## My solution for the Assignments below

### Part I

* [ ] Percolation (comming soon)
* [x] Deques and Randomized Queues
* [ ] Collinear Points
* [ ] 8 Puzzle
* [ ] Kd-Trees

## Usage

### Compile

```shell
mvn compile
```

### Execute

```shell
mvn exec:java \
    -Dexec.mainClass="com.linw1995.algorithms.Permutation"  \
    -Dexec.args=3 < src/test/resources/distinct.txt
```

### Test

```shell
mvn test
```

### Checkstyle

```shell
mvn checkstyle:check
```

will output

```plain
...
[ERROR] ../../../../../src/main/java/edu/princeton/cs/Permutation.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
[ERROR] ../../../../../src/main/java/edu/princeton/cs/Deque.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
[ERROR] ../../../../../src/main/java/edu/princeton/cs/RandomizedQueue.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
...
```
