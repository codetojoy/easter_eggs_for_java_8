package net.codetojoy.egg.stream;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.toList;

class TimesTen implements UnaryOperator<Integer> {
    @Override public Integer apply(Integer n) { return n*10; }
}

public class StreamTestCase {
    @Test
    public void testIterate_WithExplicitFunction() {
        Integer i = 2;
        UnaryOperator<Integer> timesTen = new TimesTen();
        
        // test ... iterate is f(f(f(x)))
        Stream<Integer> stream = Stream.iterate(i, timesTen).limit(4);
        
        List<Integer> results = stream.collect(toList());
        int result = results.get(results.size() - 1);        
        assertEquals(2000, result);
    }
    
    @Test
    public void testIterate_WithLambda() {
        Integer i = 2;
                
        // test ... iterate is f(f(f(x)))
        Stream<Integer> stream = Stream.iterate(i, x -> x * 10).limit(4);
        
        List<Integer> results = stream.collect(toList());
        int result = results.get(results.size() - 1);        
        assertEquals(2000, result);
    }
    
    @Test
    public void testRandomInts() {
        int lower = 1;
        int upper = 100;
        
        // test ... 1000 random ints in range [lower, upper]
        IntStream results = new Random().ints(lower, upper+1).limit(1000);
        
        results.forEach( i -> assertTrue((lower <= i) && (i <= upper)) );
    }
}