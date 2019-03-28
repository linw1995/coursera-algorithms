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
[INFO] --- maven-checkstyle-plugin:3.0.0:check (default-cli) @ linw1995 ---
[INFO] There are 3 errors reported by Checkstyle 8.16 with /Users/linw1995/Documents/me/linw1995/src/main/resources/checkstyle-coursera.xml ruleset.
[ERROR] ../../../../../src/main/java/com/linw1995/algorithms/Permutation.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
[ERROR] ../../../../../src/main/java/com/linw1995/algorithms/Deque.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
[ERROR] ../../../../../src/main/java/com/linw1995/algorithms/RandomizedQueue.java:[1,1] (coding) IllegalToken: Do not define packages in this course. You must use the default (no-name) package in this course.
```
