package graphicalUI;

import valuableList.ValuableList;
import valuables.Jewellery;
import valuables.Stock;
import valuables.Apparatus;
import valuables.Valuable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUI extends JFrame {

    private ValuableList valuableList;
    private JTextArea field;
    private Stock stock;


    public GraphicalUI() {
        super("Register");

        valuableList = new ValuableList();

        setLayout(new BorderLayout());
//        JPanel north = new JPanel();
        JLabel labelValuables = new JLabel("Valuables", SwingConstants.CENTER);
        add(labelValuables, BorderLayout.NORTH);

        field = new JTextArea();
        add(field, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(field);
        add(scroll);


        JPanel east = new JPanel();
        east.setLayout(new BorderLayout());
        JLabel labelSort = new JLabel();

        JPanel eastside = new JPanel();
        east.add(eastside, BorderLayout.SOUTH);
        eastside.setLayout(new BoxLayout(eastside, BoxLayout.Y_AXIS));

        eastside.add(new JLabel("Sort by"));
        JRadioButton name = new JRadioButton("Name");
        eastside.add(name);
        name.addActionListener(new NameListener());

        JRadioButton value = new JRadioButton("Value");
        eastside.add(value);
        value.addActionListener(new ValueListener());

        ButtonGroup bg = new ButtonGroup();
        bg.add(name);
        bg.add(value);


        add(east, BorderLayout.EAST);


        JPanel south = new JPanel();
        String[] choice = {"", "Jewellery", "Stock", "Apparatus"};
        JComboBox<String> comboChoice = new JComboBox<String>(choice);
        south.add(new JLabel("New:"));
        south.add(comboChoice);
        comboChoice.addActionListener(new NewListener());

        JButton showButton = new JButton("Show");
        south.add(showButton);
        showButton.addActionListener(new ShowListener());

        JButton stockButton = new JButton("Stock market crash");
        south.add(stockButton);
        stockButton.addActionListener(new StockListener());


        add(south, BorderLayout.SOUTH);


        setVisible(true);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ValueListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            valuableList.sortValuables();
//        System.out.print("Hej");
        }
    }

    class NameListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            valuableList.sortName();
//        System.out.print("Hej");
        }
    }

    class NewListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            JComboBox boxen = (JComboBox) ave.getSource();
            System.out.print(boxen.getSelectedItem());


            try {
                NewJewelleryForm jf = new NewJewelleryForm();
                NewStockForm sf = new NewStockForm();
                NewApparatusForm af = new NewApparatusForm();


                if (boxen.getSelectedItem().equals("Jewellery")) {
                    int svar = JOptionPane.showConfirmDialog(GraphicalUI.this, jf,
                            "New Jewellery",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (svar != JOptionPane.OK_OPTION)
                        return;
                    String name = jf.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(GraphicalUI.this, "Inget namn!");
                        return;
                    }
                    int numberOfStones = jf.getNumberOfStones();
                    boolean isGold = jf.getIsGold();

                    System.out.print(jf.getName());

                    Jewellery jw = new Jewellery(jf.getName(), jf.getNumberOfStones(), jf.getIsGold());
                    valuableList.add(jw);
//                    System.out.print(valuableList);

                }
                if (boxen.getSelectedItem().equals("Stock")) {
                    int svar2 = JOptionPane.showConfirmDialog(GraphicalUI.this, sf,
                            "New stock",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (svar2 != JOptionPane.OK_OPTION)
                        return;
                    String name = sf.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(GraphicalUI.this, "Inget namn!");
                        return;
                    }
                    int numberOfShares = sf.getNumberOfShares();
                    int sharePrice = sf.getSharePrice();

                    Stock s = new Stock(name, numberOfShares, sharePrice);
                    valuableList.add(s);
//                    System.out.print(valuableList);

                }
                if (boxen.getSelectedItem().equals("Apparatus")) {
                    int svar3 = JOptionPane.showConfirmDialog(GraphicalUI.this, af,
                            "New apparatus",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (svar3 != JOptionPane.OK_OPTION)
                        return;
                    String name = af.getName();
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(GraphicalUI.this, "Inget namn!");
                        return;
                    }
                    int retailPrice = af.getRetailPrice();
                    int wearNumber = af.getWearNumber();

                    Apparatus a = new Apparatus(name, retailPrice, wearNumber);
                    valuableList.add(a);
//                    System.out.print(valuableList);


                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(GraphicalUI.this, "Fel inmatning!");
            }
        }
    }


    class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            JButton showButton = (JButton) ave.getSource();


            field.setText(valuableList.showValuableArrayList());
//         field.append(valuableList.showValuableArrayList());
        }
    }


    public static void main(String[] args) {
        GraphicalUI window = new GraphicalUI();
    }

    class StockListener implements ActionListener {
        public void actionPerformed(ActionEvent ave) {
            JButton stockButton = (JButton) ave.getSource();
            stock.setStockCrash(0);
        }
    }
}