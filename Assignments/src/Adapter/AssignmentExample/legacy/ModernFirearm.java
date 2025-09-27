package Adapter.AssignmentExample.legacy;

public class ModernFirearm {
    private int ammunition;
    private final String model;
    private boolean safetyOn;

    public ModernFirearm(String model, int initialAmmo) {
        this.model = model;
        this.ammunition = initialAmmo;
        this.safetyOn = true;
    }

    public FirearmResult dischargeProjectile(int targetDistance, String targetType, boolean useSuppressor) {
        if (safetyOn) {
            return new FirearmResult(false, 0, "Safety is engaged");
        }

        if (ammunition <= 0) {
            return new FirearmResult(false, 0, "Out of ammunition");
        }

        if (targetDistance > 1000) { // meters
            return new FirearmResult(false, 0, "Target out of effective range");
        }

        ammunition--;

        // Simulate ballistic calculation
        int baseDamage = 40;
        double distanceModifier = Math.max(0.1, 1.0 - (targetDistance / 1000.0));
        int actualDamage = (int) (baseDamage * distanceModifier);

        String sound = useSuppressor ? "*pew*" : "BANG!";
        return new FirearmResult(true, actualDamage,
                String.format("%s Hit %s at %dm with %s", sound, targetType, targetDistance, model));
    }

    public void toggleSafety() {
        safetyOn = !safetyOn;
    }

    public void reload(int rounds) {
        ammunition += rounds;
        System.out.println("Reloaded " + rounds + " rounds. Total: " + ammunition);
    }

    public int getAmmunitionCount() { return ammunition; }
    public String getModel() { return model; }
    public boolean isSafetyOn() { return safetyOn; }

    public static class FirearmResult {
        public final boolean hit;
        public final int damage;
        public final String report;

        public FirearmResult(boolean hit, int damage, String report) {
            this.hit = hit;
            this.damage = damage;
            this.report = report;
        }
    }
}