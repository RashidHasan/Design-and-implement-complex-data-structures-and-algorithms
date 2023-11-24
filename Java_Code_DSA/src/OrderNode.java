public class OrderNode {
   protected Order value;
   protected OrderNode next;
   protected OrderNode prev;

    public OrderNode(Order v){
        value = v;
        next = null;
        prev = null;
    }
}
