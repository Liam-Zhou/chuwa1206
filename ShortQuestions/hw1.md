# short question from kaiyuan tang

> [!NOTE]
> This a markdown file for hw1

## questions solved
- [x] [question 1](#question-1)
- [x] [question 2](#question-2)
- [x] [question 3](#question-3)
- [x] [question 4](#question-4)
- [x] [question 5](#question-5)
- [x] [question 6](#question-6)
- [x] [question 7](#question-7)
- [x] [question 8](#question-8)
- [x] [question 9](#question-9)
- [x] [question 10](#question-10)
- [x] [question 11](#question-11)
- [x] [question 12](#question-12)
- [x] [question 13](#question-13)
- [x] [question 14](#question-14)

## question 1

### basic mark down usage
> showcase markdown usage through examples

<br>

Find more about markdown in [Basic writing and formatting syntax](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#relative-links).

<br>

### render text

**This is bold text**
<br>
_This text is italicized_
<br>
~~This was mistaken text~~

<br>

Use `git status` to list all new or modified files that haven't yet been committed.
<br>

Some basic Git commands are:
```
git status
git add
git commit
```
<br>

You can make an unordered list by preceding one or more lines of text with -, *, or +
- George Washington
* John Adams
+ Thomas Jefferson

<br>

To order your list, precede each line with a number.

1. James Madison
2. James Monroe
3. John Quincy Adams

<br>

1. First list item
   - First nested list item
      - Second nested list item

<br>

### render images

![an image.](https://myoctocat.com/assets/images/base-octocat.svg)

<br>

more about relative link
```
 The path of the link will be relative to the current file. 
 Links starting with / will be relative to the repository root
```


## question 2
Some basic Git commands are:
```
git status
git add
git commit
git config --global user.name "[firstname lastname]"
git config --global user.email "[valid-email]"
git init
git clone [url]
git status
git add [file]
git reset [file]
git diff
git branch
git branch [branch-name]
git checkout
git merge [branch]
git log
git fetch [alias]
git merge [alias]/[branch]
git push [alias] [branch]
git pull
```

## question 3
1. Initialize the Git Repository: Navigate to the root directory of your project and run:

   `git init`
    
    This command creates a new subdirectory named .git in your project directory, which contains all of your repository's configuration files and history. It essentially turns your project directory into a Git repository.

2. Add Files to the Repository: To start tracking files with Git, add them to your repository:

    `git add .`

    This command stages all your current directory files for the next commit.

3. Commit the Files: To record the changes in your repository (i.e., to make your first commit), use:

    `git commit -m "Initial commit"`

    The -m flag allows you to add a commit message, which should describe the changes you're committing.

## question 4
1. Find the Repository URL

2. Copy the URL

3. navigate to the directory where you want to clone the repository

4. Run the Clone Command:

   `git clone https://github.com/username/repository.git`

## question 5
`git checkout -b new-branch-name`
1. creates a new branch with the name you specify.
2. switches your current working directory to this new branch.

## question 6
merge the branch_test to master branch:
1. To switch to the master branch:

   `git checkout master`

2. Update your master branch with the latest changes from the remote repository (if there are multiple collaborators):

   `git pull origin master`

3. Merge the Branch:

   `git merge branch_test`

4. Handle Merge Conflicts (if any)
5. After resolving conflicts, you would add the resolved files to staging using git add ., and then you can continue the merge by committing the changes.
6. Push the Changes: push the updated master branch to the remote repository:

   `git push origin master`

## question 7
1. To stash your changes:
   
   `git stash`
   Save your current modifications in a stack-like structure and revert the branch to its last commit state.
2. Switching Branches:

   `git checkout master`
   
   Do whatever work you need on this or other branches.

3. Returning to the Original Branch:

   `git checkout branch_learn_stash`

4. Popping the Stash:

   `git stash pop`

   Applies the stashed changes to your working directory and removes them from the stash stack.


Using IntelliJ IDEA
1. Stashing Changes:

   In IntelliJ IDEA, ensure you're in the branch_learn_stash branch. right-click on the changes you want to stash, and select 'git->Uncommitted Changes->Stash Changes'. 
2. Switching Branches:

   'Git' -> 'Branches', switch to your desired branch (e.g., master).

3. switch back to branch_learn_stash.
4. Popping the Stash:

   git->Uncommitted Changes->Unstash Changes, pop stash, apply

## question 8
**pull request:**

a mechanism used to request that changes made in one branch (the "feature branch") be incorporated into another branch (usually the master or main branch). 
When a developer is ready to merge their changes, they create a pull request.

**Review Process:**

Once a pull request is created, other team members can review the changes, and approve or request changes.

## question 9
1. Maven automates the process of building software.
2. Dependency Management: It automatically downloads project dependencies from repositories (like Maven Central) and includes them in the build process. It also keeps track of transitive dependencies
3. Maven provides a standardized project structure and build process. By using pom.xml, all Maven projects have a consistent directory layout and build lifecycle.
4. Maven extends its capabilities through plugins.
5. Maven can generate various reports like code documentation, dependency lists, unit test reports, and other project information. 

## question 10
Maven's lifecycle is a set of phases that define the order in which a build process should be executed.

Default Lifecycle: Responsible for the project deployment.

1. validate: Validates that the project is correct and all necessary information is available.
2. compile: Compiles the source code of the project.
3. test: Tests the compiled source code using a suitable unit testing framework. These tests should not require the code to be packaged or deployed.
4. package: Takes the compiled code and packages it in its distributable format, such as a JAR or WAR.
5. verify: Runs any checks to validate the package is valid and meets quality criteria.
6. install: Installs the package into the local repository, for use as a dependency in other projects locally.
7. deploy: Copies the final package to the remote repository for sharing with other developers and projects.

Clean Lifecycle: Handles project cleaning. It is used to clean up artifacts created by prior builds. Its main phases are:

1. pre-clean: Executes processes needed prior to the actual project cleaning.
2. clean: Removes all files generated by the previous build.
3. post-clean: Executes tasks that are needed after the project cleaning.
4. Site Lifecycle: Manages the creation of the project's site documentation. 

Phases in the site lifecycle include:

1. pre-site: Executes processes needed prior to the actual site generation.
2. site: Generates the project's site documentation.
3. post-site: Executes processes needed to finalize the site generation, and to prepare for site deployment.
4. site-deploy: Deploys the generated site to the specified web server.

## question 11
**package phase:**

The package phase is about creating the deliverable.

**install phase:**

The install phase is about placing that deliverable into the local repository so it can be used as a dependency in other local projects.

## question 12
In Maven, plugins are the central feature for extending the capabilities of the Maven build process. 

A plugin represents a collection of goals with each goal bound to a specific phase in the Maven build lifecycle.

1. `maven-compiler-plugin`: Used to compile the source code of a Maven project.
2. `maven-surefire-plugin`: Used during the test phase of the build lifecycle to execute unit tests.
3. `maven-clean-plugin`: Used in the clean phase of the build lifecycle to remove the files generated at build-time in the target directory.

## question 13
as shown in the Repo directory

## question 14
done