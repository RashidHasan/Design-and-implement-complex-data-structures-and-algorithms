public class Order {

    private  int orderID;
    private  DLLItems listOfItems;
    private  float totalPrice;

    //-----------------------------------------------------------------

    public  int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public DLLItems getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(DLLItems listOfItems) {
        this.listOfItems = listOfItems;
    }

    public  float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    //-----------------------------------------------------------------

    public Order(int orderID, DLLItems listOfItems, float totalPrice) {
        this.orderID = orderID;
        if (listOfItems!=null){
            this.listOfItems = listOfItems;
        } else {
            System.out.println("List of is empty");
        }
        this.totalPrice = (float) calculateTP();
    }

    public float calculateTP() {
        totalPrice = 0;
        ItemNode currentNode = listOfItems.head;
        while (currentNode != null) {
            totalPrice += currentNode.value.getPrice();
            currentNode = currentNode.next;
        }
        return -1;
    }


    public void printerOrdering() {
        // Check if the list of items is empty
        if (listOfItems != null && listOfItems.head != null) {
            System.out.println("*****");
            System.out.println("Order ID: " + getOrderID());
            System.out.println("Order Items:");
            ItemNode currentNode = listOfItems.head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
            calculateTP();
            System.out.println("Total price: " + getTotalPrice());
        } else {
            System.out.println("No items in this Order.");
        }
    }

    @Override
    public String toString() {
        return "Order(" +
                "orderID=" + orderID +
                ", items=" + listOfItems +
                ", totalPrice=" + totalPrice +
                ')';
    }

}


