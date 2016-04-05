package valuableList;

import valuables.Valuable;
import textUI.TextUI;
import java.util.ArrayList;

public class ValuableList {

  private ArrayList<Valuable> valuableArrayList = new ArrayList<>();

  public ArrayList getValuableArrayList(){
    return valuableArrayList;
  }

  public void add (Valuable v){

    valuableArrayList.add(v);
    System.out.println(valuableArrayList);
  }

    public TextUI textUI;
//    public GraphicalUI graphicalUI;

}