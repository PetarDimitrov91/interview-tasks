package dep_inv2;

public class Main {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        Switch e = new ElectricPowerNetwork(bulb);

        for (int i = 0; i <10 ; i++) {
            e.press();
        }
    }
}
