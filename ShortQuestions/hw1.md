# HW1  Hanyun Zhao

## Q1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

completed



## Q2. practice git using the platform. list the git commands you learned

- git clone

- git branch

  - no args: show curr branch
  - with name: create new branch
  - -d: delete (-D: force)

- git checkout -b branchName

- git commit -m 'comment'

- git push remoteRepoName myBranch

- git pull remoteRepoName myBranch

  

## Q3. What is the basic steps to init a git repo in you local ?

```shell
git init # create a new repo under curr dir
git add . # stage all files
git commit -m 'comment'
git push
```



## Q4. How to clone a repo from Github ?

```  shell
git clone url
```



## Q5. How to create a new branch and checkout to that branch ?

```shell
git branch newBranch
git checkout newBranch

# equals to
git checkout -b newBranch
```



## Q6. How to merge the branch_test to master branch in command ? show me the commands

```shell
git checkout master
git pull origin
git merge branch_test
```



## Q7. stash
How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to **branch_learn_stash** ? try commands way and intellij way.

``` shell
git stash
git checkout otherBranch
git checkout branch_learn_stash
git stash pop
```



for Intellij, use version control tool and it support git



## Q8. How do you understand PR is based on Branch?

When trying to merge feature branch into base branch, a PR is raised. The author of the base branch can then decide to pull your change to the base branch



## Q9. What is maven role ? what it be used to do ?

Maven is a build automation and project management tool for JAVA project. Maven can help compile, packaging, and install all dependencies of the project instead of doing it by hand. It also help manage project architecture.



## Q10. What is the lifecycle of maven? could you tell me the details ?

Starting from a clean build env, first prepare the resource(copying), next validate if the resources are correct, then compile. After that test step will run the unit tests, and package will pack the pj as configured in POM.xml. Finally install and deploy(upload to remote)



## Q11. what is the difference between package and install in maven lifecycle ?

package step creates JAR/WAR packages configured in POM.xml, and install step will install it locally or remotely. 



## Q12. What is plugins in maven, list some plugins.

They provides extra function like build, run, clean in maven lifecycle. 

Some plugins: maven-compiler-plugin, maven-dependency-plugin, maven-checkstyle-plugin