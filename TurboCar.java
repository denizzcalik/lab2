public class TurboCar {
    public boolean turboOn;
    public double turboval;

    public TurboCar() {
        this.turboOn = false;
    }

    public void setTurboOn() {
        this.turboOn = true;
    }

    public void setTurboOff() {
        this.turboOn = false;
    }

    public double getTurbo(){
        if (turboOn)
            this.turboval = 1.3;
        else
            this.turboval = 1;

        return this.turboval;
    }
}
