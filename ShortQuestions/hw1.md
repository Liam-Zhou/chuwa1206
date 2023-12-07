# **HW1**
<!-- This content will not appear in the rendered Markdown -->

## Q1 Learn MarkDown
Please see below. For more information, checkout 
[README](../README.md)

## Q2  List the git commands you learned
The following git commands can be found at [learngitbranching](https://learngitbranching.js.org/).

- Use `git add <file>` to stage a file.

- Use `git status` to list all new or modified files that haven't yet been committed.

- Use `git commit` to commit changes.

- Use `git branch` to check all branches or create a new branch.

- Use `git checkout` to switch to a different branch or detach `HEAD` to a commit. `git checkout -b` will create a new branch and switch to this branch.

- Use `git merge` to merge current branch with another branch.

- Use `git rebase` to plug commits of branch A into branch B.

- Use `git log` to see hashes.

- Use `^`, such as `HEAD^`, to move upward one commit.

- Use `~`, such as `HEAD~4`, to move upward multiple commits.

- Use `git branch -f branchName HEAD~x` to moves the branch to x parents behind HEAD.

## Q3 What is the basic steps to init a git repo in you local 

```
mkdir my-project
cd my-project
git init
git status
git add filename
git commit -m"some notes"
git push
```

## Q4 How to clone a repo from Github 

```
git clone link_of_that_repo
```
## Q5 How to create a new branch and checkout to that branch

Checkout my answer in Q3:
> git checkout -b newBranchName

## Q6 How to merge the branch_test to master branch in command

```
git checkout master
git pull origin master
git merge branch_test
git add .
git commit -m "Merge brach_test into master"
git push origin master
```

## Q7 How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash**

```
git checkout branch_learn_stash
git stash
git checkout another-branch
git checkout branch_learn_stash
git stash pop
```

## Q8 How do you understand  **PR is based on Branch**

A PR is a feature used in collaborative development platforms. It's a request to merge code changes from one branch into another. The branch from which the PR is created is usually a separate branch in the Git repository where specific work, like adding a feature or fixing a bug, is done. A PR allows team members to review code changes in that separate branch and decide whether to merge thoes changes into the main codebase. PR and Branch both serve the porpuse of having developers work on different tasks simultaneously without interfering with the main codebase. Therefore, we can say that *PR is based on Branch*.