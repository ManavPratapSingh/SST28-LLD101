public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Classroom ===");
        DeviceRegistry reg = new DeviceRegistry();
        reg.addDevice(new Projector());
        reg.addDevice(new LightsPanel());
        reg.addDevice(new AirConditioner());
        reg.addDevice(new AttendanceScanner());

        ClassroomController c = new ClassroomController(reg);
        c.startClass();
        c.endClass();
    }
}
