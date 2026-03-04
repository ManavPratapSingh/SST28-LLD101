import java.util.*;

public class DeviceRegistry {
    private final List<IPowerable> powerableDevices = new ArrayList<>();
    private final List<IScannable> scanners = new ArrayList<>();
    private final List<ILightable> lights = new ArrayList<>();
    private final List<ITemperatureControl> airConditioners = new ArrayList<>();
    private final List<IProjectable> projectors = new ArrayList<>();

    public void addDevice(Object device) {
        if (device instanceof IPowerable) powerableDevices.add((IPowerable) device);
        if (device instanceof IScannable) scanners.add((IScannable) device);
        if (device instanceof ILightable) lights.add((ILightable) device);
        if (device instanceof ITemperatureControl) airConditioners.add((ITemperatureControl) device);
        if (device instanceof IProjectable) projectors.add((IProjectable) device);
    }

    public List<IPowerable> getPowerableDevices() { return powerableDevices; }
    public List<IScannable> getScanners() { return scanners; }
    public List<ILightable> getLights() { return lights; }
    public List<ITemperatureControl> getAirConditioners() { return airConditioners; }
    public List<IProjectable> getProjectors() { return projectors; }
}