1. 
learned

2.
git commit
git branch
git merge
git rebase
git fork 

3.
git init
git add .
git commit -m "commit msg"

4.
git clone https://github.com/Liam-Zhou/chuwa1206.git

5.
git checkout -b <branch_name>

6.
git checkout master
git merge branch_test

7.
git stash                
git checkout other_branch   
git checkout branch_learn_stash   
git stash pop            

8.
A PR is a request to merge one branch into another, usually from a feature branch into the main or master branch.

9.
Maven is a build automation tool used primarily for Java projects. It handles project building, dependency management, etc ...

10.
Maven's lifecycle comprises three key sequences:
Default Lifecycle: For building and deploying. Phases include validate, compile, test, package, verify, install, deploy.
Clean Lifecycle: For project cleanup. Phases are pre-clean, clean, post-clean.
Site Lifecycle: For documentation. Phases involve pre-site, site, post-site, site-deploy

11.
In Maven's build lifecycle, package compiles the project's code and packages it into distributable formats like JAR or WAR files, suitable for deployment but not available in the local Maven repository. On the other hand, install extends the package phase by installing the packaged artifact into the local Maven repository, making it accessible as a dependency for other projects on the same machine. 

12.
In Maven, plugins are specialized tools for executing specific tasks in the build process. 
Maven JAR Plugin: This one is a packager. It takes your compiled Java code and bundles it all up into a JAR file, which is a standard format for distributing Java applications.
Maven Clean Plugin: It's like a broom for your build directory. After you've built your project a few times, you end up with a lot of generated files. This plugin cleans them up, keeping your project tidy.
Maven Compiler Plugin: This plugin is like the backbone of Java projects in Maven. It takes your Java source code and compiles it into bytecode, which is essential before you can run or test your code.
