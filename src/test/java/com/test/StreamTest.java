package com.test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<String>();
        array.add("Abhay");
        array.add("Swaraj");
        array.add("Krishna");
        array.add("Chirag");


        long c=array.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        System.out.println(array.stream().filter(s -> s.contains("a")).count());
        array.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        System.out.println(Stream.of("Test","Untest","Recovery").filter(s -> s.contains("est")).count());






    }
}
