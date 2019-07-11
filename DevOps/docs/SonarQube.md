# SonarQube

## Introduction
[SonarQube](http://www.sonarqube.org/) is a tool for code analysis. It analyzes Java, Javascript, and other languages, automatically finding bugs, vulnerabilities, code smells (code that works, but may not be using best practices), and code duplication.  It also tracks elements over time.


## Before you start

- SonarQube likes to have an external database to store any persistant information. Consider which database to use before your start.  This guide will conect to an Oracle database and detail the special procedures used for connecting to that type of database.  Using MySQL would most likely be easier, but it was not explored for this guide.  More information about which database systems are valid can be found [here](http://docs.sonarqube.org/display/SONAR/Requirements)
- In most guides, a linux shell command starts with a `$`. If you're typing a command into a console, don't include the `$`
- This guide assumes you're comfortable with `VI`/`VIM`, some terminal-based text editors.  Feel free to use other text editors, such as `nano` if you're more comfortable with that environment

## Installation
  1. Spin up a new EC2 instance of Amazon Linux (the default image)
  
(Assign your security groups dilligently! If you're going to be using port 80 or 9000 later on, make sure they're open to the public)
  2. SSH into it
  3. If you receive a message saying there are updates available, update your instance by running:
  
```sh
$ sudo yum -y update
```
  4. Run the following commands:
  
  ```sh
$ wget -O /etc/yum.repos.d/sonar.repo http://downloads.sourceforge.net/project/sonar-pkg/rpm/sonar.repo
$ sudo yum -y install sonar
```  
  
  (More information about installing SonarQube as a service can be found [here](http://sonar-pkg.sourceforge.net/))
  
  
## Configuration (Oracle Database)
  
  
  
  [Source](https://obscuredclarity.blogspot.com/2012/05/install-sonar-using-oracle-as-database.html)
  
  
  5. Download the `ojdbc6.jar` driver from [here](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html)
  6. Get it onto the instance and place the jar file in `/opt/sonar/extensions/jdbc-driver/oracle/` (Note: you'll probably have to be `sudo` to copy it, since `/opt` is probably write-protected for normal users)
  7. Run:
  
  ```sh
  $ sudo vim /opt/sonar/conf/sonar.properties
  ```
  8. In the properties file, write something similar to this:
  
  ```
sonar.jdbc.url=jdbc:oracle:thin:@$AddressOfOracleDatabase:1521/$nameOfSID
sonar.jdbc.driverClassName: oracle.jdbc.OracleDriver
sonar.jdbc.validationQuery: select 1 from dual
sonar.jdbc.username=$Username
sonar.jdbc.password=$Password
  ```
  Where:
  - $AddressOfOracleDatabase is the web address of the database
  - $nameOfSID is the SID of the database you're using
  - $Username is the username of the user you set up for the SonarQube application (it is **highly** recommended to have a separate user set up for SonarQube)
  - $Password is the password for that user

SonarQube is now ready to be run. SonarQube defaults to port `9000`, and the default login is `admin`, with a password of `admin`.  To run, use:

```sh
$ sudo service sonar start
```

To stop, run: 

```sh
$ sudo service sonar stop
```

## Configuration (Using Port 80)

HTTP requests default to port 80.  It's good practice to use a reverse proxy to redirect traffic from port 80 to port 9000, but that was not known at the time of setting this server up.  Here's the configuration steps to put this server on port 80.
9. Edit your `sonar.properties` file by running:

```sh
$ sudo vim /opt/sonar/conf/sonar.properties
```

10. Change `sonar.web.port=9000` to `sonar.web.port=80`

Any program that tries to access a port below 1024 needs to be run as `root`.  Because of this, the way you start the server needs to change. To run the server, run:
```sh
$ sudo /opt/sonar/bin/linux-x86-64/sonar.sh start
```
To stop the server, run:
```sh
$ sudo /opt/sonar/bin/linux-x86-64/sonar.sh stop
```

## Setting up SonarQube

One important thing to do is to create a separate user on this server that will be used to interact with Jenkins.

1. Open your favorite web browser and navigate to the IP address of your server (or port 9000 of the IP address if you chose to omit the port 80 steps)
2. At the top right-hand corner, login as `admin`, using the password `admin`.
4. Logged in as the administrator, go to `Security`, then `Users`
5. Select `Create User`, and creata a for Jenkins to connect to
6. To the right of the user you just created, There will be a `Tokens` column. Click on the hamburger button to the right of the user, and generate a token (the name of which doesn't necessarily matter).  Once you create it, copy it down somewhere safe so you may reuse it later in this guide.