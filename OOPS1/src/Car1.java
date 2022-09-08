public class Car1 extends Vehicle1 implements VehicleInterface, CarInterface{

    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public int numGears() {
        return 5;
    }
}
