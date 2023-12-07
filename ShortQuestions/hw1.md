1. What is the basic steps to init a git repo in you local ?

   git init

2. How to clone a repo from Github ?

   git clone \<url\>

3. How to create a new branch and checkout to that branch ?

   git branch \<branch_name>\
   git checkout \<branch_name>

4. How to merge the branch_test to master branch in command ? show me the commands

   git checkout master\
   git merge branch_test

5. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
   checkout back to \*\*branch_learn_stash ? try commands way and intellij way.

   git stash\
   git stash pop

6. How do you understand PR is based on Branch?

   We can submit PR to any branches.

7. What is maven role ? what it be used to do ?

   Maven is used for managing dependencies and building projects.

8. What is the lifecycle of maven? could you tell me the details ?

   - prepare-resources

     copy resources

   - validate

     check project syntex error

   - compile

     compile source code into bytecode

   - test

     test source code using appropriate unit test framework

   - package

     package compiled code into distributable format such as jar

   - install

     install package into local repository

   - deploy

     copies final package into remote repository

9. what is the difference between package and install in maven lifecycle ?

   **package** generates JAR/WAR packages\
   **install** installs the package into local/remote maven repository

10. What is plugins in maven, list some plugins.

    Maven executes actions using the plugins.\
    Maven plugins include clean and compiler
