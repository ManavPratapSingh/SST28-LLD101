public class AirConditioner implements IPowerable, ITemperatureControl {
    public void powerOn() { /* ok */ }
    public void powerOff() { System.out.println("AC OFF"); }

    public void setTemperatureC(int c) { System.out.println("AC set to " + c + "C"); }
}
