package CustomerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScrollPaneExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("JPanel Click Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a JPanel that will be clicked
        JPanel clickPanel = new JPanel();
        clickPanel.setBackground(Color.LIGHT_GRAY);
        clickPanel.setPreferredSize(new Dimension(400, 100));
        clickPanel.setBorder(BorderFactory.createTitledBorder("Click Me"));

        // Create a JScrollPane with a JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        // Add a mouse listener to the JPanel
        clickPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the list model and add new items when the panel is clicked
                listModel.clear();
                listModel.addElement("Item 1");
                listModel.addElement("Item 2");
                listModel.addElement("Item 3");
                listModel.addElement("Item 4");
                listModel.addElement("Item 5");
                listModel.addElement("Item 6");
                listModel.addElement("Item 7");
                listModel.addElement("Item 8");
                listModel.addElement("Item 9");
                listModel.addElement("Item 10");
            }
        });

        // Add components to the frame
        frame.add(clickPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}