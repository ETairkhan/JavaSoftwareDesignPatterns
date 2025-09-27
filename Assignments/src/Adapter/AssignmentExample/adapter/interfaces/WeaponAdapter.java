package Adapter.AssignmentExample.adapter.interfaces;

import Adapter.AssignmentExample.domain.AttackResult;
import Adapter.AssignmentExample.domain.AttackRequest;

public interface WeaponAdapter {
    AttackResult castSpell(AttackRequest request);
    String getMagicWeaponName();
    String getMagicType();
    boolean canPerformAttack(int requiredMana);
    default String getWeaponStatus() {
        return getMagicWeaponName() + " - " + getMagicType() + " affinity";
    }
}