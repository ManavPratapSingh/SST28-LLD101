public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        IProjectable pj = reg.getProjectors().get(0);
        pj.powerOn();
        pj.connectInput("HDMI-1");

        ILightable lights = reg.getLights().get(0);
        lights.setBrightness(60);

        ITemperatureControl ac = reg.getAirConditioners().get(0);
        ac.setTemperatureC(24);

        IScannable scan = reg.getScanners().get(0);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getProjectors().get(0).powerOff();
        reg.getLights().get(0).setBrightness(0);
        reg.getAirConditioners().get(0).setTemperatureC(30);
    }
}
