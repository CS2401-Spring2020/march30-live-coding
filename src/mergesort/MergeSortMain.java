package mergesort;

/*
    Author: Carlos Chavez
    Merge sort applied to a list of numbers for your reference
 */

public class MergeSortMain {
    public static void main(String[]args){

        NumberLinkedList list = new NumberLinkedList(3);
        list.addNumber(10);
        list.addNumber(5);
        list.addNumber(1);
        list.addNumber(4);
        list.addNumber(4);

        list.printList();
        System.out.println();
        NumberLinkedList newList = list.mergeSort();
        newList.printList();
    }
}
