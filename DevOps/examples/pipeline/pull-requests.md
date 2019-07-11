# Pull Requests
* *GitHub calls them Pull Requests (PR)*
* *GitLab calls them Merge Requests (MR)*
* GitHub feature
  * Saying I want to merge `branch b` into `branch a`
  * Gives us a place to talk about the code
  * Permissions - only certain people can approve MR

### Let's do an example

# Jenkins
If we follow **git flow** and use branchs and PRs, then we will likely want the following Jenkins jobs:

1. Job to build branches that have a PR
  * Automated tests
  * SonarQube
  * Deliver results to PR (makes your life a lot easier)
+ Job to build `master` branch and **deploy** to prod


# Notes for our git strategy
* `master` branch is always production ready code
* Always branch off `master`

Other projects may have more than one long lasting branch.  For example, `master` and `dev`.  
