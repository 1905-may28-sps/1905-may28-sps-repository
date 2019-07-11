# Nexus 2

## Introduction
[Nexus](http://www.sonatype.org/nexus/) is a private repository manager. It allows for dependency management and release archival.

## Before you start

- In most guides, a Linux shell command starts with a `$`. If you're typing a command into a console, don't include the `$`
- At the time of writing, Nexus 3 is available, but there was significantly less documentation available for it.  For stability and to make troubleshooting future issues easier, this guide will use Nexus 2.
- This guide assumes you're comfortable with `VI`/`VIM`, some terminal-based text editors.  Feel free to use other text editors, such as `nano` if you're more comfortable with that environment

## Installation
  1. Spin up a new EC2 instance of Amazon Linux (the default image)
  2. SSH into it
  3. If you receive a message saying there are updates available, update your instance by running:
  
```sh
$ sudo yum -y update
```
  4. Copy the tar.gz download link for `Nexus Repository Manager OSS 2.x' from [this page](https://www.sonatype.com/download-oss-sonatype).  Use wget to download it:
  
  ```sh
$ wget http://www.sonatype.org/downloads/nexus-latest-bundle.tar.gz
$ tar -zxvf nexus-2.14.1-01-bundle.tar.gz
```  

Nexus is now ready to be run. Nexus defaults to port `8081`, and the default login is `admin`, with a password of `admin123`.  To run, use:

```sh
$ sh /home/ec2-user/nexus-2.14.1-01/bin/nexus start
```

To stop, run: 

```sh
$ sh /home/ec2-user/nexus-2.14.1-01/bin/nexus stop
```

(Note, your version number may be different than the one in this guide.  Be intelligent about your copy/pasting)

## Configuration (Using Port 80)

HTTP requests default to port 80.  It's good practice to use a reverse proxy to redirect traffic from port 80 to port 8081, but that was not known at the time of setting this server up.  Here's the configuration steps to put this server on port 80.
5. Edit your `nexus.properties` file by running:

```sh
$ vim ~/nexus-2.14.1-01/conf/nexus.properties
```

6. Change `application-port=8081` to `application-port=80`

Any program that tries to access a port below 1024 needs to be run as `root`.  Because of this, the way you start the server needs to change. What's more, Nexus **REALLY** doesn't like being run as `root`.  To placate Nexus being run as root, you need to include an environmental variable to show how serious you are about doing this.  To do this:

```sh
$ sudo sh /etc/environment
```

Then, add one line:

```
RUN_AS_USER=root
```

After that's done, to run the server, run:

```sh
$ sudo sh /home/ec2-user/nexus-2.14.1-01/bin/nexus start
```
To stop the server, run:

```sh
$ sudo sh /home/ec2-user/nexus-2.14.1-01/bin/nexus stop
``` 



