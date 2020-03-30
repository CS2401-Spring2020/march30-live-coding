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
        return null;
    }
    /*
    Function to merge list after it was splitted by sort() method - CONQUER
     */
    private static NameLL merge(NameLL left, NameLL right){
        return null;

    }
    /*
    Function to find the middle of the linked list
     */
    private static NameLL findMiddle(NameLL head){
        return null;
    }
}
