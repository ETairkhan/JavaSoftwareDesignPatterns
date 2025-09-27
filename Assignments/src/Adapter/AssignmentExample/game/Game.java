package Adapter.AssignmentExample.game;

import Adapter.AssignmentExample.adapter.*;
import Adapter.AssignmentExample.domain.*;
import Adapter.AssignmentExample.adapter.interfaces.WeaponAdapter;
import Adapter.AssignmentExample.legacy.*;

public class Game {

    public void Start() {
        WeaponAdapter magicStaff = new FirearmToMagicStaffAdapter(
                new ModernFirearm("M4 Carbine", 30));
        WeaponAdapter magicWand = new LaserGunToWandAdapter(
                new LaserWeapon("X-Ray-9000"));

        displayInitialStatus(magicStaff, magicWand);
        demonstrateCombat(magicStaff, magicWand);
        stressTest(magicStaff, magicWand);
        displayFinalStatus(magicStaff, magicWand);

        System.out.println("\n=== The ancient artifacts have proven their worth in battle! ===");
    }
    private void displayInitialStatus(WeaponAdapter staff, WeaponAdapter wand) {
        System.out.println("=== INITIAL WEAPON STATUS ===");
        displayWeaponStatus("Magic Staff", staff);
        displayWeaponStatus("Magic Wand", wand);
        System.out.println("\n🎯 === BATTLE SEQUENCE === 🎯");
    }

    private void demonstrateCombat(WeaponAdapter staff, WeaponAdapter wand) {
        // Test Magic Staff
        System.out.println("\n--- Testing Magic Staff (Firearm Adapter) ---");
        demonstrateAttack("Magic Staff", staff, new AttackRequest(15, 8, MagicType.FIRE, "Dragon", false));
        demonstrateAttack("Magic Staff", staff, new AttackRequest(20, 12, MagicType.LIGHTNING, "Evil Wizard", true));

        // Test Magic Wand
        System.out.println("\n--- Testing Magic Wand (Laser Adapter) ---");
        demonstrateAttack("Magic Wand", wand, new AttackRequest(12, 15, MagicType.ICE, "Fire Elemental", false));
        demonstrateAttack("Magic Wand", wand, new AttackRequest(30, 10, MagicType.HOLY, "Undead Horde", true));
    }

    private void stressTest(WeaponAdapter staff, WeaponAdapter wand) {
        System.out.println("\n💀 === STRESS TEST === 💀");

        System.out.println("\n--- Rapid Fire Test (Magic Staff) ---");
        for (int i = 0; i < 5; i++) {
            demonstrateAttack("Magic Staff", staff,
                    new AttackRequest(10, 5, MagicType.ARCANE, "Goblin " + (i + 1), false));
        }

        System.out.println("\n--- Rapid Fire Test (Magic Wand) ---");
        for (int i = 0; i < 5; i++) {
            demonstrateAttack("Magic Wand", wand,
                    new AttackRequest(10, 5, MagicType.ARCANE, "Goblin " + (i + 1), false));
        }
    }

    private void displayFinalStatus(WeaponAdapter staff, WeaponAdapter wand) {
        System.out.println("\n=== FINAL WEAPON STATUS ===");
        displayWeaponStatus("Magic Staff", staff);
        displayWeaponStatus("Magic Wand", wand);
    }

    private void demonstrateAttack(String weaponName, WeaponAdapter weapon, AttackRequest request) {
        System.out.println("\n✨ " + weaponName + " casting: " + request);

        if (!weapon.canPerformAttack(request.getManaCost())) {
            System.out.println("❌ " + weaponName + " - Insufficient energy! Need " +
                    request.getManaCost() + " mana");
            return;
        }

        try {
            AttackResult result = weapon.castSpell(request);

            if (result.isSuccess()) {
                System.out.println("✅ " + weaponName + " - " + result);
                if (result.isCriticalHit()) {
                    System.out.println("💥 CRITICAL HIT! Double damage!");
                }
            } else {
                System.out.println("❌ " + weaponName + " - " + result);
            }
        } catch (Exception e) {
            System.out.println("💥 " + weaponName + " - Magical backlash! " + e.getMessage());
        }
    }

    private void displayWeaponStatus(String weaponName, WeaponAdapter weapon) {
        System.out.println(weaponName + ": " + weapon.getWeaponStatus());
    }
}