package Adapter.AssignmentExample.adapter;


import Adapter.AssignmentExample.adapter.interfaces.WeaponAdapter;
import Adapter.AssignmentExample.domain.AttackResult;
import Adapter.AssignmentExample.domain.AttackRequest;
import Adapter.AssignmentExample.domain.MagicType;
import Adapter.AssignmentExample.legacy.ModernFirearm;

public class FirearmToMagicStaffAdapter implements WeaponAdapter {
    private final ModernFirearm firearm;
    private int magicalCharge;
    public FirearmToMagicStaffAdapter(ModernFirearm firearm) {
        this.firearm = firearm;
        this.magicalCharge = firearm.getAmmunitionCount() * 10;
    }

    @Override
    public AttackResult castSpell(AttackRequest request) {
        if (!canPerformAttack(request.getManaCost())) {
            return AttackResult.failure("Insufficient magical charge in " + getMagicWeaponName());
        }

        if (request.requiresConcentration() && firearm.isSafetyOn()) {
            return AttackResult.failure("Weapon safety prevents concentration-based spells");
        }
        int rangeInMeters = request.getRange() * 10;
        boolean silentMode = !request.requiresConcentration();
        String targetType = convertMagicTypeToTarget(request.getMagicType());

        firearm.toggleSafety(); // Disable safety for attack
        ModernFirearm.FirearmResult result = firearm.dischargeProjectile(rangeInMeters, targetType, silentMode);
        firearm.toggleSafety(); // Re-enable safety

        magicalCharge -= request.getManaCost();

        if (result.hit) {
            boolean critical = request.getMagicType() == MagicType.LIGHTNING && Math.random() > 0.7;
            String magicalEffect = convertGunfireToMagicEffect(result.report, request.getMagicType());
            return AttackResult.success(result.damage, magicalEffect, critical);
        } else {
            return AttackResult.failure("Spell fizzled: " + result.report);
        }
    }

    private String convertMagicTypeToTarget(MagicType magicType) {
        switch (magicType) {
            case FIRE: return "fire elemental";
            case ICE: return "ice creature";
            case LIGHTNING: return "lightning spirit";
            case ARCANE: return "arcane construct";
            case NECROMANCY: return "undead being";
            case HOLY: return "dark creature";
            default: return "target";
        }
    }

    private String convertGunfireToMagicEffect(String gunReport, MagicType magicType) {
        return gunReport.replace("BANG!", getMagicSound(magicType))
                .replace("*pew*", getQuietMagicSound(magicType))
                .replace("Hit", "Magically struck")
                .replace(firearm.getModel(), getMagicWeaponName());
    }

    private String getMagicSound(MagicType magicType) {
        switch (magicType) {
            case FIRE: return "WHOOSH!";
            case ICE: return "CRACKLE!";
            case LIGHTNING: return "CRACK!";
            case ARCANE: return "HUM!";
            case NECROMANCY: return "Wail!";
            case HOLY: return "Chime!";
            default: return "ZAP!";
        }
    }

    private String getQuietMagicSound(MagicType magicType) {
        switch (magicType) {
            case FIRE: return "*fwoosh*";
            case ICE: return "*tinkle*";
            case LIGHTNING: return "*buzz*";
            default: return "*zap*";
        }
    }

    @Override
    public String getMagicWeaponName() {
        return "Staff of " + firearm.getModel().replace(" ", "") + " (Ancient Artifact)";
    }

    @Override
    public String getMagicType() {
        return "Arcane Projection";
    }

    @Override
    public boolean canPerformAttack(int requiredMana) {
        return magicalCharge >= requiredMana;
    }

    @Override
    public String getWeaponStatus() {
        return String.format("%s - %d/%d magical charge",
                getMagicWeaponName(), magicalCharge, firearm.getAmmunitionCount() * 10);
    }

}