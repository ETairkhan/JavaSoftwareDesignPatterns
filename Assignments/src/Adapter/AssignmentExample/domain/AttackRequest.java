package Adapter.AssignmentExample.domain;

public class AttackRequest {
    private final int manaCost;
    private final int range;
    private final MagicType magicType;
    private final String target;
    private final boolean requiresConcentration;

    public AttackRequest(int manaCost, int range, MagicType magicType, String target, boolean requiresConcentration){
        this.manaCost = manaCost;
        this.range = range;
        this.magicType = magicType;
        this.target = target;
        this.requiresConcentration = requiresConcentration;
    }

    public int getManaCost() { return manaCost; }
    public int getRange() { return range; }
    public MagicType getMagicType() { return magicType; }
    public boolean requiresConcentration() { return requiresConcentration; }

    @Override
    public String toString() {
        return String.format("Attack on %s with %s magic (%d mana, range: %d)%s",
                target, magicType, manaCost, range,
                requiresConcentration ? " [concentration required]" : "");
    }
}
