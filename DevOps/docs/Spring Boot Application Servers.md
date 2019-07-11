# Spring Boot Application Servers

## Introduction
This is a guide to set up a sever to run a Spring Boot application

## Installation
  1. Spin up a new EC2 instance of Amazon Linux (the default image)
  2. SSH into it
  3. If you receive a message saying there are updates available, update your instance by running:
  
```sh
$ sudo yum -y update
```
  4. Install Oracle JDK8. Google `Oracle JDK`, and download the Linux x64 version that is in `.RPM` format. To get it to your instance, you can download it and use `WinSCP` (or PSCP, Putty's SCP client, or SFTP) to upload it to the machine.  Once uploaded run:
   ```sh
$ sudo rpm -ivh jdk.rpm
``` 

(replacing `jdk.rpm` with the name of the file you uploaded)

6. After installing JDK, create an environmental variable that points to the installation of JDK. To do that, run:
  
```sh
$ sudo vim /etc/environment
```  

and add the following line:

```
JAVA_HOME=/usr/java/latest
```

## Automation Scripts

I have three scripts on my server: `StartJavaApp.sh`, `DeployJavaApp.sh`, and `DeployJavaApp.sh`. Start and stop are obvious. My `Deploy` script is run whenever an automation step copies a jar to the machine, and is expected to rename the file coming in and take care of any other configuration issues, run the stop process, and start the application.

### StartJavaApp.sh
```sh
nohup sudo java -jar app.jar > logForApp.log &
```

### StopJavaApp.sh
```sh
sudo kill $(ps aux | grep '[j]ava' | awk '{print $2}')
```

### DeployJavaApp.sh
```sh
sudo kill $(ps aux | grep '[j]ava' | awk '{print $2}')
mv rev* app.jar
sh ~/startJavaApp.sh
```

### Explainations
* I use `[j]ava` so as not to kill the actual `grep` process while searching to kill a java process
* The `rev*` assumes that any jar file that comes into the server starts with 'rev'. We rename it to 'app' to keep things simple