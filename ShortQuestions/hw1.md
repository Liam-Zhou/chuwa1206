3. **What are the basic steps to initialize a Git repository in your local?**
     - Open the terminal
     - Navigate to project directory
     - Run `git init` in the terminal

4. **How to clone a repository from GitHub?**
   - In the terminal, run `git clone <repo_url>`

5. **How to create a new branch and checkout to that branch?**
   - Open your ternimal
   - Run the following commands:
     - `git branch <branch_name>`
     - `git checkout <branch_name>`


6. **How to merge the branch 'test' into 'master' branch in the command line? Show me the commands.**
   - Run the following commands:
     - `git checkout master`
     - `git merge test`


7. **How to stash your new code before leaving branch 'branch_learn_stash' and pop your stash when you checkout back to 'branch_learn_stash'? Try both the command-line way and IntelliJ way.**
     - Stash: `git stash`
     - Pop stash: `git stash pop`

8. **How do you understand PR is based on a branch?**
   - Nomally a PR is raised when there are code added. And people usually add these code in a new branch so that even if there are some bugs in the new branch, it won't affect the master branch. PR is needed so that people can review the code before merging into master branch.

9. **What is Maven's role? What can it be used to do?**
   - Maven is a build dependency and project management tool. Maven can be used to compile code, run tests, package applications, and manage project configurations.

10. **What is the lifecycle of Maven? Could you tell me the details?**
- `prepare-resources`: Resource copying can be customized in this phase.
- `validate`: Validates if the project is correct and if all necessary information is available.
- `compile`: Compiles the source code.
- `test`: Runs tests.
- `package`:This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.
- `install`: This phase installs the package in local/remote maven repository.
- `deploy`: Copies the final package to the remote repository.

11. **What is the difference between 'package' and 'install' in the Maven lifecycle?**
   - In the Maven lifecycle, the `package` phase creates a distributable package like JAR, whereas the `install` phase installs the package in the local Maven repository. `Package` focuses on creating the file, while `install` makes it available for other projects on the same system to use as a dependency.

12. **What are plugins in Maven? List some plugins.**
      - `maven-surefire-plugin`: Runs unit tests.
      - `maven-jar-plugin`: Compile project into JAR files.
