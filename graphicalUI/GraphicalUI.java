package graphicalUI;

import java.awt.event.*;
import java.util.*;
import valuableList.ValuableList;
import valuables.Jewellery;
import valuables.Stock;
import valuables.Apparatus;
import valuables.Valuable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class GraphicalUI extends JFrame {

    private ValuableList valuableList;
    private JTextArea field;


    public GraphicalUI(){
        super("Register");

        valuableList = new ValuableList();

        setLayout(new BorderLayout());
//        JPanel north = new JPanel();
        JLabel labelValuables = new JLabel("Valuables", SwingConstants.CENTER);
        add(labelValuables, BorderLayout.NORTH);

        JTextArea field = new JTextArea();
        add(field, BorderLayout.CENTER);
//        field.setEditable(false);
        JScrollPane scroll = new JScrollPane(field);
        add(scroll);
//        kolla storleken på fältet, lägg in scrollfunktion

        JPanel east = new JPanel();
        east.setLayout(new BorderLayout());
        JLabel labelSort = new JLabel();
//        int height = getHeight()/2;
        JPanel eastside = new JPanel();
        east.add(eastside, BorderLayout.SOUTH);
        eastside.setLayout(new BoxLayout(eastside, BoxLayout.Y_AXIS));
//        east.add(Box.createRigidArea(new Dimension(0, 325)));
        eastside.add(new JLabel("Sort by"));
        JRadioButton name = new JRadioButton("Name");
        eastside.add(name);
        JRadioButton value = new JRadioButton("Value");
        eastside.add(value);
//        east.add(new JRadioButton("Name"));
//        east.add(new JRadioButton("Value"));
        ButtonGroup bg = new ButtonGroup();
        bg.add(name);
        bg.add(value);

//        gruppera radiobuttons
//        eastside.setLayout();
//        east.setLayout(new GridLayout(3,1));
        add(east, BorderLayout.EAST);



        JPanel south = new JPanel();
        String[] choice = {"", "Jewellery", "Stock", "Apparatus"};
        JComboBox<String> comboChoice = new JComboBox<String>(choice);
        south.add(new JLabel("New:"));
        south.add(comboChoice);
        comboChoice.addActionListener(new NyLyss());
        south.add(new JButton("Show"));
        south.add(new JButton("Stock market crash"));
        add(south, BorderLayout.SOUTH);

        setVisible(true);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class NyLyss implements ActionListener {
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
                    System.out.print(valuableList);

                } if (boxen.getSelectedItem().equals("Stock")) {
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
                    System.out.print(valuableList);

                } if (boxen.getSelectedItem().equals("Apparatus")) {
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
                    System.out.print(valuableList);


                }

                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(GraphicalUI.this, "Fel inmatning!");
                    }
                }
            }


//    class VisaLyss implements ActionListener{
//        public void actionPerformed(ActionEvent ave){
//            field.setText("");
//            if (allaKnapp.isSelected())
//                for(Jewellery jw : add)
//                    field.append(jw.toString() + "\n");
//            else
//                for(Jewellery jw : valuableArrayList)
//                    if (jw.isGold)
//                        display.append(jw.toString() + "\n");
//
//        }
//    }


    public static void main(String[] args){
        GraphicalUI window = new GraphicalUI();
    }

}