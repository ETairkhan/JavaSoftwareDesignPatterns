package Adapter.Assignment.Adapter;
import Adapter.Assignment.Legacy.MagicStick;
import Adapter.Assignment.Legacy.ModernFirearm;

public class MagicStickAdapter extends ModernFirearm{
    private final MagicStick magicStick;

    public MagicStickAdapter(MagicStick magicStick){
        super(0, null ,false ,false );
        this.magicStick = magicStick;
    }

    @Override
    public int getAmmunition(){
        return magicStick.getMana() / 10;
    }

    @Override
    public String getModel() {
        String name = magicStick.getName().toLowerCase();

        if (name.contains("огн")) {
            return "Плазмомет";
        } else if (name.contains("лед") || name.contains("холод")) {
            return "Криогенная винтовка";
        } else if (name.contains("молн")) {
            return "Электро-лучевое ружье";
        } else if (name.contains("свет")) {
            return "Лазерный излучатель";
        } else if (name.contains("тьм")) {
            return "Гравитационная пушка";
        } else {
            return "Пси-волновая винтовка";
        }
    }

    @Override
    public boolean getScope(){
        return magicStick.isConcentration();
    }

    @Override
    public boolean isSafetyOn(){
        return magicStick.getMana() <= 0;
    }

    public FirearmResult fire() {
        if (isSafetyOn()) {
            System.out.println("  Предохранитель включен - невозможно выстрелить");
            return new FirearmResult(false, 0);
        }

        boolean hit = Math.random() > 0.3;
        int baseDamage = magicStick.getMana() / 5;
        int damage = hit ? baseDamage + (int)(Math.random() * 10) : 0;

        System.out.printf("  Магический заряд выпущен: %s%n", hit ? "ПОПАЛ" : "НЕ ПОПАЛ");
        return new FirearmResult(hit, damage);
    }

    public void displayAdaptation() {
        System.out.println("Магический посох: " + magicStick.getName());
        System.out.println("Адаптировано в огнестрельное оружие: " + getModel());
        System.out.println("Мана: " + magicStick.getMana() + " → Патроны: " + getAmmunition());
        System.out.println("Концентрация: " + magicStick.isConcentration() + " → Прицел: " + getScope());
        System.out.println("Готов к стрельбе: " + !isSafetyOn());
    }
}
