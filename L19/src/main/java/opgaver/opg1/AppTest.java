package opgaver.opg1;

public class AppTest {
    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(0);
        list.add(10);

        System.out.println(list);

        System.out.println(list.size());
    }
}
