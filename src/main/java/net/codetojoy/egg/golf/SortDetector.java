package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/47201/check-whether-letters-of-word-are-in-alphabetical-order
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

public class SortDetector {
    // return 1 if chars are sorted (case-insenstive), else <= 0
    int f (String s) {
        return s.toLowerCase()
                .chars()
                .reduce(0, (v,c) -> (v<0)? v : (c>v)?c:-1);
    }
}
