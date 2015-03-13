package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/47201/check-whether-letters-of-word-are-in-alphabetical-order
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class SortDetectorTestCase {
    @Test
    public void testSortDetector_case1() {        
        // test
        int result = new SortDetector().f("abc");
        
        assertTrue(result > 0);
    }
    
    @Test
    public void testSortDetector_case2() {        
        // test
        int result = new SortDetector().f("aa");
        
        assertTrue(result <= 0);
    }
    
    @Test
    public void testSortDetector_case3() {        
        // test
        int result = new SortDetector().f("abcdefGHIjklmnopqrSTUVWXyz");
        
        assertTrue(result > 0);
    }

    @Test
    public void testSortDetector_case4() {        
        // test
        int result = new SortDetector().f("puZ");
        
        assertTrue(result > 0);
    }

    @Test
    public void testSortDetector_case5() {        
        // test
        int result = new SortDetector().f("Puz");
        
        assertTrue(result > 0);
    }

    @Test
    public void testSortDetector_case6() {        
        // test
        int result = new SortDetector().f("cba");
        
        assertTrue(result <= 0);
    }
}