# hw1

## 1. Learn Markdown

# A first-level heading

## A second-level heading

### A third-level heading

**This is bold text** _This text is italicized_ ~~This was mstaken text~~ **This text is _extremely_ important** 

*** All this text is important*** This is a <sub>subscript</sub> text This is a <sup>superscript</sup> text

> Text that is a quote

```
Quoting code
```

The background color is `#ffffff` for light mode and `#000000` for dark mode.

Link [Google](https://google.com)

- List1
- List2
- List3

1. List1
2. List2
3. List3

1. First list item
   - First nested list item
     - Second nested list item

- [x] Task list1
- [ ] Task list2

## 2. Practice git

- Git Commit
- Git Bracnh
- Git Merge
- Git Rebase

## 3. What is the basic steps to init a git repo in you local ?

```shell
mkdir project_name
cd project_name
git init
git add.
git commit -m "message"
git status
git push
```

## 4. How to clone a repo from Github ?

```shell
git clone URL
```

## 5. How to create a new branch and checkout to that branch ?

```shell
git checkout -b branch_name
```

## 6. How to merge the branch_test to master branch in command ? 

```shell
git checkout master
git pull
git merge bracn_test
git push
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? 

```
git stash
git checkout another_branch
git checkout branch_learn_stash
git stash pop
```

## 8. How do you understand PR is based on Branch?

A Pull Request is a method used to contribute the changes made in a branch back to the main codebase or another target branch. It is a request to "pull" the changes from your branch into another branch.

## 9. What is maven role ? what it be used to do ?

Maven is a build automation and dependency management tool used primarily for Java projects, streamlining the process of building, testing, and managing libraries and project dependencies.

## 10. What is the lifecycle of maven? could you tell me the details ?

Maven's lifecycle is a predefined sequence of phases for project build and management, comprising:

1. **Default Lifecycle** for building and deploying:

   `validate` → `compile` → `test` → `package` → `verify` → `install` → `deploy`.

2. **Clean Lifecycle** for cleaning up the project:

   `pre-clean` → `clean` → `post-clean`.

3. **Site Lifecycle** for creating project documentation:

   `pre-site` → `site` → `post-site` → `site-deploy`.

## 11. What is the difference between package and install in maven lifecycle ?

In Maven's lifecycle, the `package` phase assembles the project into a distributable format (like a JAR), while the `install` phase places this package into the local Maven repository, making it available for use as a dependency in other projects.

## 12. What is plugins in maven, list some plugins.

Maven plugins are tools that add specific functionalities to the Maven build process, with each plugin having one or more goals to execute various tasks like compiling code, running tests, or packaging applications. Common Maven plugins include:

1. **Maven Compiler Plugin**: Compiles source code.
2. **Maven Surefire Plugin**: Runs unit tests.
3. **Maven JAR Plugin**: Packages projects into JAR files.
4. **Maven WAR Plugin**: Packages web applications into WAR files.
5. **Maven Clean Plugin**: Cleans the build directory.
6. **Maven Install Plugin**: Installs the package into the local repository.
7. **Maven Deploy Plugin**: Deploys the package to a remote repository.
8. **Maven Site Plugin**: Generates project documentation or websites.









