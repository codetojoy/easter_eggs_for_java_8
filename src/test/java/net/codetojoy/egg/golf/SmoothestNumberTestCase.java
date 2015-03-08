package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/36384/find-the-smoothest-number
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class SmoothestNumberTestCase {
    @Test
    public void testSmoothestNumber() {
        List<Integer> expected = new ArrayList<>();
        expected.add(162);
        expected.add(192);
        expected.add(216);
        expected.add(243);
        
        // test
        int result = new SmoothestNumber().s(157,249);
        
        assertTrue(expected.contains(result));
    }
}