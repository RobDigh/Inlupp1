package graphicalUI;

import valuables.Jewellery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert on 2016-03-31.
 */
public  class NewJewelleryForm extends JPanel{

    private JTextField nameField = new JTextField(10);
    private JTextField numberOfStonesField = new JTextField(5);
    private JCheckBox isGoldBox = new JCheckBox("Is gold?");

    public NewJewelleryForm(){
        JPanel rad1 = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        rad1.add(new JLabel("Name:"));
        rad1.add(nameField);
        add(rad1);
        JPanel rad2 = new JPanel();
        rad2.add(new JLabel("Number of stones:"));
        rad2.add(numberOfStonesField);
        add(rad2);
        add(isGoldBox);
    }
    public String getName(){
        return nameField.getText();
    }
    public int getNumberOfStones(){
        return Integer.parseInt(numberOfStonesField.getText());
    }
    public boolean getIsGold(){
        return isGoldBox.isSelected();
    }
}





