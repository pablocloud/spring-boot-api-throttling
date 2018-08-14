# Basic API throttling for Spring Boot.

This is in a very basic state, by the moment you can throttle api calls
by (requests)/second/minute/hour/day.

This is done via an Annotation, using: 

@Throttle(maxPerSecond = 2, maxPerMinute = 10, maxPerHour = 100, maxPerDay = 1000)

You can find a sample on how to use it in sample-app-throttling.

Future features:
- Per user throttle
- Controller/Scope throttling

Requirements:

At this moment the library expects an apiKey request param (doesn't validate it, just checks it its there).

It's used to store key pairs to control request number. In the future this will be binded to an User domain class.