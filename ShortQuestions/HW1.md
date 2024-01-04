1. Show all the Markdown basic usage.
### tittle
quote: 
> text is quaote.

quote code:

```
System.out.println("hello world")
```
use links:

[Google](https://www.google.com/)

Lists:
- Java
- python
- C++

1. Java
2. Python
3. C++

Nested Lists:
1. Java
    - OOP
        - Abstraction 


2. ```git checkout ``` 

    ```git stauts```

3. ```git init```
4.  ```git clone [repo url]```
5. use ```git status``` to make sure in the right repository. Then use ```git branch newBranchName``` to create new branch. ```git checkout newBranchName```. Also, this can be done in one-step, ```git checkout -b newBranchName```.
6. 
(1) switch branch ```git checkout master```

(2) before merging, need to update master branch ```git pull origin master```

(3) merge ```git merge branch_test```

(4) ```git push origin master```

7. ```git stash``` 

```git checkout master```

```git checkout branch_learn_stash```

```git stash pop```

In intellij, right-click on the file and select **Git** then **Stash Changes**, if you want to get back, go to **Version Control**, **Stash** -> **Pop Stash**. 

8. Pull request is proposes changes from a secific branch in a repo. And it can includes the difference between two branches. 

9. Maven is a dependency management tool which also can compile code, build project, generate documentation and reporting. It uses a pom.xml file to manage and build dependency. 

10. First is clean lifecycle, ```mvn clean``` would do pre-clean and clean. Second, default lifecycle, includes validate, compile, test, package, verify, install, and deploy. Third, site lifecycle, includes, pre-sites, site,post-sites, site-deploy. 

11. Package means take compiled code and package it into JAR format. Install means copye the package to local Maven repository. 

12. Plugins in Maven are sued to add capabilities to Maven build process and can be executed during build lifecycle. For example, Maven Compiler, Surefile, JAR, clean, Install, Deploy,