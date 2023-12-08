# HW1

## 1 Basic Usage of MarkDown

### Headings

Use `#` before text, can use up to 6 hashtags

### Styling text

- bold: **bold text**

- italic: *italic text*

- strikethrough: ~~striked text~~

- bold and nested italic: **bold _nested italic_ bold**

- all bold and italic: ***all bold and italic***

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

- image link: <img src="https://myoctocat.com/assets/images/base-octocat.svg" title="" alt="Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle." width="137">



### List



- unordered list
  
  - nested unordered list

- Ordered list
  
  1. item 1
  
  2. item 2



## 2 Git Commands



```git
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



```git
cd projectFolder
git init
git add .
git commit -m "init commit message"
git push origin main
```



## 4 How to clone a Repo from GitHub?



```git
git clone <remote repo url>
```



## 5 How to Create a new Branch and Checkout to that branch



```git

git branch <new_branch_name>
git checkout <new_branch_name>
```



## 6 How to merge the branch_test to master branch in command



```git
git checkout master
git pull origin master
git merge branch_test
git commit -m "merge commit message"
git push origin master
```



## 7 How to stash new code before leaving branch and pop the stash when checkout back to it



### CMD



```git
git stash save "stash msg"
git checkout <other_branch>
git checkout branch_learn_stash
git stash pop
```



### Intellij



- VCS -> Local Changes -> Shelve Changes -> Shelve

- Switch Branch

- VCS -> Unshelve Changes



## 8 How do you understand PR is based on Branch?



- To my understanding, PR is based on branch means that all the changes mentioned in the PR are included in the source branch and will be applied to a specific target branch.



## 9 What is the role of Maven? What is it used to do?



The role of Maven includes:

- Manage Dependencies(Package)

- Build Project (LifeCycle)

- Documentation 

- Reporting

- Others



## 10 Lifecycle of Maven



- clean -> prepare-resources -> validate -> compile -> test -> package -> install -> deploy



## 11 Difference between package and install in maven lifecycle



- package: creates the JAR/WAR package as mentioned in the packaging in POM.xml.

- install: installs the package in local/remote maven repository.

- package creates a new package while install simply use existing package in a local/remote repository



## 12 What is plugins in maven



- Plugins are tools that provide a specific set of goals to be executed during the build process. Maven plugins are used to perform various tasks such as compiling code, running tests, packaging applications, generating documentation, and more. Plugins are configured in the `pom.xml` file of a Maven project.

- Some Maven plugins:
  
  - Compile: Maven Compiler Plugin
  
  - Test: Maven Surefilre Plugin
  
  - Package JAR: Maven JAR Plugin
  
  - Copy dependencies: Maven Dependency Plugin
