# Jenkins Configuration For a Spring Boot Application

## Introduction
This guide will walk you through a relatively simple three-teir DevOps Pipeline.  The first step will run SonarQube tests and any tests associated with the `test` Maven goal on every push to a Pull Request.  The second step will run on every push to the development branch, building the Spring Boot Application on a development server.  The third step will run on every push to the master branch, and will build the Spring Boot Application on a production server.

## Before You Begin

* This guide assumes two separate servers, one for development and testing, and one for production 
* This gudie assumes use of GitHub as source code management.  Using GitLab is similar, but uses different plugins
* On GitHub, make sure you have login credentials that have `admin` access to the repository you'll be working with. 
* You will also need an Auth token from GitHub to use with one of the configuration steps. To create this token, login to GitHub as your desired user, click on your profile picture at the top right corner and select `Settings`.  On that screen, scroll down and select `Personal access tokens` on the left navigation bar.  Now, click `Generate new token`. Give it a name, and select `admin:org_hook` and `admin:repo_hook` as permissions. Then, copy down the token that is displayed, as it won't be displayed again.
* This guide assumes that you need to set up environment variables to pass your Spring Boot self-checks
* When it comes to deploying the application, you'll need to provide Jenkins with the private key to login to the target servers to deploy the application.  You can either paste the private key in the provided box, or have the private key file on the Jenkins machine itself.



