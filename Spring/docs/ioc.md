# Inversion of Control (IoC)
* [useful article](http://www.javaworld.com/article/2071914/excellent-explanation-of-dependency-injection--inversion-of-control-.html)
* **Hollywood Principle:** Don't call us, we'll call you
* IoC is a concept to reduce spaghetti dependencies

# Dependency Injection (DI)
* An implementation of IoC
* Do not call your dependencies.  We will give them to you at creation time.

# How does Spring relate to these concepts
* Spring is a Java Framework that makes DI easy for developers
* The Spring container creates and stores dependencies for us, and injects them into objects

### quote by Craig Walls
* one of the original founders of Spring

"Any nontrivial application is made up of two or more classes that collaborate with each other to perform some business logic. Traditionally, each object is responsible for obtaining its own references to the objects it collaborates with (its dependencies). When applying DI, the objects are given their dependencies at creation time by some external entity that coordinates each object in the system. In other words, dependencies are injected into objects."

# Types of DI
* setter injection
* constructor injection
* interface injection *(not supported by Spring)*
