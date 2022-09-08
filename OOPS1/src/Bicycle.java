public abstract class Bicycle extends Vehicle{
    String color;
    int maxSpeed;

    @Override
    public boolean isMotorized() {
        return false;
    }
}
