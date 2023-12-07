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

- Use `git push origin` to push changes to git repo. ~~This was mistaken text~~

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

- commands
```
git checkout branch_learn_stash
git stash
git checkout another-branch
git checkout branch_learn_stash
git stash pop
```
- IntelliJ
	- In the **Version Control Tool Window**, right-click on the uncommitted changes.
 	- Select **Git > Stash Changes**.
 	- Click **OK** to create the stash.
 	- When you're ready to apply a stash, go to the **Version Control Tool Window**.
 	- Click on the **Log** tab.
 	- At the top of this window, you'll see a drop-down menu that says Branches. 
 	- Click on it and select **Stashes**.
 	- You'll see a list of your stashed changes.
 	- Right-click on the stash you want to apply.
 	- Select **Apply Stash**. You can also choose to **Pop Stash** (which applies the stash and then removes it from the stash list).

## Q8 How do you understand  **PR is based on Branch**

A PR is a feature used in collaborative development platforms. It's a request to merge code changes from one branch into another. The branch from which the PR is created is usually a separate branch in the Git repository where specific work, like adding a feature or fixing a bug, is done. A PR allows team members to review code changes in that separate branch and decide whether to merge thoes changes into the main codebase. PR and Branch both serve the porpuse of having developers work on different tasks simultaneously without interfering with the main codebase. Therefore, we can say that *PR is based on Branch*.


## Q9 What is maven's role ? what is it used to do?

Maven is a project management and build tool. It provides a standardized build process and consistent project structure. Maven is used to build Java project, manage project dependencies, handle documentations and reporting, etc. It can be extended with plugins to perform additional tasks.

## Q10 What is the lifecycle of maven? 

1. **prepare resources**: Resource copying can be customized in this phase.
2. **validate**: Checks if all necessary information is available and valid.
3. **compile**: Compiles the source code of the project.
4. **test**: Runs tests using a suitable unit testing framework. 
5. **package**: Takes the compiled code and packages it in its distributable format(JAR/WAR) as mentioned in POM.xml.
7. **install**: Installs the package into the local/remote repository.
8. **deploy**: Copies the final package to the remote repository.

## Q11 What is the difference between package and install in maven lifecycle

- The **package** phase takes the compiled code and other resources (like properties files, XML configuration files) and packages them together into a distributable format such as JAR or WAR, but it does not install anything in the local Maven repository.

- The **install** phase takes the packaged artifact such as JAR or WAR and installs it in the local Maven repository.

## Q12 What is plugins in maven, list some plugins.

Plugins are used to extend its capabilities and to interact with a project's lifecycle. Each plugin provides a set of goals, which are executed during certain phases of the lifecycle. Command for plugins follow this pattern: `mvn [plugin-name]:[goal-name]`
Examples:

1. Compile the main source code: `mvn compiler:compile`
2. Compile the test source code: `mvn compiler:testCompile`
3. Run unit tests: `mvn surefire:test`
4. Package the project into a JAR file: `mvn jar:jar`
5. Clean up after the build: `mvn clean:clean`
6. Install the package into the local repository: `mvn install:install`
7. Deploy the built package to a remote repository: `mvn deploy:deploy`

## More Markdown show cases:
1. This is white `#ffffff` 
2. This is a random image
![Doge](https://www.coindesk.com/resizer/hT3coI2n5o-10RK8IH3hvn0OQ0I=/1056x595/filters:quality(80):format(webp)/cloudfront-us-east-1.images.arcpublishing.com/coindesk/LDAX4HAT2BEHFLXGF52WDJYX5Y.jpg)
3. Tasks: 
	- [x] Q1 - Q12
	- [x] additional show cases
	- [x] create a maven project
4. This assignment is created by @chuwa
> [!NOTE] 
> This is a Note