#hw1
### 1. Learn markdown and show all the basic usage
### 2. Practice git using the platform
```
git commit
git branch
git checkout <branch_name>
git checkout -b <branch_name>
git merge
git rebase
git log
^ (refer to parent): git checkout HEAD^
~<num> (num steps up): git checkout HEAD~4
git branch -f main HEAD~3
git reset
git revert
git cherry-pick
git fork
git fetch
```
### 3. The basic steps to init a git repo
```
git init
git add.
git commit -m "commit message"
```
### 4. clone a repo from github
```
git clone https://github.com/...
```
### 5. create a new branch and checkout to the branch
```
git checkout -b <new_branch>
```
### 6. merge the branch_test to master
```
git checkout master
git merge branch_test
```
### 7. stash the new code before leaving branch_learn_stash and pop the stash when checkout back to **branch_learn_stash
```
git checkout branch_learn_stash
...
git stash
...
git checkout branch_learn_stash
git stash pop
```
In intellij, do Git -- stash change to stash the changes and do Git -- unstash changes to pop the stash
### 8. how to understand PR is based on branch
PR is used to merge the changes on one branch to the other branch.
### 9. what is maven role? 
maven is a build automation tool used primarily for Java projects.
Maven is used to manage the dependencies and to build the project. It also allows documentation and reporting.
### 10. what is the lifecycle of maven and the details
- validate: validate the project is correct
- compile: compile the source code
- test: run test for the compiled code
- package: package the compiled code in the distributable format
- verify: verify if the project meet the criteria
- install: install the package into the local repository
- deploy: copy the final package to the remote repository
### 11. difference between package and install
package step will package the code in a distributable format while install will install the package to the local repository.
### 12. what is plugins, list some plugins in maven
- plugins are the central feature of Maven that allow for the reuse of the common build logic across multiple projects.
- maven_war_plugin
- maven-deploy-plugin
- maven-jar-plugin
- maven-dependency-plugin
- maven-compiler-plugin
