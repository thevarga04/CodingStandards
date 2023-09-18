> As imperfect as our environment (the code) is, it discourages us from doing our best.

## Git Commits
**With each of our “git commits” we will keep in mind that we are shaping our environment.**

There are some/many external resources that communicate best practices for git commits,\
which revolves around a handful of principles:
- Relate to a specific change / Commit Often / Making small specific commits
- Commit (consistent) completed change


## Git Commit Message Format and Conventions
> There are only two hard things in Computer Science: cache invalidation and naming things.\
> -- Phil Karlton
> 
> https://martinfowler.com/bliki/TwoHardThings.html

### We will try our best to express in git commit messages the business concern in just one line
`CSC-123 Jira Task Summary - Why the code exists (not why I forgot to do it right the first time)`

### or more lines:
```
CSC-123 Jira Task Summary
 * Detail of specific business concern
```
```
CSC-123 TOPIC: Jira Task Summary - With some specifics
 * Detail why this change is here
 * This is such a significant limitation that it bears mentioning
```

### Advocacy:
"CSC-123 improved tests" is not the worst,\
because at least there is the Jira number,\
but we are loosing (important metadata) the idea why the code exists (in that specific form),\
and you need to get it from external source (Jira).

We will be not doing something like this:\
"working on something general"\
Of course it was a work, of course it was something,\
but nobody can get the idea (later when maintaining or adding features)\
why the production code exists.

We believe, that the best is always capture the business concern.\
That means, when we are improving/adding unit tests,\
we will capture business concern of the original production code,\
if this is not possible (because it might not exist, right), then we will do the best guess,\
or deep look into the git history. ;-)

Or we can do pair programming/review and do informed decision as a group/pair.


### External resources:
https://www.perforce.com/blog/vcs/git-best-practices-git-commit

https://initialcommit.com/blog/git-commit-messages-best-practices

https://dev.to/sifatfaysal/best-practices-for-proper-and-efficient-git-commits-a-developer-friendly-guide-5gdp

https://github.blog/2022-06-30-write-better-commits-build-better-projects/

https://medium.com/patilswapnilv/10-git-best-practices-to-start-using-in-your-next-git-commit-5a43ae646e91

https://www.linkedin.com/pulse/7-best-practices-writing-good-git-commitmessages-kirinyet-brian/

https://gist.github.com/luismts/495d982e8c5b1a0ced4a57cf3d93cf60