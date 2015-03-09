package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/47385
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import java.util.stream.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class BookkeepingTestCase {
    private final int t = -5;
    private Bookkeeping bookkeeping = new Bookkeeping();
    
    @Test
    public void testCase_1() {
        IntStream s = Arrays.asList(-6).stream().mapToInt(i->i);
        
        // test
        boolean result = bookkeeping.f(t,s);
        
        assertFalse(result);
    }

    @Test
    public void testCase_2() {
        IntStream s = Arrays.asList(1,2,3,-20).stream().mapToInt(i->i);
        
        // test
        boolean result = bookkeeping.f(t,s);
        
        assertFalse(result);
    }

    @Test
    public void testCase_3() {
        IntStream s = Arrays.asList(200,-300,1000).stream().mapToInt(i->i);
        
        // test
        boolean result = bookkeeping.f(t,s);
        
        assertFalse(result);
    }

    @Test
    public void testCase_4() {
        IntStream s = Arrays.asList(4,-3,-6).stream().mapToInt(i->i);
        
        // test
        boolean result = bookkeeping.f(t,s);
        
        assertTrue(result);
    }

    @Test
    public void testCase_5() {
        IntStream s = Arrays.asList(-5).stream().mapToInt(i->i);
        
        // test
        boolean result = bookkeeping.f(t,s);
        
        assertTrue(result);
    }    
}