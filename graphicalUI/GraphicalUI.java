package graphicalUI;

import valuableList.ValuableList;
import javax.swing.*;
import java.awt.*;

public class GraphicalUI extends JFrame {

    private ValuableList myValuableList;

    public GraphicalUI(){
        setLayout(new FlowLayout());


        JLabel label = new JLabel("Awesome fält"); 
        add(label);

        JTextField field = new JTextField(10);
        add(field);
        setVisible(true);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        GraphicalUI window = new GraphicalUI();
    }

}