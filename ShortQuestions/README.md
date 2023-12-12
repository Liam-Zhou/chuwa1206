# A first-level heading

## A second-level heading

### [Styling text](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#styling-text)

You can indicate emphasis with bold, italic, strikethrough, subscript, or superscript text in comment fields and `.md` files.

| Style                  | Syntax             | Keyboard shortcut                         | Example                                  | Output                                   |
| :--------------------- | :----------------- | :---------------------------------------- | :--------------------------------------- | :--------------------------------------- |
| Bold                   | `** **` or `__ __` | Command+B (Mac) or Ctrl+B (Windows/Linux) | `**This is bold text**`                  | **This is bold text**                    |
| Italic                 | `* *` or `_ _`     | Command+I (Mac) or Ctrl+I (Windows/Linux) | `_This text is italicized_`              | *This text is italicized*                |
| Strikethrough          | `~~ ~~`            | None                                      | `~~This was mistaken text~~`             | ~~This was mistaken text~~               |
| Bold and nested italic | `** **` and `_ _`  | None                                      | `**This text is _extremely_ important**` | **This text is \*extremely\* important** |
| All bold and italic    | `*** ***`          | None                                      | `***All this text is important***`       | ***All this text is important***         |
| Subscript              | `<sub> </sub>`     | None                                      | `This is a <sub>subscript</sub> text`    | This is a subscript text                 |
| Superscript            | `<sup> </sup>`     | None                                      | `This is a <sup>superscript</sup> text`  | This is a superscript text               |



### Quoting

Text that is not a quote

> Text that is a quote

##### quoting code

```bash
git status
git add
git commit
```



## [Supported color models](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#supported-color-models)

In issues, pull requests, and discussions, you can call out colors within a sentence by using backticks. A supported color model within backticks will display a visualization of the color.

