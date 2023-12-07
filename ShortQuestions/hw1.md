# 1. in markdown
# 2. git add, git commit 
# 3. Init a Git Repo:
    git init
# 4. Clone from GitHub
    git clone https://github.com/username/repository.git
# 5. Create and Checkout New Branch
    git branch branch_name
    git checkout branch_name
    //or in one command
    git checkout -b branch_name
# 6. Merge Branch to Master
    git checkout master
    git merge branch_test

# 7. Stash and Pop
    # Stash changes
    git stash
    # Do some work...
    # Pop the stash
    git stash pop
# 8. How do you understand PR is based on Branch?
    a developer creates a new branch in their repository to work on a specific feature or fix. Once the changes are complete, 
    the developer opens a PR to propose merging those changes into another branch, often the main branch
# 9. What is Maven's role? What is it used to do?
    Maven is a build automation and project management tool. 
    Its primary roles include Dependency Management (external libraries and dependencies)
    Build Automation: such as compile, test, package, install, and deploy

# 10. Maven Lifecycle
    clean: Deletes the target directory, removing all compiled classes and resources.
    Default Lifecycle:
    
    validate: Validates the project.
    compile: Compiles the source code.
    test: Runs tests using a suitable testing framework.
    package: Packages the compiled code into a distributable format (e.g., JAR, WAR).
    verify: Runs checks on the package to verify its integrity.
    install: Installs the package into the local repository.
    Site Lifecycle:
    
    site: Generates site documentation for the project.
    deploy: Deploys the project's artifacts to a remote repository.
# 11. Difference between package and install in Maven Lifecycle
    package:
    This phase is responsible for taking the compiled code and packaging it into a distributable format (e.g., JAR, WAR).
    The packaged artifact is typically placed in the target directory of the project.
    install:
    This phase not only packages the code but also installs the packaged artifact into the local Maven repository (~/.m2/repository).
    The artifact is available for other projects on the same machine to use as a dependency
# 12. What is plugins in maven, list some plugins
    maven-jar-plugin:
        Creates a JAR file for the project.
    maven-war-plugin:
        Creates a WAR file for a web application project.