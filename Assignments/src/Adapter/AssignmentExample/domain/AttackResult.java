package Adapter.AssignmentExample.domain;

public class AttackResult {
    private final boolean success;
    private final int damageDealt;
    private final String effectDescription;
    private final boolean criticalHit;

    private AttackResult(boolean success, int damageDealt, String effectDescription, boolean criticalHit) {
        this.success = success;
        this.damageDealt = damageDealt;
        this.effectDescription = effectDescription;
        this.criticalHit = criticalHit;
    }

    public static AttackResult success(int damage, String effect, boolean critical) {
        return new AttackResult(true, damage, effect, critical);
    }

    public static AttackResult failure(String reason) {
        return new AttackResult(false, 0, reason, false);
    }

    public boolean isSuccess() { return success; }
    public boolean isCriticalHit() { return criticalHit; }

    public int getTotalDamage() {
        return criticalHit ? damageDealt * 2 : damageDealt;
    }

    @Override
    public String toString() {
        if (!success) {
            return String.format("Attack failed: %s", effectDescription);
        }
        return String.format("Hit for %d damage! %s%s",
                getTotalDamage(), effectDescription, criticalHit ? " [CRITICAL!]" : "");
    }
}