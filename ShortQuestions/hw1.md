1.  Have created README.md file in this diretory.
2.  list the git commands you learned:

    ```
    git init
    git status
    git clone
    git branch
    git checkout
    git checkout -b
    git add .
    git commit -m "commit_message"
    git push origin
    git stash
    git stash pop
    ```

3.  What is the basic steps to init a git repo in you local?

    1. Open Terminal.
    2. Navigate to the root directory of your project.
    3. Initialize the local directory as a Git repository.

    ```
    git init -b main
    ```

    4. Add the files in your new local repository. This stages them for the first commit.

    ```
    git add .
    ```

    5. Commit the files that you've staged in your local repository.

    ```
    git commit -m "First commit"
    ```

4.  How to clone a repo from Github?
    1. Copy the URL for the repository.
    2. Open Terminal and Type git clone, and then paste the URL you copied earlier.
    ```
    git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
    ```
5.  How to create a new branch and checkout to that branch?
    ```
    git branch [NEW BRANCH NAME]
    git checkout [NEW BRANCH NAME]
    ```
    or
    ```
    git checkout -b [NEW BRANCH NAME]
    ```
6.  How to merge the branch_test to master branch in command? show me the commands

    ```
    git checkout master
    git merge branch_test
    ```

7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
    checkout back to branch_learn_stash" try commands way and intellij way.

    **commands way:**

    stash:

    ```
     git stash or git stash -m "message"
     git checkout [another branch]
    ```

    unstash:

    ```
     git checkout [branch_learn_stash]
     git stash pop
    ```

    **intelliJ way:**

    stash:

    - Go to "VCS" in the top menu.
    - Select "Git."
    - Choose "Stash Changes."
    - Provide a stash message if desired.

    unstash:

    - Go to "VCS" in the top menu.
    - Select "Git."
    - Choose "Unstash Changes."
    - Select the stash want to pop.

8.  How do you understand PR is based on Branch?

    A pull request is a proposal to merge a set of changes from one branch into another. In a pull request, collaborators can review and discuss the proposed set of changes before they integrate the changes into the main codebase.

9.  What is maven role? what it be used to do?

    Maven is a build automation tool used primarily for Java projects. It provides an easy way to download add and remove the dependencies/libraries.

    The main roles of maven:

    - Manage Dependencies(Package).
    - Build Project (Cycle).
    - Documentation
    - Reporting

10. What is the lifecycle of maven? could you tell me the details?

    mvnClean -> prepare-resources -> validate -> package -> install

    | Phase             | Handles                    | Description                                                                        |
    | ----------------- | -------------------------- | ---------------------------------------------------------------------------------- |
    | prepare resources | resource copying           | Resource copying can be customized in this phase.                                  |
    | validate          | Validating the information | Validates if the project is correct and if all necessary information is available. |
    | compile           | compilation                | Source code compilation is done in this phase.                                     |
    | Test              | Testing                    | Tests the compiled source code suitable for testing framework.                     |
    | package           | packaging                  | This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.   |
    | install           | installation               | This phase installs the package in local/remote maven repository.                  |
    | Deploy            | Deploying                  | Copies the final package to the remote repository.                                 |

11. What is the difference between package and install in maven lifecycle?

    The `install` phase is often used during the development phase when you want to share your project's artifacts with other projects locally. For deployment to remote repositories or servers, you might use the `deploy` phase after the `install` phase.

12. What is plugins in maven, list some plugins.

    In Maven, plugins are extensions that provide additional capabilities to the build process. They are used to perform various tasks and goals during different phases of the Maven build lifecycle. Plugins can be bound to specific phases, and they contribute to the overall build process.

    list some plugins:

    1. Maven Compiler Plugin
    2. Maven Surefire Plugin
    3. Maven JAR Plugin
    4. Maven WAR Plugin

13. A Maven module have created in the repo/MavenProject.
