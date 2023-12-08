# HW1
## Q1 Learn MarkDown
# Heading 1
## Heading 2
### Heading 3

**bold text**
_Italic text_ 
~~Strikethrough text~~ 
**This text is _extremely_ important** 
> Text that is a quote

`Quoting code`

```
Quoting code block
```
 `#ffffff`  `#000000`
[My Github Page](https://github.com/ChovyDavid)
## Q2 List the git commands you learned
1. **git init**
    - Usage: `git init [project-name]`
    - Initializes a new Git repository.
2. **git clone**
    - Usage: `git clone [repository-url]`
    - Creates a copy of a remote repository on your local machine.
3. **git add**
    - Usage: `git add [file(s)]`
    - Adds changes in the working directory to the staging area.
4. **git commit**
    - Usage: `git commit -m "Commit message"`
    - Records changes from the staging area to the repository.
5. **git status**
    - Usage: `git status`
    - Shows the status of changes as untracked, modified, or staged.
6. **git log**
    - Usage: `git log`
    - Displays the commit history.
7. **git pull**  
    - Usage: `git pull [remote] [branch]`
    - Fetches changes from a remote repository and merges them into the current branch.
8. **git push**  
    - Usage: `git push [remote] [branch]`
    - Pushes changes from your local repository to a remote repository.
9. **git branch**
    - Usage: `git branch`
    - Lists all branches in the repository or use `git branch [newBranchName]` to create a new branch .
10. **git checkout**
    - Usage: `git checkout [branch-name]`
    - Switches to the specified branch.
11. **git merge**
    - Usage: `git merge [branch]`
    - Merges changes from one branch into another.
12. **git fetch**
    - Usage: `git fetch [remote]`
    - Fetches changes from a remote repository but does not merge them.
13. **git stash**
    - Usage: `git stash`
    - Temporarily saves changes that are not ready to be committed.
14. **git remote**
    - Usage: `git remote -v`
    - Lists remote repositories.
15. **git remote add**
    - Usage: `git remote add [remote-name] [remote-url]`
    - Adds a remote repository.
16. **git config**
    - Usage: `git config [option]`
    - Configures Git settings.

## Q3 What is the basic steps to init a git repo in you local ?

```
mkdir my-project
cd my-project
git init
git status
git add . (or git add [filename])
git commit -m "Initial Message"
git push
```

## Q4 How to clone a repo from Github ?
```
git clone [Github_Link]
```

## Q5 How to create a new branch and checkout to that branch ?
```
1.
git checkout -b [newBranchName]

2.
git branch [newBranchName]
git checkout [newBranchName]
```

## Q6 How to merge the branch_test to master branch in command ?
```
git checkout master
git pull origin master
git merge branch_test
git commit -m "Merge branch_test into master" 
git push origin master
```

## Q7 How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ?

1. Commands Way
```
//assume you are in branch branch_learn_stash now
git stash save "Your stash message"	
git checkout [anotherBranch]
git checkout branch_learn_stash
git stash pop
```
2. IntelliJ Way
	1. **Stash Changes:**
	    - In the bottom right corner, you'll find the "Version Control" tool window.
	    - Under the "Local Changes" tab, you'll see your changes.
	    - Right-click on the changes and choose "Shelve Changes."
	    - Enter a description for the stash.
	2. **Switch to Another Branch:**
	    - In the bottom right corner, you'll find the "Branches" tool window.
	    - Right-click on the branch you want to switch to and choose "Checkout."
	3. **Do your work on the other branch.**
	    
	4. **Switch Back to `branch_learn_stash`:**
	    - In the "Branches" tool window, right-click on `branch_learn_stash` and choose "Checkout."
	5. **Apply the Stash:**
	    - In the "Version Control" tool window, go to the "Local Changes" tab.
	    - Right-click on the stashed changes and choose "Unshelve."

## Q8 How do you understand PR is based on Branch?

A Pull Request (PR) is a feature provided by version control systems like Git, and it is used to propose changes from one branch to another. In the context of Git.

## Q9 What is maven role ? what it be used to do ?

  
Apache Maven is a widely used build automation and project management tool in the Java ecosystem. Its primary role is to simplify and manage the build process of a software project.
It can be used to manage dependencies and build project.

## Q10 What is the lifecycle of maven?
1. **prepare resources**: Resource copying can be customized in this phase.
2. **validate**: Validates the project, making sure it is correct and all necessary information is available.
3. **compile**: Compiles the source code of the project.
4. **test**: Runs unit tests for the complied code.
5. **package**: Takes the compiled code and packages it in its distributable format(JAR/WAR).
6. **install**: Installs the package into the local/remote repository.
7. **deploy**: Copies the final package to the remote repository.

## Q11 What is the difference between package and install in maven lifecycle ?
The package phase is responsible for taking the compiled source code and packaging it into a distributable format, such as a JAR (Java Archive), WAR (Web Archive), or other specified formats.
The install phase builds upon the package phase. It not only packages the artifact but also installs it in the local Maven repository for use in other local Maven projects.

## Q12 What is plugins in maven, list some plugins.

In Maven, plugins are extensions that provide additional goals and tasks to the build process. Plugins allow you to customize and extend the default behavior of Maven by adding new capabilities or executing specific tasks during different phases of the build lifecycle. Maven plugins are typically configured in the `pom.xml` file.

Here are some commonly used Maven plugins:

1. **`maven-compiler-plugin`:**
	- **Purpose:** Compiles Java source code.
2. **`maven-surefire-plugin`:**
	- **Purpose:** Runs unit tests.
3. **`maven-jar-plugin`:**
	- **Purpose:** Creates a JAR (Java Archive) file from the compiled classes.
4. **`maven-clean-plugin`:**
	- **Purpose:** Cleans the project by deleting the target directory.
5. **`maven-install-plugin`:**
	- **Purpose:** Installs the project's artifact in the local Maven repository. 
6. **`maven-deploy-plugin`:**
	- **Purpose:** Deploys the project's artifact to a remote repository.