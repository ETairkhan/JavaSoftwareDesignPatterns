package Adapter.Assignment.Adapter;

import Adapter.Assignment.Legacy.MagicStick;
import Adapter.Assignment.Legacy.ModernFirearm;

public class ModernFirearmAdapter extends MagicStick {
    private final ModernFirearm firearm;

    public ModernFirearmAdapter(ModernFirearm firearm) {
        super(0, null, false);
        this.firearm = firearm;
    }

    @Override
    public int getMana() {
        return firearm.getAmmunition() * 5;
    }


    @Override
    public String getName() {
        String model = firearm.getModel().toLowerCase();

        if (model.contains("снайпер") || model.contains("винтовк")) {
            return "Дальнобойный магический жезл";
        } else if (model.contains("пистолет") || model.contains("револьвер")) {
            return "Карманный жезл мгновенного заклинания";
        } else if (model.contains("дробовик") || model.contains("ружь")) {
            return "Посох рассеивающего заклинания";
        } else if (model.contains("штурмов") || model.contains("автомат")) {
            return "Жезл скоростного колдовства";
        } else if (model.contains("пулемет")) {
            return "Великий посох магического ливня";
        } else if (model.contains("ракет")) {
            return "Жезл великого разрушения";
        } else {
            return "Зачарованный жезл метательной магии";
        }
    }

    @Override
    public boolean isConcentration() {
        return firearm.getScope();
    }

    public MagicStickResult castSpell() {
        if (firearm.isSafetyOn()) {
            System.out.println("  Предохранитель включен - невозможно произнести заклинание");
            return new MagicStickResult(false, 0);
        }

        if (firearm.getAmmunition() <= 0) {
            System.out.println("  Закончились патроны - нет маны");
            return new MagicStickResult(false, 0);
        }

        boolean hit = Math.random() > 0.4;
        int baseDamage = 15;

        int damage = hit ? baseDamage + (int)(Math.random() * 15) : 0;
        System.out.printf("  Заклинание произнесено: %s%n", hit ? "ПОПАЛО" : "НЕ ПОПАЛО");
        return new MagicStickResult(hit, damage);
    }


    public void displayAdaptation() {
        System.out.println("Огнестрельное оружие: " + firearm.getModel());
        System.out.println("Адаптировано в магический посох: " + getName());
        System.out.println("Патроны: " + firearm.getAmmunition() + " → Мана: " + getMana());
        System.out.println("Прицел: " + firearm.getScope() + " → Концентрация: " + isConcentration());
        System.out.println("Готов к заклинаниям: " + (getMana() > 0 && !firearm.isSafetyOn()));
    }

}