package net.codetojoy.egg.stream;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.toList;

public class IntStreamTestCase {    
    @Test
    public void testRandomInts() {
        int lower = 1;
        int upper = 100;
        
        // test ... 1000 random ints in range [lower, upper]
        IntStream results = new Random().ints(lower, upper+1).limit(1000);
        
        results.forEach( i -> assertTrue((lower <= i) && (i <= upper)) );
    }
}