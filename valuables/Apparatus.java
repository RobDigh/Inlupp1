package valuables;

public class Apparatus extends Valuable {

  private int retailPrice;

  private int wearNumber;



  public Apparatus(int retailPrice, int wearNumber, String name) {
    super (name);
      this.retailPrice = retailPrice;
      this.wearNumber = wearNumber;
  }

    public int getRetailPrice(){
        return retailPrice;
    }

    public int getWearNumber(){
        return wearNumber;
    }

  public double calculateValue() {
      return retailPrice * wearNumber / 10;
  }

  public String property() {
    return ("Wear: " + wearNumber);
  }

}