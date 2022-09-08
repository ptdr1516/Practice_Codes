public abstract class Car extends Vehicle{
    int numDoors;

    public void printCar(){
        System.out.println("Car "+" color " + getColor() + " maxSpeed " + maxSpeed + " numDoors " + numDoors);
    }
    public boolean isMotarized(){
        return true;
    }

    @Override
    public boolean isMotorized() {
        return true;
    }
}
