package valuableList;

import valuables.Valuable;
import textUI.TextUI;

import java.util.*;

public class ValuableList {

  private ArrayList<Valuable> valuableArrayList = new ArrayList<>();


  public ArrayList getValuableArrayList() {
    return valuableArrayList;
  }

  public void add(Valuable v) {

    valuableArrayList.add(v);
    System.out.println(valuableArrayList);
  }

  public String showValuableArrayList() {

    String str = "";
    for(int i = 0; i< valuableArrayList.size(); i++) {

      str += valuableArrayList.get(i)  + "\n";

    }

    return str;
  }
  public void sortValuables(){
    Collections.sort(valuableArrayList, new ValueCmp());
  }

  public void sortName(){
    Collections.sort(valuableArrayList, new NameCmp());
  }
}

class ValueCmp implements Comparator<Valuable>{
  @Override
  public int compare(Valuable v1, Valuable v2){
    if (v1.calculateValueWithTax() < v2.calculateValueWithTax()){
      return 1;
    }
    if(v1.calculateValueWithTax() > v2.calculateValueWithTax()) {
      return -1;
    }
    else { return 0;}
  }
}
class NameCmp implements Comparator<Valuable>{
  @Override
  public int compare(Valuable n1, Valuable n2) {
    if (n1.getName().charAt(0) < n2.getName().charAt(0)) {
      return -1;
    }
    if (n1.getName().charAt(0) > n2.getName().charAt(0)) {
      return 1;
    } else {
      return 0;
    }
  }
}

