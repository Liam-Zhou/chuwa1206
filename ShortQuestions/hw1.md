# Homework 1

### Q1 - Markdown basic
Please check this [link](README.md)

### Q2 - Git commands
```bash
git init
git status
git pull
git add
git commit -m 
git clone
git checkout
git checkout -b
git branch
git branch -d
git push
git reset
git restore
git stash
git stash pop
git merge
```

### Q3 - Init local repo
```bash
git init
git add .
git commit -m "your first commit msg"
```

### Q4 - Git clone
```bash
git clone <remote-repo.git>
```

### Q5 - New branch
```bash
git checkout -b <new-branch-name>
```

### Q6 - Merge to master
```bash
git checkout master
git merge branch_test
```

### Q7 - Slash
checkout to other branch without commit
```bash
# before checking out to other branch
git slash
# When switch back to the branch
git slash pop
```

In IntelliJ:
Find the Git - slash/unslash button for the operations.

### Q8 
 "PR is based on branch" refers to the process of submitting and managing pull requests in a version control system, such as Git. It means that the changes being proposed in a pull request are typically made in a separate branch rather than directly in the main branch. The developer works on a feature or bug fix in their branch, and when they are ready to merge those changes into the main codebase, they create a pull request. The pull request provides a way for others to review and discuss the proposed changes before merging them.

 ### Q9 - Maven
 Maven is a project management tool for Java. It is used for dependencies management and building project.

 ### Q10 - Maven lifecycle
1. `prepare-resources`: gather resources
2. `validate`: Validates if the project is correct(no syntax error) and if all necessary information is available.
3. `compile`: compilation Source code.
4. `test`: Unit test and intergral test that the compiled source code suitable for testing framework
5. `package`:creates the JAR/WAR package as mentioned in the
packaging in POM.xml.
6. `install`: installs the package in local/remote maven
repository.
1. `deploy`: copies the final package to the remote repository and deploy to server



