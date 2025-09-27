package Adapter.AssignmentExample.legacy;

public class LaserWeapon {
    private int batteryLevel;
    private final String serialNumber;
    private boolean coolingSystemActive;

    public LaserWeapon(String serialNumber) {
        this.serialNumber = serialNumber;
        this.batteryLevel = 100;
        this.coolingSystemActive = false;
    }

    public EnergyWeaponOutput emitEnergyBeam(int wavelength, int durationMs, boolean overloadMode) {
        if (batteryLevel < 10) {
            return new EnergyWeaponOutput(false, 0, "Insufficient battery: " + batteryLevel + "%");
        }

        if (overloadMode && batteryLevel < 30) {
            return new EnergyWeaponOutput(false, 0, "Battery too low for overload mode");
        }

        int energyCost = overloadMode ? 25 : 10;
        batteryLevel = Math.max(0, batteryLevel - energyCost);

        coolingSystemActive = overloadMode;

        int baseEnergy = overloadMode ? 75 : 40;
        int damage = baseEnergy + (wavelength / 100);

        String effect = overloadMode ? "OVERLOAD BLAST" : "Precision beam";
        return new EnergyWeaponOutput(true, damage,
                String.format("[%s] %dnm beam for %dms - %s", serialNumber, wavelength, durationMs, effect));
    }

    public int getBatteryLevel() { return batteryLevel; }
    public boolean isCoolingSystemActive() { return coolingSystemActive; }

    public static class EnergyWeaponOutput {
        public final boolean successful;
        public final int energyOutput;
        public final String diagnostic;

        public EnergyWeaponOutput(boolean successful, int energyOutput, String diagnostic) {
            this.successful = successful;
            this.energyOutput = energyOutput;
            this.diagnostic = diagnostic;
        }
    }
}