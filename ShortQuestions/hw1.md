# HW1
## 1 Learn MarkDown
*This* will show through the **homework**
>The homework was finished by [Hongyu Xiang](https://github.com/JacksonRed)

## 2 list the git commands you learned


```
git init
git add
git status

git commit
git branch <branch name>
git checkout <branch name>
git merge
git rebase
git branch -f
git rebase -i
git reset
git revert
git cherry-pick
git tag

git clone
git fetch
git pull
git push

```

## 3 What is the basic steps to init a git repo in you local ?

```
git init
git add <filename>
git commit -m 'commit message'
git push
```

## 4 How to clone a repo from Github ?
```
git clone <link to repo>/ssh
```

## 5 How to create a new branch and checkout to that branch ?

```
git branch <branch name>
git checkout <branch name>
```

## 6 How to merge the branch_test to master branch in command ? 

```
git checkout master
git merge branch_test
git commit
git push origin master
```

## 7 How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? 

### Command Ways
```
git checkout branch_learn_stash
git stash

git checkout <branch name>

git checkout branch_learn_stash
git stash pop
```
### Intellij Ways

1. Stash Changes
   - **Git** >**Stash Changes**
   - click **Stash**

1. Switch branches
   - **Git** >**Branches**
   - click **Checkout**

1. Pop Stash
   - **Git** >**Stash Changes**
   - click **Apply Stash**

## 8 How do you understand PR is based on Branch ?
>A Pull Request (PR) is a request to merge changes from source branch into atrget branch in a Git repository. The PR is based on the source branch, and its purpose is to review these changes before merging them into the target branch.

## 9 What is maven role ? what it be used to do ?
Maven is a build automation tool and project management tool used in software development. Its role is to manage dependencies, compile code, run tests, and package projects. It is used to streamline the build process, manage project dependencies, and facilitate project lifecycle tasks.

## 10 What is the lifecycle of maven? could you tell me the details ?
- **validate**: Check whether the project is correct 
- **compile**: Compiles source code
- **test**: Run tests on compiled code
- **package**: Package compiled code to a distribute format (**JAR**)
- **verify**: Run checks on package to ensure its quality
- **install**: Install the package into the local repository for use in other projects
- **deploy**: Copy the final package to a remote repository

## 11 What is the difference between package and install in maven lifecycle ?
- The **package** phase creates a distributable package (**JAR**) of the project
- The **install** phase copies that package to local Maven repository. 

> The difference is that **package** focuses on **creating the package**, while **install** focuses on making it available for **reuse** in other projects on local machine.

## 12 What is plugins in maven, list some plugins


Maven plugins extend build functionality by executing specific tasks at different build phases.

+ maven-compiler-plugin: Compile Java code
+ maven-surefire-plugin: Run unit tests
+ maven-jar-plugin: Generate JAR files
+ maven-dependency-plugin: Manage project dependencies



