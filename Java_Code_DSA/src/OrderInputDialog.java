import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderInputDialog extends JPanel {

    private JTextField orderIDField;
    private JTextArea itemsTextArea;
    private JTextField totalPriceField;

    public OrderInputDialog() {
        setLayout(new GridLayout(3, 2));
        setPreferredSize(new Dimension(300, 150));

        JLabel orderIDLabel = new JLabel("Order ID:");
        orderIDField = new JTextField();
        JLabel itemsLabel = new JLabel("Items (separated by comma):");
        itemsTextArea = new JTextArea();
        JLabel totalPriceLabel = new JLabel("Total Price:");
        totalPriceField = new JTextField();

        add(orderIDLabel);
        add(orderIDField);
        add(itemsLabel);
        add(itemsTextArea);
        add(totalPriceLabel);
        add(totalPriceField);
    }

    public Order getOrder() {
        int orderID = Integer.parseInt(orderIDField.getText());
        String itemsString = itemsTextArea.getText();
        String[] itemsArray = itemsString.split(",");
        DLLItems itemList = new DLLItems();
        for (String item : itemsArray) {
            String itemName = item.trim();
            double itemPrice = 0.0; // You can add logic to fetch the item price based on the item name.
            itemList.addItem(new Item(itemName, itemPrice));
        }
        float totalPrice = Float.parseFloat(totalPriceField.getText());
        return new Order(orderID, itemList, totalPrice);
    }
}
