package Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MainFrame class
public class MainFrame extends JFrame
{
    private JComboBox<String> cityList;
    private JComboBox<String> yearCombo;
    private JTextArea displayArea;
    private PetrolPriceCalculator calculator;

    // Constructor sets up GUI
    public MainFrame()
    {
        calculator = new PetrolPriceCalculator();

        setTitle("Petrol Price Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Apply font
        setFontStyle();

        // Create the main panel with GridBagLayout for centered alignment
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);  // Set background for main panel

        // Constraints for GridBagLayout to center components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Fill horizontally to align

        // Selection panel containing city and year selection
        JPanel selectionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        selectionPanel.setBackground(Color.WHITE);
        cityList = new JComboBox<>(new String[] {"Johannesburg", "Durban", "Cape Town"});
        styleComboBox(cityList);
        yearCombo = new JComboBox<>(new String[] {"2017", "2018", "2019"});
        styleComboBox(yearCombo);

        selectionPanel.add(new JLabel("Select City: ", JLabel.RIGHT));
        selectionPanel.add(cityList);
        selectionPanel.add(new JLabel("Select Year: ", JLabel.RIGHT));
        selectionPanel.add(yearCombo);

        // Display area for output, styled like a Material Design card
        displayArea = new JTextArea(3, 25);
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayArea.setBackground(new Color(245, 245, 245)); // Light grey background
        displayArea.setForeground(Color.DARK_GRAY);

        // Submit button styled with primary color
        JButton submitButton = new JButton("Submit");
        styleButton(submitButton);
        submitButton.addActionListener(new SubmitAction());

        // Add selection panel at the top
        gbc.gridy = 0; // First row
        mainPanel.add(selectionPanel, gbc);

        // Add display area in the middle
        gbc.gridy = 1; // Second row
        mainPanel.add(displayArea, gbc);

        // Add submit button at the bottom
        gbc.gridy = 2; // Third row
        mainPanel.add(submitButton, gbc);

        // Add mainPanel to the center of the JFrame
        add(mainPanel, BorderLayout.CENTER);

        setupMenu();
        setVisible(true);
    }

    // Set Roboto font if available, otherwise fallback to system default
    private void setFontStyle()
    {
        Font roboto = new Font("Roboto", Font.PLAIN, 14);
        if (roboto.getFamily().equals("Roboto"))
        {
            setFont(roboto);
        }
    }

    // Style ComboBox with borderless, flat design
    private void styleComboBox(JComboBox<String> comboBox)
    {
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.DARK_GRAY);
        comboBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    // Style button
    private void styleButton(JButton button)
    {
        button.setBackground(new Color(66, 133, 244)); // Google Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Setup menu
    private void setupMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem submitMenuItem = new JMenuItem("Submit");
        submitMenuItem.addActionListener(new SubmitAction());
        JMenuItem reportMenuItem = new JMenuItem("Report");
        reportMenuItem.addActionListener(e -> displayReport());

        toolsMenu.add(submitMenuItem);
        toolsMenu.add(reportMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        setJMenuBar(menuBar);
    }

    // Display average price report in the display area
    private void displayReport()
    {
        displayArea.setText(calculator.generateAveragePriceReport());
    }

    // Inner class to handle submit button actions
    private class SubmitAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String city = (String) cityList.getSelectedItem();
            int year = Integer.parseInt((String) yearCombo.getSelectedItem());
            double price = calculator.getPetrolPrice(city, year);
            displayArea.setText("Petrol price in " + city + " for " + year + " is: " + price + " per litre");
        }
    }

    // Main method to launch the application
    public static void main(String[] args)
    {
        new MainFrame();
    }
}
