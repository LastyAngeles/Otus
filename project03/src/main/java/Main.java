import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new MyArrayList<>();
        list1.addAll(Arrays.asList(1,3,2,4,7,1,1,1,1,1,1,1,1,1));
        System.out.println(list1.size());

        List<Integer> list2 = new MyArrayList<>();
        list2.addAll(Arrays.asList(1001,1002,1003,1,2,3,4,5,6,7,8,9));
        System.out.println(list2.size());

        System.out.println(list1);
        Collections.copy(list1, list2);
        System.out.println(list1);

        Collections.addAll(list1, 1,2,3,4,5);
        Collections.sort(list1);

        System.out.println(list1.size());

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
}
