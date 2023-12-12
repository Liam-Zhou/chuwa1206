# Homework 1

## 1.
Already learned.

## 2. 
```
git clone
git push
git pull
git add .
```


## 3
```
git init
touch README.md
git add .
git commit -m"first commit"
git push
```

## 4
```
git clone https://github.com/Liam-Zhou/chuwa1206.git
```

## 5
```
git checkout -b Huikun_Zheng
```

## 6
```agsl
git checkout master      
git merge branch_test
```

## 7
```agsl
git stash                
git checkout other_branch   
git checkout branch_learn_stash   
git stash pop            

```

## 8
A PR is typically based on a branch because it represents changes pushed to that branch which are then proposed for merging into another branch (usually the main or master branch). In GitHub, for instance, when you create a PR, you select the source branch with your changes and the target branch for the merge.

## 9
Maven is a build automation tool used primarily for Java projects. It simplifies the build process like compiling code, packaging binaries, running tests, and much more. Maven uses a Project Object Model (POM) to manage project's build configuration, dependencies, plugins, and other aspects.

## 10
Maven has three main lifecycles:

Default: Handles project deployment.
Clean: Handles project cleaning.
Site: Handles the creation of project's site documentation.
Each lifecycle consists of phases (e.g., compile, test, package, install for the default lifecycle).

## 11
package: Takes the compiled code and package it into its distributable format, such as a JAR.
install: Takes the packaged JAR and copies it to the local repository, which makes it accessible to other projects on the same machine.

## 12
Plugins are used to perform specific tasks in Maven and are crucial for its functioning. Some common plugins include:

maven-compiler-plugin: Compiles Java sources.
maven-surefire-plugin: Runs tests using Surefire.
maven-jar-plugin: Creates a JAR file.
maven-war-plugin: Used for web applications to create WAR files.

## 13
To create a Maven Module in IntelliJ IDEA with the specified groupId and artifactId, follow these steps:

Open IntelliJ IDEA and select File -> New -> Module.
Choose Maven as the type.
Enter com.chuwa.learn as the GroupId and java-core as the ArtifactId.
Follow the prompts to create the module.

## 14
OK.