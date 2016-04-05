package graphicalUI;

import valuables.Jewellery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert on 2016-03-31.
 */
public  class NewStockForm extends JPanel{

    private JTextField nameField = new JTextField(10);
    private JTextField numberOfShares = new JTextField(10);
    private JTextField sharePrice = new JTextField(10);


    public NewStockForm(){
        JPanel rad1 = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        rad1.add(new JLabel("Name:"));
        rad1.add(nameField);
        add(rad1);
        JPanel rad2 = new JPanel();
        rad2.add(new JLabel("Number of shares:"));
        rad2.add(numberOfShares);
        add(rad2);
        JPanel rad3 = new JPanel();
        rad3.add(new JLabel("Share price:"));
        rad3.add(sharePrice);
        add(rad3);
    }
    public String getName(){
        return nameField.getText();
    }
    public int getNumberOfShares(){
        return Integer.parseInt(numberOfShares.getText());
    }
    public int getSharePrice(){
        return Integer.parseInt(sharePrice.getText());
    }
}





