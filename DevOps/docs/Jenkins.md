# Jenkins

## Introduction
[Jenkins](http://www.sonatype.org/nexus/) is an automation tool that can automate almost any task.

## Before you start

- In most guides, a Linux shell command starts with a `$`. If you're typing a command into a console, don't include the `$`
- This guide assumes you're comfortable with `VI`/`VIM`, some terminal-based text editors.  Feel free to use other text editors, such as `nano` if you're more comfortable with that environment

## Installation
  1. Spin up a new EC2 instance of Amazon Linux (the default image)
  2. SSH into it
  3. If you receive a message saying there are updates available, update your instance by running:
  
```sh
$ sudo yum -y update
```

  4. Install Git on your Jenkins instance by running:
  
  ```sh
  $ sudo yum -y install git
  ```

  5. Install Oracle JDK8. Google `Oracle JDK`, and download the Linux x64 version that is in `.RPM` format. To get it to your instance, you can download it and use `WinSCP` (or PSCP, Putty's SCP client, or SFTP) to upload it to the machine.  Once uploaded run:
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

7. Go to Jenkin's Homepage and copy the link for a War file distribution of Jenkins.  Download it to your machine with the following command:
 
```sh
$ wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war
```


## Configuration (Using Port 80, setting time zone, and running in the background)

HTTP requests default to port 80.  It's good practice to use a reverse proxy to redirect traffic from port 80 to port 8080, but that was not known at the time of setting this server up.  In addition, it is advantagous to set the timezone of the Jenkins instance to make dates and times more readable to the end-user.  Lastly, the running instance of Jenkins shouldn't be killed when the SSH session is finished, so we will be using `nohup` to run the application such that it will ignore the hangup signal ("run in the background").  Luckily for us, most of these properties can be set simply by using correct arguements when running the application. To run Jenkins on port 80, using Eastern timezone, with no hangup, run:

```sh
$ sudo nohup java -Dorg.apache.commons.jelly.tags.fmt.timeZone=America/New_York -jar jenkins.war --httpPort=80 &> logForJenkins.log &
```

Breaking this command down,
* `sudo` runs the command as a super-user. This is necessary to run on a port below 1024
* `nohup` tells the applciation to ignore the hangup signal. This allows the program to run in the background
* `java` says to use Java
* `-Dorg.apache.commons.jelly.tags.fmt.timeZone=America/New_York` tells us to use the Eastern timezone
* `-jar jenkins.war` tells java to run the WAR file
* `--httpPort=80` tells Jenkins which port to run on
* `&>` tells the shell to redirect standard output and error output to some location
* `logForJenkins.log` is the text file where we're going to redirect the output
* `&` tells the program to run in the backround

Stopping the server is as simple as finding a running process that is named Jenkins, and killing it. The command for that is:

```sh
$ sudo pkill -f jenkins
``` 

## Running for the first time

1. Run the start command as described above
2. Navigate to the IP address of the instance you're running on
3. The first screen will ask you for your security token. You can either find that by looking through the `logForJenkins.log` file, or by running:

```sh
$ sudo cat /root/.jenkins/secrets/initialAdminPassword
```

4. Install the suggested plugins, and create login credentials for you to access Jenkins