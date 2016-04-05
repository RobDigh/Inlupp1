package graphicalUI;

import valuables.Jewellery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert on 2016-03-31.
 */
public  class NewApparatusForm extends JPanel{

    private JTextField nameField = new JTextField(10);
    private JTextField retailPrice = new JTextField(10);
    private JTextField wearNumber = new JTextField(10);

    public NewApparatusForm(){
        JPanel rad1 = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        rad1.add(new JLabel("Name:"));
        rad1.add(nameField);
        add(rad1);
        JPanel rad2 = new JPanel();
        rad2.add(new JLabel("Retail price:"));
        rad2.add(retailPrice);
        add(rad2);
        JPanel rad3 = new JPanel();
        rad3.add(new JLabel("Wear number:"));
        rad3.add(wearNumber);
        add(rad3);
    }
    public String getName(){
        return nameField.getText();
    }
    public int getRetailPrice(){
        return Integer.parseInt(retailPrice.getText());
    }
    public int getWearNumber(){
        return Integer.parseInt(wearNumber.getText());
    }
}