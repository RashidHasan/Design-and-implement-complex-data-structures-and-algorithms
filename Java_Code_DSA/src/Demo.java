public class Demo {
    public static void main(String[] args) {


        // Create sample items
        Item item1 = new Item("Big Mac", 5.0);
        Item item2 = new Item("Hot Chocolate", 3.0);
        Item item3 = new Item("Apple pie", 5.0);
        Item item4 = new Item("Sprite",1.5);
        Item item5 = new Item("Fries",3.0);

        //-----------------------------------------------------------------


        // Create a DLLItems object and add items
        DLLItems itemList1 = new DLLItems();

        itemList1.addItem(item1);
        itemList1.addItem(item2);
        itemList1.addItem(item3);

        DLLItems itemList2 = new DLLItems();
        itemList2.addItem(item5);

        DLLItems itemList3 = new DLLItems();


        //-----------------------------------------------------------------

        // Create sample orders
        float totalPrice = 0;
        Order order1 = new Order(1, itemList1, totalPrice);
        Order order2 = new Order(2, itemList2, totalPrice);
        Order order3 = new Order(3,itemList3, totalPrice);
        Order order5 = new Order(1,new DLLItems(), totalPrice);

        // Create a DLLOrder object and add orders
        DLLOrder orderList = new DLLOrder();
        orderList.addOrder(order1);
        orderList.addOrder(order2);
        orderList.addOrder(order3);

        //-----------------------------------------------------------------


        // Create a Queue object and enqueue orders
        Queue orderQueue = new Queue();
       orderQueue.enqueue(order1);
       orderQueue.enqueue(order2);
      // orderQueue.enqueue(order3);
        //orderQueue.enqueue(new Order(3,itemList2));
      //orderQueue.dequeue();

        //orderQueue.dequeue();
     //orderQueue.dequeue();



        //-----------------------------------------------------------------


        // Dequeue an order
        // Order dequeuedOrder = orderQueue.dequeue();

        // Print the details of the dequeued order
        Order dequeuedOrder;
        while (true) {
            dequeuedOrder = orderQueue.dequeue();
            if (dequeuedOrder != null) {
                dequeuedOrder.printerOrdering();
            } else {
                System.out.println("No order dequeued.");
                break;
            }
        }

    }





}
