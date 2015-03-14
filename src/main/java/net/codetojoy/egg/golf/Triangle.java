package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/47657/print-number-triangle
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import java.util.stream.*;
import static java.util.stream.Collectors.joining;

public class Triangle {
    String t (int n) {
        return IntStream.range(1,n+1)
                        .boxed()
                        .map(i -> IntStream.range(1,i+1)
                                           .boxed()
                                           .map(j -> ""+j)
                                           .collect(joining(" ")))
                        .collect(joining("\n"));
    }
}