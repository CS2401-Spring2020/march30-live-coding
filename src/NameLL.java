import java.util.LinkedList;

public class NameLL {

    String name;
    int counter;
    NameLL next;

    public NameLL(String name){
        this.name = name;
        this.counter = 0;
        this.next = null;
        incrementCounter();

    }
    public void incrementCounter(){
        this.counter++;
    }

    public void addName(String name){
        if(name.equals(this.name)){
            this.incrementCounter();
        }else if(this.next!=null){
            this.next.addName(name);
        }else{
            this.next = new NameLL(name);
        }
//        NameLL current = this;
//        while(current.next!=null){
//            current = current.next;
//        }
//        current.next = new NameLL(name);
    }

    public void printLL(){
        NameLL temp = this;
        while(temp!=null){
            System.out.println("name: " + temp.name + " counter: " + temp.counter);
            temp = temp.next;
        }
    }
    public void printListInReverse(){
        if(this.next==null){
            System.out.println("Name: " + this.name + " counter: " + this.counter);
            return;
        }
        this.next.printListInReverse();
        System.out.println("Name: " + this.name + " counter: " + this.counter);
    }

    public NameLL fromNamesArray(String [] names){
        if(names.length == 0){
            return null;
        }
        NameLL list = new NameLL(names[0]);
        for(int i = 1; i < names.length; i++){
            addName(names[i]);
        }
        return list;
    }
    public static NameLL sort(NameLL inList){
        if(inList == null || inList.next == null){
            return inList;
        }
        NameLL middlePointer = findMiddle(inList);
        NameLL nextToMiddlePointer = middlePointer.next;
        middlePointer.next = null;

        NameLL left = sort(inList);
        NameLL right = sort(nextToMiddlePointer);

        NameLL sortedList = merge(left, right);
        return sortedList;
    }
    /*
    Function to merge list after it was splitted by sort() method - CONQUER
     */
    private static NameLL merge(NameLL left, NameLL right){
        // Base Cases here
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        // We are going to check the first char of the string to sort
        // Carlos - Alex
        NameLL result = null;
        if(left.name.charAt(0) <= right.name.charAt(0)){
            result = left;
            result.next = merge(left.next, right);
        }else{
            result = right;
            result.next = merge(left, right.next);
        }
        return result;

    }
    /*
    Function to find the middle of the linked list
     */
    private static NameLL findMiddle(NameLL head){
        if(head == null){
            return head;
        }
        NameLL slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
