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
    }
}
