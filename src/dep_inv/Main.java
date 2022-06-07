package dep_inv;

public class Main {
    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();
        Switch powerSwitch = new PowerSwitch(lightBulb);

        for (int i = 0; i < 10; i++) {
            powerSwitch.press();
            System.out.println("is on? " + powerSwitch.isOn());
            powerSwitch.press();
            System.out.println("is on? " + powerSwitch.isOn());
        }
    }
}
