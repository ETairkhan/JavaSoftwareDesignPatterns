package Adapter.AssignmentExample.adapter;

import Adapter.AssignmentExample.adapter.interfaces.WeaponAdapter;
import Adapter.AssignmentExample.legacy.LaserWeapon;
import Adapter.AssignmentExample.domain.AttackResult;
import Adapter.AssignmentExample.domain.AttackRequest;
import Adapter.AssignmentExample.domain.MagicType;

public class LaserGunToWandAdapter implements WeaponAdapter {
    private final LaserWeapon laserGun;
    private int arcaneEnergy;

    public LaserGunToWandAdapter(LaserWeapon laserGun) {
        this.laserGun = laserGun;
        this.arcaneEnergy = laserGun.getBatteryLevel();
    }

    @Override
    public AttackResult castSpell(AttackRequest request) {
        if (!canPerformAttack(request.getManaCost())) {
            return AttackResult.failure("Wand lacks sufficient arcane energy");
        }

        int wavelength = convertMagicTypeToWavelength(request.getMagicType());
        int duration = request.getManaCost() * 10;
        boolean overload = request.requiresConcentration();

        LaserWeapon.EnergyWeaponOutput result = laserGun.emitEnergyBeam(wavelength, duration, overload);
        arcaneEnergy = laserGun.getBatteryLevel();

        if (result.successful) {
            boolean critical = laserGun.isCoolingSystemActive() && Math.random() > 0.6;
            String magicalEffect = convertLaserToMagicEffect(result.diagnostic, request.getMagicType());
            return AttackResult.success(result.energyOutput, magicalEffect, critical);
        } else {
            return AttackResult.failure("Wand malfunction: " + result.diagnostic);
        }
    }

    private int convertMagicTypeToWavelength(MagicType magicType) {
        switch (magicType) {
            case FIRE: return 650;
            case ICE: return 475;
            case LIGHTNING: return 550;
            case ARCANE: return 400;
            case NECROMANCY: return 700;
            case HOLY: return 600;
            default: return 500;
        }
    }

    private String convertLaserToMagicEffect(String laserDiagnostic, MagicType magicType) {
        return laserDiagnostic.replace("beam", "ray")
                .replace("OVERLOAD BLAST", "EMPOWERED " + magicType + " BLAST")
                .replace("Precision beam", "Focused " + magicType + " beam")
                .replace(laserGun.getBatteryLevel() + "% battery", arcaneEnergy + " arcane energy");
    }

    @Override
    public String getMagicWeaponName() {
        return "Wand of Prismatic Light (Ancient Artifact)";
    }

    @Override
    public String getMagicType() {
        return "Focused Arcana";
    }

    @Override
    public boolean canPerformAttack(int requiredMana) {
        return arcaneEnergy >= requiredMana;
    }

    @Override
    public String getWeaponStatus() {
        String status = getMagicWeaponName() + " - " + arcaneEnergy + "% energy";
        if (laserGun.isCoolingSystemActive()) {
            status += " [Cooling...]";
        }
        return status;
    }
}