import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueGUI extends JFrame {

    private Queue orderQueue;
    private DefaultTableModel tableModel;
    private JTable orderTable;
    private JButton enqueueButton;
    private JButton dequeueButton;

    public QueueGUI() {
        // Create a Queue object
        orderQueue = new Queue();

        // Set up the JFrame
        setTitle("Order Queue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);

        // Create GUI components
        tableModel = new DefaultTableModel(new Object[]{"Order ID", "Items", "Total Price"}, 0);
        orderTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        enqueueButton = new JButton("Enqueue Order");
        dequeueButton = new JButton("Dequeue Order");

        // Add components to the JFrame
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(enqueueButton);
        buttonPanel.add(dequeueButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Register action listeners for buttons
        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a dialog box to input order details
                OrderInputDialog inputDialog = new OrderInputDialog();
                int result = JOptionPane.showConfirmDialog(QueueGUI.this, inputDialog,
                        "Enter Order Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    Order order = inputDialog.getOrder();
                    orderQueue.enqueue(order);
                    updateTable();
                }
            }
        });

        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order dequeuedOrder = orderQueue.dequeue();
                if (dequeuedOrder != null) {
                    dequeuedOrder.printerOrdering();
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(QueueGUI.this, "No order dequeued.");
                }
            }
        });
    }

    private void updateTable() {
        // Clear the table and show the orders in the queue
        tableModel.setRowCount(0);
        Queue tempQueue = new Queue();
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            addOrderToTable(order);
            tempQueue.enqueue(order);
        }
        orderQueue = tempQueue;
    }

    private void addOrderToTable(Order order) {
        String orderID = String.valueOf(order.getOrderID());
        String items = order.getListOfItems().toString();
        String totalPrice = String.format("%.2f", order.getTotalPrice());
        tableModel.addRow(new Object[]{orderID, items, totalPrice});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QueueGUI().setVisible(true);
            }
        });
    }
}
