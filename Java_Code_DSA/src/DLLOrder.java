public class DLLOrder {

     protected OrderNode head;
     protected OrderNode tail;

    //-----------------------------------------------------------------


    DLLOrder() {
        head = tail = null;
    }

    //-----------------------------------------------------------------



    public void addToHead(Order order) {
        /*
          complexity : O(1)
        */
        OrderNode newNode = new OrderNode(order);

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

    public void addOrder(Order order) {
        /*
        complexity : O(1)
        */
        OrderNode newNode = new OrderNode(order);
        if(tail==null){
            addToHead(order);
            return;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

    }


    public Order removeOrder(){
        if(head == null){
            System.out.println("list is empty");
            return null;
        }
        else{

            OrderNode deletedNode = head;
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

}
