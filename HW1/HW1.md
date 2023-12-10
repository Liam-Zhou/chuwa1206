### init git repo
cd /myproject
git init

### clone a repo
git clone 

### create a new branch and checkout
git branch newbranch
git checkout -b newbranch

### merge branch_test to master
git checkout master
git merge branch_test

### stash
git stash
git checkout anotherbranch
git checkout branch_learn_stash
git stash pop

### PR 
PR is "pull request". A Pull Request is a way to propose changes to a codebase in a collaborative development environment.
We can create an isolate branch, and do some changes for the code, then make a PR to merge our changes to the main branch.

### Maven
1. Manage the packages   
2. Build the Project   
3. Generate documents  
4. Reporting  

We mainly use maven to import the packages we need. We use it do the version control and build our project.

### Lifecycle of Maven

clean - validate - compile - test- package - verfiy - install - site - deploy (only test can be skipped and left to the CI/CD process)

### Difference between package and install in the lifecycle

Package phase creates teh JAR package. Install phase install the package to our local repository.

### Plugins

Maven Plugins are extending the maven.   
Surefire Plugin: Executes unit tests during the test phase.    
Compiler Plugin: Compiles Java source code during the compile phase.    
Jar Plugin: Creates a JAR (Java Archive) file for the project during the package phase.    
Javadoc Plugin: Generates Javadoc documentation for the project.    





