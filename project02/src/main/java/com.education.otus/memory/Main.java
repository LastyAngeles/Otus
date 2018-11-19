package com.education.otus.memory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MemoryCalculator calculator = new MemoryCalculator();
        calculator.calculateMemory(new TestClass());
        calculator.calculateMemory(1);
        calculator.calculateMemory(new String(""));
        Byte b = 1;
        calculator.calculateMemory(b);
        calculator.calculateMemory(new int[10]);
    }
}