package mergesort;

/*
    Author: Carlos Chavez
    Merge sort applied to a list of numbers for your reference
 */
public class NumberLinkedList {
    int number;
    NumberLinkedList next;

    public NumberLinkedList(int number){
        this.number = number;
        this.next = null;
    }

    public void addNumber(int number){
        NumberLinkedList current = this;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new NumberLinkedList(number);
    }
    public void printList(){
        NumberLinkedList head = this;
        while(head!=null){
            System.out.print(head.number + " ");
            head = head.next;
        }
        System.out.println();
    }
    public NumberLinkedList mergeSort(){
        if(this == null || this.next == null ){
            return this;
        }
        NumberLinkedList middle = this.getMiddle();
        NumberLinkedList nextOfMiddle = middle.next;

        middle.next = null;

        NumberLinkedList left = this.mergeSort();
        NumberLinkedList right = nextOfMiddle.mergeSort();

        NumberLinkedList sortedList = merge(left, right);
        return sortedList;
    }
    public NumberLinkedList merge(NumberLinkedList left,
                                  NumberLinkedList right){
        NumberLinkedList result = null;
        // base cases
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.number <= right.number){
            result = left;
            result.next = merge(left.next, right);
        }
        else{
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
    public NumberLinkedList getMiddle(){
        if(this == null){
            return this;
        }
        NumberLinkedList slow = this, fast = this;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
