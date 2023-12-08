## Q1.Basic Usage

1.1
# A first-level heading
## A second-level heading
### A third-level heading

1.2

**Bold Text**
_Italicized Text_
~~Mistake~~
**is _Extremely_ important**
***All Important***
A<sub>2</sub>
A<sup>2</sup>

1.3

>Quote

1.4

Use `git status` to list all new or modified files that haven't yet been committed.

1.5

The background color is `#RRGGBB` for light mode and `#000000` for dark mode.

1.6

This site was built using [GitHub Pages](https://pages.github.com/).

1.7

[Link text Here](https://link-url-here.org)

1.8

[Contribution guidelines for this project](docs/CONTRIBUTING.md)

1.9

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)

1.10

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://user-images.githubusercontent.com/25423296/163456776-7f95b81a-f1ed-45f7-b7ab-8fa810d529fa.png">
  <source media="(prefers-color-scheme: light)" srcset="https://user-images.githubusercontent.com/25423296/163456779-a8556205-d0a5-45e2-ac17-42d089e3c3f8.png">
  <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://user-images.githubusercontent.com/25423296/163456779-a8556205-d0a5-45e2-ac17-42d089e3c3f8.png">
</picture>

1.11

1. a
1. b
1. c

1.12

1. First list item
    - First nested list item
        - Second nested list item


100. First list item
      - First nested list item


100. First list item
     - First nested list item
        - Second nested list item

1.13

- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada:

1.14

@github/support What do you think about these updates?

1.18

:+1: :grinning:


1.20

Here is a simple footnote[^1].

A footnote can also have multiple lines[^2].

[^1]: My reference.

[^2]: To add line breaks within a footnote, prefix new lines with 2 spaces.
This is a second line.

1.20

> [!NOTE]
> Highlights information that users should take into account, even when skimming.

> [!TIP]
> Optional information to help a user be more successful.

> [!IMPORTANT]
> Crucial information necessary for users to succeed.

> [!WARNING]
> Critical content demanding immediate user attention due to potential risks.

> [!CAUTION]
> Negative potential consequences of an action.

1.21

<!-- This content will not appear in the rendered Markdown -->

1.22

Let's rename \*our-new-project\* to \*our-old-project\*.

## Q2
`git checkout`
`git fetch`
`git merge`
`git rebase`
`git push`
`git pull`
`git push main:bar`

## Q3
git init
## Q4
git clone
## Q5
git checkout -b branch_name
## Q6
git branch branch_test

git checkout master

git merge branch_test

## Q7
### command
git stash save "..."

git checkout main

git checkout branch_learn_stash

git stash pop

### IDE

In IntelliJ IDEA, stash changes by right-clicking on changes in "Local Changes," switch branches in "Branches," and return to branch_learn_stash by right-clicking in "Branches." Unstash changes from the "Shelf" tab in the "Version Control" tool window.
## Q8
PR suggests merging changes from (eg.feature branch) to (eg.master). It plays the role as a discussion platform for code modifications before merging

## Q9
### role
1. manage dependencies (packages)
2. build project (cycle)
3. reporting
4. others

### to do what
easy to download add and remove the dependencies/libraries

## Q10
mvnClean -> prepare-resources -> validate -> package -> install

mvn clean -> used to delete all the project jar that are built by Maven

prepare-resources -> resource copying can be customized in this phase

validate -> validate the project is correct and all necessary information is available

compile -> compile the source code of the project

test -> test the compiled source code using a suitable unit testing framework

package -> take the compiled code and package it in its distributable format, such as a JAR

verify -> run any checks on results of integration tests to ensure quality criteria’s are met

install: install the package into the local repository, for using as a dependency in other projects locally

deploy: done in the build environment, copies the final package to the remote repository for sharing with other developers and projects

## Q11
Package: Creates the distributable artifact and places it in the target directory.

Install: Does everything "package" does and additionally installs the artifact in the local Maven repository, making it available for other projects within the local development environment.

## Q12
They are extensions which provide additional functionality to the build process, in the `pom.xm1` file
1. compiler plugin
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```
2. clean plugin
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-clean-plugin</artifactId>
      <version>3.1.0</version>
    </plugin>
  </plugins>
</build>
```
## Q13
