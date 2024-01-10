###1. Basic Usage of Markdown
- *Italic* : Use one asterisk or underscore around text
- **Bold** : Use two asterisks or underscores around text
- `Code` : Use backticks around text
- [Link](http://example.com) : Use square brackets around link text, followed by the URL in parentheses

###2. Learned Git Commands
- `git init` : Initialize a repository
- `git add` : Add files to the staging area
- `git commit` : Commit changes
- `git push` : Push to a remote repository
- `git pull` : Pull changes from a remote repository

###3. Basic Steps to Initialize a Git Repository Locally
1. Open terminal
2. Navigate to your project directory
3. Run `git init`

###4. Cloning a Repository from GitHub
- Run `git clone [URL]`, where URL is the link to the repository

###5. Creating and Checking Out a New Branch
- Create branch: `git branch [branch-name]`
- Checkout branch: `git checkout [branch-name]`

###6. Merging a Branch into Master
- Switch to master branch: `git checkout master`
- Merge the specified branch: `git merge [branch-name]`

###7. Stashing and Applying Stash in Git
- Stash changes: `git stash`
- Apply stash: `git stash pop`

###8. PR (Pull Requests) Based on Branches
- PRs are requests to merge changes from one branch into the main branch

###9. Role and Uses of Maven
- Maven is a project management and build automation tool
- Used for building projects, dependency management, and project information management

###10. Maven's Lifecycle Details
- Maven's lifecycle consists of several phases:
  - `validate`: Validate the project is correct and all necessary information is available.
  - `compile`: Compile the source code of the project.
  - `test`: Test the compiled source code using a suitable unit testing framework.
  - `package`: Take the compiled code and package it in its distributable format, such as a JAR.
  - `verify`: Run any checks to verify the package is valid and meets quality criteria.
  - `install`: Install the package into the local repository, for use as a dependency in other projects locally.
  - `deploy`: Done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

###11. Difference Between 'package' and 'install' in Maven's Lifecycle
- 'package' : Packages the code without installing it in the local repository
- 'install' : Packages and installs the code in the local repository

###12. Some Maven Plugins
- `maven-compiler-plugin` : For compiling source code
- `maven-surefire-plugin` : For running tests
- `maven-jar-plugin` : For creating JAR files

###13. Instruction steps to Create a Maven Module in IntelliJ
1. Open IntelliJ
2. Select “File > New > Module”
3. Choose “Maven”
4. Enter groupID and artifactID

###14. Conducting Code Reviews on PRs in Your Repository
- Review the changes in PRs and provide comments

