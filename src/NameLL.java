import java.util.LinkedList;

public class NameLL {

    String name;
    int counter;
    NameLL next;

    // added default constructor
    public NameLL(){}

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

    // to be completed
    public char[] getInitials(){
        return null;
    }
    // to be completed
    public char[] getInitials(char[]initials, int pos){
        return null;
    }
    // helper method to get listSize
    public int listSize(){
        int counter = 0;
        NameLL temp = this;
        while (temp!=null){
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    // so far works only with a ll same size and aminos in same position
    public int compareNameLL(NameLL inList){
        // start with a simple scenario
        // assume both link lists are of the same size
        // and have aminos placed in the same position
        if(this == null && inList == null){
            return 0;
        }
        int diff = 0;
        if(this.name.charAt(0) == inList.name.charAt(0)){
            diff += Math.abs(this.counter - inList.counter);
            if(this.next!= null && inList.next!=null){
                diff += this.next.compareNameLL(inList.next);
            }
        }
//        if(this.name.charAt(0) > inList.name.charAt(0)){
//            diff = inList.counter;
//            diff += this.compareNameLL(inList.next);
//        }
        // there is the case where this.name.charAt(0) < inList.name.charAt(0)
        // missing

        return diff;
    }

    // alex > carlos > daniela
    public boolean isSorted(){
        if(this.next == null){
            return true;
        }
        if(this.name.charAt(0) > this.next.name.charAt(0)){
            return false;
        }else if(this.next.next!=null){
            this.next.isSorted();
        }
        return true;
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
    Function to merge list after it is split by sort() method - CONQUER
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
