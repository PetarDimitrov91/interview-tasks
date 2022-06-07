package dep_inv;

public class LightBulb implements Switchable{
    @Override
    public void turnOn() {
        System.out.println("Light: Light turned on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Light: Light turned off...");
    }
}
