#### Using Milliseconds since Unix Epoch
We will be using Milliseconds since Unix Epoch https://currentmillis.com/
in projects objects and storing it as a long number (int64),
because it is the simplest format how to store date and time without compromising the precision
and also due its versatility - lightweight conversion to the zoned date time (for the representation in UI).

Advocacy:
https://en.wikipedia.org/wiki/Unix_time

Additional Info:
Objects tightly coupled to a specific timezone of course needs to have the timezone attribute.
