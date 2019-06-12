# Maven
* Java build tool
* manage dependencies
* build our project

# Managing dependencies
* each maven project gets a `pom.xml` file
* `~/.m2/` directory

# Building
* building a project can include whatever you want
  * typically includes compiling and running tests
* the goal is to get a **build artifact**

delete `target/` directory

```
mvn clean
```

run tests

```
mvn test
```

package application

```
mvn package
```

# Lifecycle
* Maven has a default build lifecycle
* The lifecycle is made up of different phases
