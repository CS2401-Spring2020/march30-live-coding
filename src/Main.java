import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        String [] names = {"Carlos", "Alex", "Isaac","Carlos", "Daniela", "Dan", "Dan"};

        NameLL list = new NameLL(names[0]);
        list.fromNamesArray(names);

        list.printLL();
        System.out.println();
        System.out.println("List printed in reverse order");
        list.printListInReverse();

        System.out.println();
        System.out.println("Sorted List");
        NameLL sortedList = NameLL.sort(list);
        sortedList.printLL();

        System.out.println(sortedList.isSorted());

//        System.out.println(Arrays.toString(sortedList.initialsList()));

        System.out.println("List Size");
        System.out.println(sortedList.listSize());
        System.out.println(Arrays.toString(sortedList.getInitials()));

        String [] names1 = {"Carlos", "Alex", "Isaac","Carlos", "Isaac", "Dan", "Dan"};
        String [] names2 = {"Alex", "Carlos", "Isaac", "Dan", "Dan", "Alex"};

        System.out.println("test");
        NameLL list1 = new NameLL(names1[0]);
        list1.fromNamesArray(names1);
        list1.printLL();
        list1 = NameLL.sort(list1);

        System.out.println("test");
        NameLL list2 = new NameLL(names2[0]);
        list2.fromNamesArray(names2);
        list2.printLL();
        list2 = NameLL.sort(list2);

        int diff = list1.compareNameLL(list2);
        System.out.println(diff);


    }
}
