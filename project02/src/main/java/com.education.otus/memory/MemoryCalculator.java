package com.education.otus.memory;

public class MemoryCalculator {

    public void calculateMemory(Integer object) throws InterruptedException {
        long mem = getMem();
        Integer x = 1;
        long mem2 = getMem() - mem;
        System.out.println(mem2);
    }

    public void calculateMemory(TestClass object) throws InterruptedException {
        long mem = getMem();
        TestClass x = new TestClass();
        long mem2 = getMem() - mem;
        System.out.println(mem2);
    }

    public void calculateMemory(String object) throws InterruptedException {
        long mem = getMem();
        String x = new String("");
        long mem2 = getMem() - mem;
        System.out.println(mem2);
    }

    public void calculateMemory(byte object) throws InterruptedException {
        long mem = getMem();
        byte x = 1;
        long mem2 = getMem() - mem;
        System.out.println(mem2);
    }
    public void calculateMemory(int[] mass) throws InterruptedException {
        long mem = getMem();
        int[] tmpMass = new int[10];
        long mem2 = getMem() - mem;
        System.out.println(mem2);
    }

    private long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public void differentCalc(Object object, int count) throws InterruptedException{
        if (count == 0) {
        System.out.println("U're count is 0, so memory value is 0");
        return;
        }

        Object[] mass = new Object[count];
        long memory = getMem();

        for (int i = 0; i < mass.length; i++) {
        if (object instanceof Integer) mass[i] = 1;
        else if (object instanceof Long) mass[i] = 1L;
        else if (object instanceof Character) mass[i] = 'a';
        else if (object instanceof TestClass) mass[i] = new TestClass();
        else if (object instanceof String) mass[i] = new String();
        }

        long oneMemObj = Math.abs(memory - getMem()) / mass.length;
        long countMemObj = Math.abs(memory - getMem());

        mass = null;

        System.out.println(oneMemObj);
        System.out.println(countMemObj);
    }

}



