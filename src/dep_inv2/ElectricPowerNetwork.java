package dep_inv2;

public class ElectricPowerNetwork implements Switch {
    private Switchable client;
    private boolean isOn;

    public ElectricPowerNetwork(Switchable client) {
        this.setClient(client);
        this.isOn = false;
    }

    public Switchable getClient() {
        return client;
    }

    public void setClient(Switchable client) {
        this.client = client;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void press() {
        if (this.isOn) {
            this.client.turnOff();
            this.isOn = false;
        } else {
            this.client.turnOn();
            this.isOn = true;
        }
    }
}
