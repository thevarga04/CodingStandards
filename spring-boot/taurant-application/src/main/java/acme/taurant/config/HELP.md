# Cross-cutting concerns
> Cross-cutting concerns are parts of a program that rely on or must affect many other parts of the system.

We have often seen ExceptionHandler (@ControllerAdvice) in a package like this "global config", etc.\
Good design minimize merge conflicts (SRP) and not doing so - merging exceptions from multiple features\
into a class can cause such a problem, if multiple PRs add new exceptions.