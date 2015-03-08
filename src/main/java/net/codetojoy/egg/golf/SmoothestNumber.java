package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/36384/find-the-smoothest-number
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import java.util.stream.*;
import java.math.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

// This class contains an integer, i, and its highest prime divisor, d.
class F {
    int d;
    int i;
    public int getD() { return d; }

    F (int i) {
        this.i = i;
        d = IntStream.range(2,i + 1)
                     .map(j -> ( (i % j == 0) && new BigInteger(""+j).isProbablePrime(1)) ? j : 0 )
                     .max()
                     .getAsInt();
    }
}

public class SmoothestNumber {
    int s(int a, int b) {
        return IntStream.range(a,b+1)
                        .boxed()
                        .map(F::new)
                        .sorted(comparingInt(F::getD))
                        .collect(toList())
                        .get(0).i;
    }
}
