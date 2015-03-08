package net.codetojoy.egg.stream;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import java.util.function.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

class TimesTen implements UnaryOperator<Integer> {
    @Override public Integer apply(Integer n) { return n*10; }
}

class Foo {
    private int value;
    public Foo(int i) { value = i; }
    public int getValue() { return value; }
}

class Bar {
    private Foo foo;
    public Bar(Foo foo) { this.foo = foo; }
    public Foo getFoo() { return foo; }
}

public class StreamTestCase {
    @Test
    public void testJoiningCollector() {
        List<String> list = Arrays.asList("Mozart", "Bach", "Chopin");

        // test 
        String result = list.stream().collect(joining(", "));

        assertEquals("Mozart, Bach, Chopin", result);
    }
    
    @Test
    public void testMap_Basic() {
        int lower = 1;
        int upper = 10;

        // test ... map ints to Foo objects
        Stream<Foo> results = IntStream.range(lower, upper+1).boxed().map(Foo::new);

        List<Foo> list = results.collect(toList());
        assertEquals(10, (int) list.size());
        assertEquals(1, list.get(0).getValue());
    }

    @Test
    public void testMap_CompositeFunctions() {
        int lower = 1;
        int upper = 10;
        
        Function<Integer,Foo> f1 = i -> new Foo(i);
        Function<Foo,Bar> f2 = f -> new Bar(f);        

        // test ... map int -> Foo -> Bar
        Stream<Bar> results = IntStream.range(lower, upper+1).boxed().map( f1.andThen(f2) );

        List<Bar> list = results.collect(toList());
        assertEquals(10, (int) list.size());
        assertEquals(1, list.get(0).getFoo().getValue());
    }
    
    @Test
    public void testFilter_EvenIntegers() {
        int lower = 1;
        int upper = 100;

        // test ... even ints in range [lower, upper]
        Stream<Integer> results = IntStream.range(lower, upper+1).boxed().filter(i -> i % 2 == 0);

        List<Integer> list = results.collect(toList());
        assertEquals(50, (int) list.size());
    }
    
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
}