## Installing Plugins
  1. Log into Jenkins, and click on `Manage Jenkins` on the left bar.
  2. Then, click on `Manage Plugins`
  3. Go to the `Available` tab
  4. Select the following plugins:
 * Environment Injector Plugin
 * GitHub Pull Request Builder
 * Publish Over SSH
 * Quality Gates Plugin
 * SonarQube Plugin
 5. After selecting the plugins, click on `Download now and install after restart`
 6. After Jenkins restarts, go back to the `Manage Plugins` screen, and select the `Installed` tab. Verify that each of the above plugins installed successfully

 ## Configuration

 1. Log into Jenkins, and click on `Manage Jenkins` on the left bar.
 2. Click on `Configure System` (note, the ordering of the sections may be different in this guide than in your configuration page)
 3. In the `SonarQube servers`, add a SonarQube Installation. Fill in a name to be used to refer to that installation, type the URL in, and use the token you created as a Server Authentication token
 4. In the `GitHub` section, Add a GitHub server.  The URL should be `https://api.github.com`.  Click `Add` near the credentials selector to add a new set of credentials to Jenkins. On the pop up window, change the `Kind` to read `Secret Text`. The secret should be your access token to GitHub.  Also, add a description. Save the secret text and select it.  Click `Test Connection` to make sure it works.
 5. In the `Quality Gates` section, add a Sonar Instance.  Give the instance a name, point it to the URL of your SonarQube installation, and provide the login credentials
 6. In the `Publish over SSH` section, either paste your private key in the box, or point Jenkins to the private key file in the `Path to key` box.  Afer that, add SSH servers for your dev and prod environments. Provide a name for each server, the IP address, and the username to login as (for Amazon Linux instances, the default user is `ec2-user`).  Test your connections. (If you're unable to connect, one likely culrpit is a restrictive Security Group on the target instance. Allow for SSH access on the Jenkins EC2 instance, or SSH access from anywhere)
 7. In the `GitHub Pull Request Builder` section, add a new set of credentials to Jenkins. In the box that pops up, type in your username and password to GitHub.  Add those credentials, and then click `Test Credentials` to assure that is working correctly.  Change the description of the server to something more useful.
 8. Click `Save` at the bottom
 
## Tool Configuration

1. Log into Jenkins, and click on `Manage Jenkins` on the left bar.
 2. Click on `Global Tool Configuration`
 3. In the `JDK` section, click `Add JDK`. Give the installation a name, and uncheck `Install Automatically`. In the JAVA_HOME box, type `/usr/java/latest`
 4. In the `SonarQube Scanner`, add a SonarQube Scanner. Allow it to install automatically with the default settings
 5. In the `Maven` section, add a maven installation. Give it a name and allow it to install automatically with the default settings
 
 
## Job Configurations

### Feature branch test

1. On the Jenkins homepage, click `New Item` on the left.  On the screen that appears, give the job a name, and select `Freestyle Project`
2. Check off `GitHub project` and paste in the full URL, like `https://github.com/revaturelabs/AssociateSystem/`
3. In `Source Code Management` section, select Git. Paste in the full Repository URL and select your credentials.  Click `Advanced` in this box and put this in the 'Refspec' box: `+refs/pull/*:refs/remotes/origin/pr/*`.  In the 'Branch Specifier' section, put `${sha1}`.
4. In the Build Triggers section, select `GitHub Pull Request Builder`. Check off `Use github hooks for build triggering`, check off `Build every pull request automatically without asking (Dangerous!).`, and add a Whitelist Target Branches for the `development` branch. If you'd like to change the name of the status check in GitHub, change the `Trigger Setup`, and in the `Update commit status during build` section, put a name on the `Commit Status Context`.
5. In the Build Environment section, you're able to use the `Inject environment variables to the build process` to inject the environmental variables. If there's a password or other information you don't want to be visible in a long file, use the `Inject passwords to the build as environment variables` step.
6. In the Build section, add a build step called `Invoke top-level Maven targets`. Select the name of your Maven installation, and in the goals box, use `clean test`.  (If your POM file is not in the root of the project, you can specify where it's at in the `Advanced` settings)
7. In the Build section, add a build step called `Execute SonarQube Scanner`. In the Analysis Properties section, right something like:
```
sonar.projectKey=a
sonar.projectName=AssociateSystem
sonar.branch=${sha1}
sonar.sources=src/
sonar.sourceEncoding=UTF-8
```
8. In the Post-Build section, add a post-build action called `Quality Gates`. Use a project key like `a:${sha1}`.  This is a combination of the project key, a colon, and the branch.

### Deploy to Development

1. On the Jenkins homepage, click `New Item` on the left.  On the screen that appears, give the job a name, and select `Deploy to Development`
2. Check off `GitHub project` and paste in the full URL, like `https://github.com/revaturelabs/AssociateSystem/`
3. In `Source Code Management` section, select Git. Paste in the full Repository URL and select your credentials.  In the 'Branch Specifier' section, put `*/development`.
4. In the Build Triggers section, select `Build when a change is pushed to GitHub`.
5. In the Build Environment section, select `Delete workspace before build starts`
6. In the Build Environment section, you're able to use the `Inject environment variables to the build process` to inject the environmental variables. If there's a password or other information you don't want to be visible in a long file, use the `Inject passwords to the build as environment variables` step
7. In the Build section, add a build step called `Invoke top-level Maven targets`. Select the name of your Maven installation, and in the goals box, use `clean package`.  (If your POM file is not in the root of the project, you can specify where it's at in the `Advanced` settings)
7. In the Post-Build section, add a post-build action called `Send build artifacts over SSH`. Select a server, and in Source files, put `target/*.jar`. In Remove Prefix, put `target`.  If you set up your server like me, in Exec command, put `sh /home/ec2-user/deployJavaApp.sh`

### Deploy to Production

1. On the Jenkins homepage, click `New Item` on the left.  On the screen that appears, give the job a name, and select `Deploy to Production`
2. Check off `GitHub project` and paste in the full URL, like `https://github.com/revaturelabs/AssociateSystem/`
3. In `Source Code Management` section, select Git. Paste in the full Repository URL and select your credentials.  In the 'Branch Specifier' section, put `*/master`.
4. In the Build Triggers section, select `Build when a change is pushed to GitHub`.
5. In the Build Environment section, select `Delete workspace before build starts`
6. In the Build Environment section, you're able to use the `Inject environment variables to the build process` to inject the environmental variables. If there's a password or other information you don't want to be visible in a long file, use the `Inject passwords to the build as environment variables` step
7. In the Build section, add a build step called `Invoke top-level Maven targets`. Select the name of your Maven installation, and in the goals box, use `clean package`.  (If your POM file is not in the root of the project, you can specify where it's at in the `Advanced` settings)
7. In the Post-Build section, add a post-build action called `Send build artifacts over SSH`. Select a server, and in Source files, put `target/*.jar`. In Remove Prefix, put `target`.  If you set up your server like me, in Exec command, put `sh /home/ec2-user/deployJavaApp.sh`