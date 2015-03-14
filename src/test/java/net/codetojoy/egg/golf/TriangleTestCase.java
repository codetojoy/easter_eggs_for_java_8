package net.codetojoy.egg.golf;

// Do NOT mimic this style in real code! These are solutions for a game called "code golf".
//
// See http://codegolf.stackexchange.com/questions/37686/check-the-jumbled-words
//
// This is pseudo-golfed: it can clearly be condensed into something tighter but I
// want a mix of brevity and readability.

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class TriangleTestCase {
    @Test
    public void testTriangle() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("1\n");
        buffer.append("1 2\n");
        buffer.append("1 2 3\n");
        buffer.append("1 2 3 4");
        
        // test
        String result = new Triangle().t(4);
        
        assertEquals(buffer.toString(), result);
    }
}