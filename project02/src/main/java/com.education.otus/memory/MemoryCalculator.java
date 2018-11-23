package com.education.otus.memory;

import java.util.function.Supplier;

public class MemoryCalculator {

    private static int ARR_SIZE = 200_000_000;
    private static int ARR_SIZE_OBJ = 300_000;

    public long calculateInt() throws InterruptedException{
        long memory = getMem();
        int[] intMass = new int[ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            intMass[i] = i;
        }

        long result = (getMem() - memory) / ARR_SIZE;
        System.out.println("Memory for int: " + result + ", mass length is " + ARR_SIZE);
        return result;
    }

    public long calculateByte() throws InterruptedException {
        byte[] byteMass = new byte[ARR_SIZE];
        long memory = getMem();

        for (int i = 0; i < ARR_SIZE; i++) {
            byteMass[i] = (byte) 1;
        }

        long result = (getMem() - memory) / ARR_SIZE;
        System.out.println("Memory for byte: " + result + ", mass length is " + ARR_SIZE);
        return result;
    }

    public long calculateLong() throws InterruptedException {
        long memory = getMem();
        long[] longMass = new long[ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            longMass[i] = i;
        }

        long result = (getMem() - memory) / ARR_SIZE;
        System.out.println("Memory for long: " + result + ", mass length is " + ARR_SIZE);
        return result;
    }

    public long calculateShort() throws InterruptedException {
        long memory = getMem();
        short[] longMass = new short[ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            longMass[i] = (short) 1;
        }

        long result = (getMem() - memory) / ARR_SIZE;
        System.out.println("Memory for short: " + result + ", mass length is " + ARR_SIZE);
        return result;
    }

    public long calculateChar() throws InterruptedException {
        long memory = getMem();
        char[] longMass = new char[ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            longMass[i] = (char) i;
        }

        long result = (getMem() - memory) / ARR_SIZE;
        System.out.println("Memory for short: " + result + ", mass length is " + ARR_SIZE);
        return result;
    }

    public <T> long calculateObject(Supplier<T> supplierObject) throws InterruptedException{
        long memory = getMem();
        Object[] massObj = new Object[ARR_SIZE_OBJ];

        for (int i = 0; i < ARR_SIZE_OBJ; i++) {
            massObj[i] = supplierObject.get();
        }

        long result = (getMem() - memory) / ARR_SIZE_OBJ;
        System.out.println("Memory for object " + result + ", mass length is " + ARR_SIZE_OBJ);
        return result;

    }

    public void calculatePrimitive() throws InterruptedException{
        calculateByte();
        calculateShort();
        calculateChar();
        calculateInt();
        calculateLong();
    }

    private long getMem() throws InterruptedException {
        System.gc();
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }

        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

}