```markdown
The background color is `#ffffff` for light mode and `#000000` for dark mode.
```

![Screenshot of rendered GitHub Markdown showing how HEX values within backticks create small circles of color. #ffffff shows a white circle, and #000000 shows a black circle.](https://docs.github.com/assets/cb-11648/images/help/writing/supported-color-models-rendered.png)

Here are the currently supported color models.

| Color | Syntax         | Example                | Output                                                       |
| :---- | :------------- | :--------------------- | :----------------------------------------------------------- |
| HEX   | ``#RRGGBB``    | ``#0969DA``            | ![Screenshot of rendered GitHub Markdown showing how HEX value #0969DA appears with a blue circle.](https://docs.github.com/assets/cb-1558/images/help/writing/supported-color-models-hex-rendered.png) |
| RGB   | ``rgb(R,G,B)`` | ``rgb(9, 105, 218)``   | ![Screenshot of rendered GitHub Markdown showing how RGB value 9, 105, 218 appears with a blue circle.](https://docs.github.com/assets/cb-1962/images/help/writing/supported-color-models-rgb-rendered.png) |
| HSL   | ``hsl(H,S,L)`` | ``hsl(212, 92%, 45%)`` | ![Screenshot of rendered GitHub Markdown showing how HSL value 212, 92%, 45% appears with a blue circle.](https://docs.github.com/assets/cb-2066/images/help/writing/supported-color-models-hsl-rendered.png) |

**Notes:**

- A supported color model cannot have any leading or trailing spaces within the backticks.
- The visualization of the color is only supported in issues, pull requests, and discussions.

## [Links](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#links)

You can create an inline link by wrapping link text in brackets `[ ]`, and then wrapping the URL in parentheses `( )`. You can also use the keyboard shortcut Command+K to create a link. When you have text selected, you can paste a URL from your clipboard to automatically create a link from the selection.

You can also create a Markdown hyperlink by highlighting the text and using the keyboard shortcut Command+V. If you'd like to replace the text with the link, use the keyboard shortcut Command+Shift+V.

```
This site was built using [GitHub Pages](https://pages.github.com/).
```

## [Images](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#images)

You can display an image by adding ! and wrapping the alt text in `[ ]`. Alt text is a short text equivalent of the information in the image. Then, wrap the link for the image in parentheses `()`

![images](.\images.png)

Here are some examples for using relative links to display an image.

| Context                                                     | Relative Link                                                |
| :---------------------------------------------------------- | :----------------------------------------------------------- |
| In a `.md` file on the same branch                          | `/assets/images/electrocat.png`                              |
| In a `.md` file on another branch                           | `/../main/assets/images/electrocat.png`                      |
| In issues, pull requests and comments of the repository     | `../blob/main/assets/images/electrocat.png?raw=true`         |
| In a `.md` file in another repository                       | `/../../../../github/docs/blob/main/assets/images/electrocat.png` |
| In issues, pull requests and comments of another repository | `../../../github/docs/blob/main/assets/images/electrocat.png?raw=true` |

**Note**: The last two relative links in the table above will work for images in a private repository only if the viewer has at least read access to the private repository that contains these images.

## [Lists](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#lists)

You can make an unordered list by preceding one or more lines of text with -, *, or +.

```markdown
- George Washington
* John Adams
+ Thomas Jefferson
```

### [Nested Lists](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#nested-lists)

You can create a nested list by indenting one or more list items below another item.

To create a nested list using the web editor on GitHub or a text editor that uses a monospaced font, like [Visual Studio Code](https://code.visualstudio.com/), you can align your list visually. Type space characters in front of your nested list item until the list marker character (- or *) lies directly below the first character of the text in the item above it.

```markdown
1. First list item
   - First nested list item
     - Second nested list item
```

**Note**: In the web-based editor, you can indent or dedent one or more lines of text by first highlighting the desired lines and then using Tab or Shift+Tab respectively.

## [Task lists](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#task-lists)

To create a task list, preface list items with a hyphen and space followed by `[ ]`. To mark a task as complete, use `[x]`.

- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada:

If a task list item description begins with a parenthesis, you'll need to escape it with 

- [ ] \(Optional) Open a followup issue- [ ] \(Optional) Open a followup issue

## [Mentioning people and teams](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#mentioning-people-and-teams)

You can mention a person or [team](https://docs.github.com/en/organizations/organizing-members-into-teams) on GitHub by typing @ plus their username or team name. This will trigger a notification and bring their attention to the conversation. People will also receive a notification if you edit a comment to mention their username or team name. For more information about notifications, see "[About notifications](https://docs.github.com/en/account-and-profile/managing-subscriptions-and-notifications-on-github/setting-up-notifications/about-notifications)."

**Note:** A person will only be notified about a mention if the person has read access to the repository and, if the repository is owned by an organization, the person is a member of the organization.

```
@github/support What do you think about these updates?
```

## [Referencing issues and pull requests](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#referencing-issues-and-pull-requests)

You can bring up a list of suggested issues and pull requests within the repository by typing #. Type the issue or pull request number or title to filter the list, and then press either tab or enter to complete the highlighted result.

## [Using emoji](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#using-emoji)

You can add emoji to your writing by typing `:EMOJICODE:`, a colon followed by the name of the emoji.

@octocat :+1: This PR looks great - it's ready to merge! :shipit: 

## [Footnotes](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#footnotes)

You can add footnotes to your content by using this bracket syntax:

Here is a simple footnote[^1].

A footnote can also have multiple lines[^2].

[^1]: My reference.
[^2]: To add line breaks within a footnote, prefix new lines with 2 spaces.
  This is a second line.

## [Alerts](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#alerts)

Alerts are an extension of the blockquote syntax that you can use to emphasize critical information. On GitHub, they are displayed with distinctive colors and icons to indicate the importance of the content. Alert syntax is supported in:

- Issues
- Pull requests
- Markdown files
- Discussions
- Gists
- Wikis
- Releases

We recommend restricting the use of alerts to one or two per article to avoid overloading the reader. Consecutive alerts should be avoided.

Multiple types of alerts are available. You can add an alert with a special blockquote line that specifies the alert type, and then add the alert information in a standard blockquote immediately after.

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

## [Hiding content with comments](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#hiding-content-with-comments)

You can tell GitHub to hide content from the rendered Markdown by placing the content in an HTML comment.

```
<!-- This content will not appear in the rendered Markdown -->
```

## [Ignoring Markdown formatting](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#ignoring-markdown-formatting)

You can tell GitHub to ignore (or escape) Markdown formatting by using \ before the Markdown character.

```
Let's rename \*our-new-project\* to \*our-old-project\*.
```