> Checklists are for Experts\
> https://dwheeler.com/essays/checklists.html

# Unit Testing Expert Checklist
* Reliable: Valuable (do not mock everything)
* Simple: To Write, Read and Understood, Maintain
* Consistent: Correct results, and resemble each other (mirror what is good)
* Fast: To Execute, To Change


## Additional info
* Good tests provides maximum value with minimum maintenance costs.
* Good tests act as a safety net — a tool that provides insurance against the vast majority of regressions.
* Tendency to write a complex test might be an indicator of over-engineered code.
* Isolation issue - avoid adding more dependencies in test classes than in production code. 
* Integration test does not meet criteria for a unit test. Create them somewhere else.
* Good unit tests are thorough, but there are other values as well, like maintainability, ...
* Good testing strategy is layered: Unit tests, Integration tests, End-to-End tests, ...
* The Test Pyramid advocates for a certain ratio of unit, integration, and end-to-end tests.
* End-to-end tests should be in the minority, unit tests in the majority, and integration tests somewhere in the middle.
* End-to-end tests favor protection against regressions, while unit tests favor fast feedback.
* Use the black-box testing method when writing tests. Use the white-box method when analyzing the tests.


## External Resources
* Unit Testing Principles, Practices, and Patterns
  * https://www.oreilly.com/library/view/unit-testing-principles/9781617296277/
* JUnit in Action, Third Edition
  * https://www.oreilly.com/library/view/junit-in-action/9781617297045/


* https://codefresh.io/learn/unit-testing/
* https://tmap.net/node/699
* https://medium.com/@tasdikrahman/f-i-r-s-t-principles-of-testing-1a497acda8d6
* https://www.iroidtechnologies.com/blog/unit-testing-principles