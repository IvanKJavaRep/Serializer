package org.example;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        MyObject myObject = new MyObject("kk", null, "ffdsaf");
        System.out.println(JsonSerilizationUtils.serialize(myObject));
    }
}