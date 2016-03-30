package valuables;

public abstract class Valuable {

  private String name;

    public Valuable(String name){
        this.name = name;
    }

    public String getName() {
    return name;
  }

  public abstract double calculateValue();

  public double calculateValueWithTax() {
    return calculateValue() * 1.25;
  }

  public abstract String property();


    public String toString(){
        return String.format("%s %s %s %s", getClass().getSimpleName() + ":", name, "Value: " + calculateValueWithTax(), property());
    }
}