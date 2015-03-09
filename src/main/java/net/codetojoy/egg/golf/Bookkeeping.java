package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/47385
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import java.util.stream.*;
import java.util.*;

public class Bookkeeping {
    boolean f(int t, IntStream s) {
        int r = 1;
        try {
            s.reduce(0,(a,b) -> (a+b>=t) ? (a+b) : (a/(a-a)) );
        } catch(Exception e) {
            r = 0;
        }
        return r == 1;
    } 
}
