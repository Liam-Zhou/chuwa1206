# 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

some basic usages used in the README.md are:

# head1

## head2

### head3

`code block sample`

I will apply those usuage in my .md file as well.

# 2.practice git using the platform. list the git commands you learned

I learned some basic commands such as :

1. git init - to initlize a repo
2. git status - to check the status of the repo
3. git add . - to add all the changes into the staging area
4. git branch -b - to make a new branch
5. git checkout - to switch between branches
6. git push upstream - to push your local changes into the remote repo

# 3. What is the basic steps to init a git repo in your local?

1. first go to a directory in your local machine, for example

   ` cd my-project`

2. then type `git init` to initialize the Git repository

# 4. How to clone a repo from Github?

simply

`git clone https://github.com/username/repository.git`

# 5. How to create a new branch and checkout to that branch?

`git checkout -b new branch`

# 6. How to merge the branch_test to master branch in command? show me the commands

```
git checkout master
git pull origin master
git merge branch_test //may need to resolve conflict to continue
git push origin master
```

# 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to \*\*branch_learn_stash? try commands way and intellij way.

```
git stash
git checkout master // switching branch
git checkout branch_learn_stash
git stash pop

```

# 8. How do you understand PR is based on Branch?

it's becasue pull request is oftern used used to propose merging those changes into the main branch, if you don't specify which branch we are based on, then the PR is meaingless.

# 9. What is maven role? what it be used to do ?

it's a package management and build tool set, just like npm in node.js.It helps manage dependencies, streamline builds, enforce project structures, and improve overall project organization and collaboration.

# 10. What is the lifecycle of maven? could you tell me the details?

The Maven build lifecycle is divided into three main lifecycles, each made up of various phases,

## Clean Lifecycle:

clean: Deletes the target directory.
Default Lifecycle:

## Default lifecycle

validate: Validates project structure.
compile: Compiles source code.
test: Runs unit tests.
package: Creates a distributable package.
verify: Checks integration test results.
install: Installs the package locally.
deploy: Copies the package to a remote repository.

## Site Lifecycle:

site: Generates project documentation.
site-deploy: Deploys documentation.

# 11. What is the difference between package and install in maven lifecycle?

the key difference is that the package phase creates the distributable artifact in the target directory, while the install phase additionally installs that artifact in the local Maven repository, making it available for use by other projects on the same machine.

# 12. What is plugins in maven, list some plugins.

plugins in maven provide some specific goals or tasks to the build lifecycle.

some are:

- clean plugin,
- surefire plugin,
- compiler plugin,
- deploy plugin.

# 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:

1. groupID: com.chuwa.learn
2. artifactID: java-core

# 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.
