### 2. 

Git command learned: 

git init

git pull [remote] [branch]

git clone [url]

git add .

git add file1 file2 file3

git commit -m "..."

git push [remote] [branch]

git status

git branch 

git fetch [remote]

git checkout -b [branch]

### 3.

git init

### 4.

git clone [url]

### 5.

git checkout -b [branch_name]

### 6.

git checkout master

git pull origin master

git merge branch_test

(handle the conflicts)

git add .

git commit -m "merge"

git push origin master

### 7.

#### Git command:

git stash save "stash message"

git checkout ...

git checkout branch_learn_stash

git stash pop

#### IntelliJ method:

when you are in branch_learn_stash branch, select git->uncommitted Changes->Stash changes.

Git->branches, switch branches

switch back to branch _learn_stash

Select git->Uncommitted Changes->Unstash Changes, pop stash

### 8.

Pull Request is to request changes made in one branch to be merged to another branch, so it's based on branches.

### 9.

1.Maven helps build applications automatically, using pom.xml to provide a standard project structure.

2.Maven make it easy to manage dependencies, downloading needed packages automatically.

3.Maven has plugins to be more powerful.

### 10.

**validate**: Validates if the project is correct and all necessary information is available.

**compile**: Compiles the source code of the project.

**test**: Tests the compiled source code using a suitable unit testing framework. These tests should not require the code to be packaged or deployed.

**package**: Packages the compiled code into its distributable format, such as a JAR.

**verify**: Runs any checks to verify the package is valid and meets quality criteria.

**install**: Installs the package into the local repository, which can be used as a dependency in other projects locally.

**deploy**: Copies the final package to the remote repository for sharing with other developers and projects.

### 11.

Package phase is to create the target, install phase is to place the target into the local repository so it can be used as a dependency in other local projects.

### 12.

plugins are the central feature for extending the capabilities of the Maven build process.

A plugin represents a collection of goals with each goal bound to a specific phase in the Maven build lifecycle.

1.complier plugin:  Used to compile the source code of a Maven project.

2.clean plugin: Used in the clean phase of the build lifecycle to remove the files generated at build-time in the target directory.