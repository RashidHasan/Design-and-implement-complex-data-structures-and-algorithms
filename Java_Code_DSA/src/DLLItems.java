public class DLLItems {

    protected ItemNode head;
    protected ItemNode tail;

    //-----------------------------------------------------------------

    DLLItems() {
        head = tail = null;
    }

    //-----------------------------------------------------------------


    public void addToHead(Item item) {

       ItemNode  newNode = new ItemNode(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            head.prev = newNode;
            newNode.next = head;

            head = newNode;
        }

    }

    public void addItem(Item v) {

        // complexity : O(1)

        ItemNode newNode = new ItemNode(v);
        if(tail==null){
            addToHead(v);
            return;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

    }

    public Item removeItem(){
        if(head == null){
            System.out.println("list is empty");
            return null;
        } else{

                ItemNode deletedNode = head;
                head = head.next;
                if (head!= null){
                    head.prev = null;
                } else {
                    tail = null;
                    deletedNode.next = null;
                }

                return deletedNode.value;
            }
        }


    public void printAll() {
        ItemNode crt = head;
        while (crt != null) {
            System.out.println(crt.value);
            crt = crt.next;
        }
    }





}
