# Lean MarkDown

1. MarkDown

    **First** *class*
    > Text that is a quote
    > 
    >`This section will show the basic usage of MarkDown`

    This branch will be merge into Jingwei_Wang/notes [GitHub Pages](https://github.com/Liam-Zhou/chuwa1206/tree/Jingwei_Wang/notes).

    - unordered list "-"
    - unordered nested 1
        - nested nested 1
    - unordered nester 2
    
    * unordered list "*"
    + unordered list "+"

    1. ordered list1
    1. ordered nested 1
    2. ordered nested 2
    2. ordered list2
    3. ordered list3

    ### Task Lists/Mention/Alerts
    - [X] task 1
    - [ ] taks 2

    @flyflyflybird This is the first hw

    > [!CAUTION]
    > remember to rise a PR after finish the HW

2. Git commands

    ```java


    git checkout -b <new branch name> // 创建新的branch并移动

    git checkout HEAD~<num> // 移动head num:向前移动几步

    // rsbase:
        // 当前分支bugFix, 将当前分支的内容作为一个副本到当前mian分支
    git checkout bugFix
    git rebase main
    // 将当前main指针移到复制过来的bugFix上
    git checkout main
    git rebaase bugFix

    // 分离HEAD: 让HEAD指向了某一个具体的提交记录，而不是分支名。
    // HEAD: 默认指向最后一次提交的节点


    git checkout HEAD^ // 让Head向前移动一个节点

    // HEAD 节点，当前分支节点
    // 强制将main分支的head向前移动单个位置
        // 相对引用 ^向上移动1个提交记录
        // 使用 ~<num> 向上移动多个提交记录
    git branch -f main HEAD~3
    // 将main指针移动到HEAD指针上
    git branch -f main HEAD


    // git reset: 将分支记录回退几个提交记录来实现撤销 [不推荐]
    git rest HEAD~1 
    // git revert: 产生一个新的节点使当前新节点的内容和想要回滚的节点的内容一致
    git revert HEAD

    // git cherry-pick <分支号1 分支号2>: 在当前分支上使用这个可以将<>分支直接复制过去
    git cherry-pick C3 C4 C7

    // 交互式rebase --interactive | -i 还可以reorder
    git rebase -i HEAD~4

    // git tag 
     git tag <content> <branch_name>


    // 本地栈式提交
    git rebase -i HEAD~3
    git checkout main
    git merge bugFix


    // 你之前在 newImage 分支上进行了一次提交，然后又基于它创建了 caption 分支，
    // 然后又提交了一次。此时你想对某个以前的提交记录进行一些小小的调整。
    // 比如设计师想修改一下 newImage 中图片的分辨率，尽管那个提交记录并不是最新的了。
    git rebase -i 
    git commit --amend

    git clone <link> // 下载

    // 本地仓库同步远程仓库 （下载操作，不更改本地文件, 及main分支）
        // 将本地仓库的远程分支更新成了远程仓库相应分值的最新状态
    git fetch

    // git fetch + git merge
    git pull

    git push

    // 解决冲突
    git fetch
    git reabse xx
    git push

    git fork
    ```

3. What is the basic steps to init a git repo in you local?
    ```java
    // Open a Terminal
    // Navigate to the Project Directory
    git init
    ```

4. How to clone a repo from Github?
   ```java
   git clone URL
   ```
5. How to create a new branch and checkout to that branck
   ```java
   git checkout -b <branchname>
   ```
6. How to merge the brach_test to master branch in comand?
   ```java
   //1. switch to master branch
   git checkout master
   //2. pull the up-to-date changes form remote master
   git pull origin master
   //3. merge branch_test into master
   git merge branch_test
   ```
7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

   * Command line: `git stash save "Your stash message"` and change to different branch to apply `git pop`
   
   * IDEA way: 
     * IntelliJ IDEA toolbar -> "VCS" -> "Git" -> "Stash Changes..."
     * Provide a stash message and click "OK."
     * Switch to another branch:
        * Use the "Git" tool window on the right side.
        * Under "Branches," find and checkout the desired branch.
      * Apply the stashed changes:
        * Open the "Git" tool window.
        * Under "Local Changes," you will see the stashed changes.
        * Right-click on the stash and choose "Apply Stash" or "Pop Stash."
    
8. How do you understand PR is based on Branch?
   
    After push feature branch into github. Feature branch can create a Pull Request. Pull Request is a way to propose and review code changes before merging them into the branch.
9.  What is maven role ? what it be used to do ?
    
    It plays a crucial role in managing project dependencises, the build process, documentation, and reporting.
10. What is the lifecycle of maven? could you tell me the details ?
    * validate - validate the project is correct and all necessary information is available
    * compile - compile the source code of the project
    * test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
    * package - take the compiled code and package it in its distributable format, such as a JAR.
    * verify - run any checks on results of integration tests to ensure quality criteria are met
    * install - install the package into the local repository, for use as a dependency in other projects locally
    * deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.
  
11. what is the difference between package and install in maven lifecycle ?
    * mvn package command will compile source code and also package it as a jar or war as per pom file and put it  into the target folder(by default).
    * mvn install command will compile and package, but it will also put the package in your local repository. So that other projects can refer to it and grab it from your local repository.
    
12. What is plugins in maven, list some plugins.
    
    plugins are where much of the real action is performed, plugins are used to: create jar files, create war files, compile code, unit test code, create project documentation, and on and on. Almost any action that you can think of performing on a project is implemented as a Maven plugin.

    Jar Plugin: Creates a JAR file for the project during the package phase.

    Dependency Plugin: Analyzes and resolves dependencies during the build process.
