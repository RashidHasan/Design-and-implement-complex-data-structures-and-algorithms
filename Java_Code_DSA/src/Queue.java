public class Queue {

    private DLLOrder list;
    private OrderNode first,last;

    //-----------------------------------------------------------------


    public Queue() {
        list = new DLLOrder();
        first = last = null;
    }

    //-----------------------------------------------------------------


    void enqueue(Order order){
        list.addOrder(order);
        first = list.tail;
    }

    Order dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        Order  temp = list.removeOrder();
        first = list.head;
        return temp;
    }

    public boolean isEmpty(){
        return first == null && last == null;
    }

}
