# threads
* multiple flows of control
* each thread gets its own **stack**
* `Thread` class
  * worker
* `Runnable` interface
  * job

# main thread
* you *always* have a **main** thread
* first method on stack is `public static void main(String[])`

# other threads
* first method on stack is `run` method

# start
* when you call `start`, a new thread is created and `run` is put on the new stack

# JVM Thread Scheduler
* as a developer, you have no control over when threads are given CPU cycles

# example

```
class DogRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("\tdog");
		}
	}

}

public class Example {
	public static void main(String[] args) {
		Runnable job = new DogRunnable();
		Thread worker = new Thread(job); //give worker a job
		worker.start();

		for(int i = 0; i < 50; i++) {
			System.out.println("main");
		}
	}
}
```

# thread states
* NEW
* RUNNABLE
* BLOCKED
* WAITING
* TIMED_WAITING
* TERMINATED
  * cannot restart thread

# priority
* 1-10
* `setPriority(int)`

# daemon vs user threads
* **daemon** is meant to indicate a background process
  * for example: the Garbage Collector is a daemon thread
* `setDaemon(boolean)`
* the JVM terminates when there are no more **user** threads

# producer consumer
* common thread idiom
* one thread produces things
* one thread consumes things

# Executor Framework
* makes handling threads much easier
* similar to what the Collections Framework did for data structures
