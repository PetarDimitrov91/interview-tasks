package dep_inv;

public class PowerSwitch implements Switch {
    private final Switchable client;
    private boolean on;

    public PowerSwitch(Switchable client) {
        this.client = client;
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void press() {
        if (this.isOn()) {
            this.client.turnOff();
            this.on = false;
        } else {
            this.client.turnOn();
            this.on = true;
        }
    }
}
