package com.education.otus.memory;

public class Main {
    public static void main(String[] args) {
        MemoryCalculator memoryCalculator = new MemoryCalculator();
        try {
            memoryCalculator.calculatePrimitive();
            memoryCalculator.calculateObject(() -> new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
