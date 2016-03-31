package graphicalUI;

import valuableList.ValuableList;
import javax.swing.*;
import java.awt.*;

public class GraphicalUI extends JFrame {

    private ValuableList myValuableList;

    public GraphicalUI(){
        super("Register");
        setLayout(new BorderLayout());
//        JPanel north = new JPanel();
        JLabel labelValuables = new JLabel("Valuables", SwingConstants.CENTER);
        add(labelValuables, BorderLayout.NORTH);

        JTextField field = new JTextField(10);
        add(field, BorderLayout.CENTER);
//        field.setEditable(false);
        JScrollPane scroll = new JScrollPane(field);
        add(scroll);

//        kolla storleken på fältet, lägg in scrollfunktion

        JPanel east = new JPanel();
        JLabel labelSort = new JLabel();
//        int height = getHeight()/2;
        east.add(Box.createRigidArea(new Dimension(0, 325)));
        east.add(new JLabel("Sort by"));
        JRadioButton name = new JRadioButton("Name");
        east.add(name);
        JRadioButton value = new JRadioButton("Value");
        east.add(value);
//        east.add(new JRadioButton("Name"));
//        east.add(new JRadioButton("Value"));
        ButtonGroup bg = new ButtonGroup();
        bg.add(name);
        bg.add(value);

//        gruppera radiobuttons
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
//        east.setLayout(new GridLayout(3,1));
        add(east, BorderLayout.EAST);



        JPanel south = new JPanel();
        String[] choice = {"", "Jewellry", "Stock", "Apparatus"};
        JComboBox<String> comboChoice = new JComboBox<String>(choice);
        south.add(new JLabel("New:"));
        south.add(comboChoice);
        south.add(new JButton("Show"));
        south.add(new JButton("Stock market crash"));
        add(south, BorderLayout.SOUTH);

        setVisible(true);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        GraphicalUI window = new GraphicalUI();
    }

}