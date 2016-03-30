package valuables;

public class Stock extends Valuable {

  private int numberOfShares;

  private double sharePrice;


  public Stock(String name, int numberOfShares, double sharePrice){
    super(name);
    this.numberOfShares = numberOfShares;
    this.sharePrice = sharePrice;
  }


  public double calculateValue() {
  return numberOfShares * sharePrice;
  }

  public double setSharePrice(double newSharePrice) {
    sharePrice = newSharePrice;
    return sharePrice;
  }

  public String property(){
    return ("Number of shares: " + numberOfShares + " Share price:  " + sharePrice);
  }
}