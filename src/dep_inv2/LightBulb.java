package dep_inv2;

public class LightBulb implements Switchable{
    @Override
    public void turnOn() {
        System.out.println("Light: .... turning ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light: .... turning OFF");
    }
}
