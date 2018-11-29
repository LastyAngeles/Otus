import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(1,2,3));
        List<Integer> list2 = new MyArrayList<>();
        list2.addAll(Arrays.asList(1001,1002,1003));

        System.out.println(list1);
        Collections.copy(list1, list2);
        System.out.println(list1);
    }
}
