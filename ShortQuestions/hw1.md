# HW1

## 1 Basic Usage of MarkDown

### Headings

Use `#` before text, can use up to 6 hashtags

### Styling text

- bold: **bold text**

- italic: _italic text_

- strikethrough: ~~striked text~~

- bold and nested italic: **bold _nested italic_ bold**

- all bold and italic: **_all bold and italic_**

- subscript: This is <sub>subscript</sub>

- superscript: This is <sup>superscript</sup>

### Quoting

> Quoting text

- inline `quoting code`

```java
for (int i = 0; i < 3; i++) {
    System.out.println("text");
}
```

### Links

- External link: [Basic writing and formatting syntax - GitHub Docs](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)

- Section link: [link to the heading section](#Headings)

- Relative links: [Project Readme](../README.md)

- image link: <img src="https://myoctocat.com/assets/images/base-octocat.svg">

### List

- unordered list

  - nested unordered list

- Ordered list

  1. item 1

  2. item 2

## 2 Git Commands

```sh
git init
git add
git status
git commit
git branch
git checkout
git merge
git rebase
git reset
git revert
git cherry-pick
git clone
git fetch
git pull
git push
```

## 3 Basic Steps to Init a Git Repo Locally

```sh
cd projectFolder
git init
git add .
git commit -m "commit message"
```

## 4 How to clone a Repo from GitHub?

```sh
git clone <remote repo url>
```

## 5 How to Create a new Branch and Checkout to that branch

```sh
git checkout -b new_branch
```

## 6 How to merge the branch_test to master branch in command

```sh
git checkout master
git pull
git merge -m "merge message" branch_test
```

## 7 How to stash new code before leaving branch and pop the stash when checkout back to it

### CMD

assuming we started on branch1

```sh
git stash
git checkout branch2
git checkout branch1
git stash pop
```

### Intellij

- Git -> uncommitted changes -> Stash Changes

- Switch Branch (to branch2)

- Switch Branch (to branch1)

- Git -> uncommitted changes -> Unstash Changes

## 8 How do you understand PR is based on Branch?

- To my understanding, PR is based on branch means that all the changes mentioned in the PR are included in the source branch and will be applied to a specific target branch.

## 9 What is the role of Maven? What is it used to do?

Maven's purpose is to provide developers with: A comprehensive, maintainable, reusable, and simple model for projects.
Main functionalities of Maven include: package management, build, and report generating.

## 10 Lifecycle of Maven

1. clean
2. prepare-resources
3. validate
4. compile
5. test
6. package
7. install
8. deploy

## 11 Difference between package and install in maven lifecycle

- package: creates the JAR/WAR package as mentioned in the packaging in POM.xml.

- install: installs the package in local/remote maven repository.

## 12 What is plugins in maven

- Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects. They do this by executing an "action" (i.e. creating a WAR file or compiling unit tests) in the context of a project's description - the Project Object Model (POM). Plugin behavior can be customized through a set of unique parameters which are exposed by a description of each plugin goal (or Mojo).

- Some Maven plugins:
  - clean
  - compiler
  - deploy
  - failsafe
