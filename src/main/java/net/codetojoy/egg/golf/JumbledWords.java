package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/37686/check-the-jumbled-words
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import java.util.stream.*;

import static java.util.stream.Collectors.joining;

public class JumbledWords {
    // return sorted string, all lower-case, no spaces
    String g(String s) {
           return s.toLowerCase()
                   .chars()
                   .mapToObj(i -> ("" + (char) i).trim())
                   .sorted()
                   .collect(joining(""));
    }
    
    // return true if strings are effectively anagrams
    boolean f(String a, String b) {
        return g(a).equals(g(b));
    }
}
