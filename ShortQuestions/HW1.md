# HW1

2. practice git using the platform. list the git commands you learned

   ```
   git commit
   
   git branch, git checkout
   
   git merge
   
   git rebase
   
   git clone
   
   git fetch
   
   git push
   
   git pull
   ```

   

3. What is the basic steps to init a git repo in you local ?

   ```
   git init
   
   git clone
   ```

   

4. How to clone a repo from Github ?

   set ssh first
   type "git clone xx" in the terminal, xx is the generated ssh link

5. How to create a new branch and checkout to that branch ?

   ```
   git branch branch_name
   
   git checkout branch_name
   ```

   

6. How to merge the branch_test to master branch in command ? show me the commands

   (if branch_test and master already exists)

   ```
   git checkout master
   
   git merge branch_test
   ```

   

7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

   ```
   git stash save "stash"
   
   git checkout newbranch
   
   git checkout branch_learn_stash
   
   git stash pop
   
   
   ```

   

8. How do you understand PR is based on Branch?

   When you are creating a PR, you are actually merge the changes from one branch to another branch.

9. What is maven role ? what it be used to do ?

   Maven is used for dependency management and project life cycle management. In short, we use maven because it can download add and remove the dependencies and libraries easily.

10. What is the lifecycle of maven? could you tell me the details ?

    - prepare resources: In this phase, resource copying can be customized.

    - validate: validates if the project is correct and if all necessary infomation is available.

    - compile: source code compilation.

    - test: tests the compiled source code suitable for testing framework.

    - package: creates the JAR/WAR package.

    - install: installs package in local or remote maven repository.

    - deploy: copies the final package to the remote repository.

11. what is the difference between package and install in maven lifecycle ?

    Package:

    - Not install anything in the local repository.
    - Artifact locates in the target directory.

    Install:

    - Takes the package generated inthe package phase and installs it into the local Maven repository, making it available as a dependency for other projects on the same machine.
    - Artifact locate in the local Maven repository.

12. What is plugins in maven, list some plugins.

    Plugins finish and execute tasks for Maven.

    - compile
    - validate
    - test
    - clean
    - clean package
    - clean install
    - clean deploy
    - verify

13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:

    This is the project I created.
    ![image-20231207162217246](/Users/yinchen/Library/Application Support/typora-user-images/image-20231207162217246.png)
