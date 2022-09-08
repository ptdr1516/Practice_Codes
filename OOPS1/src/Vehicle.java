public abstract class Vehicle {
    private String color;
    int maxSpeed;

    public String getColor(){

        return color;
    }
    public void setColor(String color){

        this.color = color;
    }

    public void print(){

        System.out.println("Vehicle "+"color " + color + " maxSpeed " + maxSpeed);
    }
    public abstract boolean isMotorized();
    public abstract String getCompany();

}
