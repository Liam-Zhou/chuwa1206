1. [README.md](./README.md)

2. ```bash
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
   

3. Steps:

   1. Navigate to the directory

   2. ```git init```

   3. ```bash
      git add
      git commit
      ```

4. ``` git clone [repo_address]```

5. ```bash
   git branch [branch_name]
   git checkout [branch_name]
   ```

6. Steps:

   1. ```bash
      git checkout master
      ```

   2. ```bash
      git merge branch_test
      ```

7. Steps:

   1. Stash

      ```bash
      git stash save "msg"
      ```

   2. Go to another branch and do the work

      ```bash
      git checkout [another_branch]
      ```

   3. When return back to `branch_learn_stash`

      ```bash
      git checkout branch_learn_stash
      git stash pop
      ```

   When using IntelliJ:

   1. In the IntelliJ IDEA UI:
      - Go to "VCS" in the top menu.
      - Select "Git."
      - Choose "Stash Changes."
      - Provide a stash message if desired.

   2. In the IntelliJ IDEA UI:
      - Go to "VCS" in the top menu.
      - Select "Git."
      - Choose "Unstash Changes."
      - Select the stash want to pop.

8. Pull Request is often associated with collaborative development workflows, like GitHub, or GitLab.

   A PR is typically initiated from a source branch. This source branch contains the changes that we want to propose for merging into another branch, often referred to as the "target branch."

   The target branch is the branch into which we want to merge the changes from the source branch. It's the branch where we want the proposed changes to be incorporated.

   When creating a Pull Request, we are essentially asking for a review and approval to merge the changes from the source branch into the target branch. 

9. Maven provides an easier way to download, add and remove the dependencies or libraries. It can manage dependencies (packages), build projects (or cycles), and perform documentation reporting

10. Maven 's lifecycle is a sequence of tasks that are executed in a specific order when you run Maven commands. It contains several phases: prepare resources, validate, compile, Test, package, install, and deploy. Each phase in the lifecycle represents a specific step in the software development and build process. For example, during the prepare resources phase, maven will copy resources, and this process can be customized. During the validation phase, maven will validate if the project is correct and if all necessary information is available. During the compile phase, maven will compile the source code. During the testing phase, maven will test if the compiled code is suitable for testing framework. During the package phase, maven will create the JAR or WAR packages as mentioned in the packaging in POM.xml. During the installation phase, maven will install the package in local or remote maven repository. At Lase, maven will experience the deploy phase and it will copy the final package to the remote repository. These are the primary phases in the Maven build lifecycle. We can execute specific phases using Maven commands like `mvn clean`, `mvn compile`, `mvn test`etc... When running a phase, Maven will execute all preceding phases as well. For example, running `mvn test` will also execute the `clean`, `validate`, `compile`, and `package` phases before running the tests. In addition to the standard lifecycle, we can also define custom phases and goals using Maven plugins to suit a project's specific needs. 

11. Both the `package` and `install` phases are responsible for producing and handling project artifacts, but they serve different purposes: `package` creates the artifact in the project's `target` directory, preparing it for distribution but not necessarily for sharing with other projects.`install` copies the artifact to the local Maven repository, making it available for use by other projects on your development machine.

12. Plugins are essential components that provide various functionalities to the build process. They are responsible for executing specific tasks or goals within the Maven build lifecycle. Plugins can be used to compile code, run tests, package artifacts, deploy to repositories, and perform many other tasks related to project management and build automation. For example, compiler plugin can compile ava source code. JAR Plugin can create JAR files.