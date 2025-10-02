package Adapter.Assignment.Game;

import Adapter.Assignment.Adapter.MagicStickAdapter;
import Adapter.Assignment.Adapter.ModernFirearmAdapter;
import Adapter.Assignment.Legacy.MagicStick;
import Adapter.Assignment.Legacy.ModernFirearm;

public class Game {

    public void play() {
        System.out.println("=== Демонстрация двустороннего адаптера ===\n");
        MagicStick fireWand = new MagicStick(100, "Огненный жезл", true);
        MagicStick iceStaff = new MagicStick(50, "Ледяной посох", false);

        ModernFirearm sniperRifle = new ModernFirearm(20, "Снайперская винтовка", true, false);
        ModernFirearm shotgun = new ModernFirearm(8, "Дробовик", false, false);
        ModernFirearm pistol = new ModernFirearm(12, "Пистолет", false, true);

        System.out.println("=== МАГИЧЕСКИЕ ПОСОХИ КАК ОГНЕСТРЕЛЬНОЕ ОРУЖИЕ ===");
        testMagicToFirearm(fireWand, "Огненный жезл");
        testMagicToFirearm(iceStaff, "Ледяной посох");

        System.out.println("\n=== ОГНЕСТРЕЛЬНОЕ ОРУЖИЕ КАК МАГИЧЕСКИЕ ПОСОХИ ===");
        testFirearmToMagic(sniperRifle, "Снайперская винтовка");
        testFirearmToMagic(shotgun, "Дробовик");
        testFirearmToMagic(pistol, "Пистолет");

        System.out.println("\n=== ДВУСТОРОННЯЯ СОВМЕСТИМОСТЬ ===");
        demonstrateBidirectionalCompatibility();
    }

    private void testMagicToFirearm(MagicStick magicStick, String name) {
        System.out.println("\n--- " + name + " как огнестрельное оружие ---");
        MagicStickAdapter adapter = new MagicStickAdapter(magicStick);
        adapter.displayAdaptation();

        System.out.println("Последовательность выстрелов:");
        for (int i = 0; i < 2; i++) {
            ModernFirearm.FirearmResult result = adapter.fire();
            System.out.printf("  Выстрел %d: %s - Урон: %d%n",
                    i + 1,
                    result.hit ? "ПОПАДАНИЕ!" : "ПРОМАХ",
                    result.damage);
        }
    }

    private void testFirearmToMagic(ModernFirearm firearm, String name) {
        System.out.println("\n--- " + name + " как магический посох ---");
        ModernFirearmAdapter adapter = new ModernFirearmAdapter(firearm);
        adapter.displayAdaptation();

        System.out.println("Произнесение заклинаний:");
        for (int i = 0; i < 2; i++) {
            MagicStick.MagicStickResult result = adapter.castSpell();
            System.out.printf("  Заклинание %d: %s - Урон: %d%n",
                    i + 1,
                    result.hit ? "ПОПАДАНИЕ!" : "ПРОМАХ",
                    result.damage);
        }
    }

    private void demonstrateBidirectionalCompatibility() {
        System.out.println("Создание магического огнестрельного оружия и вооруженного магического посоха:");

        ModernFirearm rifle = new ModernFirearm(15, "Штурмовая винтовка", true, false);
        ModernFirearmAdapter magicalRifle = new ModernFirearmAdapter(rifle);

        MagicStick wand = new MagicStick(80, "Посох молний", true);
        MagicStickAdapter firearmWand = new MagicStickAdapter(wand);

        System.out.println("\nСвойства магической винтовки:");
        System.out.println("  Имя: " + magicalRifle.getName());
        System.out.println("  Мана: " + magicalRifle.getMana());
        System.out.println("  Концентрация: " + magicalRifle.isConcentration());

        System.out.println("\nСвойства огнестрельного посоха:");
        System.out.println("  Модель: " + firearmWand.getModel());
        System.out.println("  Патроны: " + firearmWand.getAmmunition());
        System.out.println("  Прицел: " + firearmWand.getScope());

        System.out.println("\nМежсистемное использование:");
        System.out.println("Магическая винтовка может использоваться в кругах заклинателей");
        System.out.println("Огнестрельный посох может использоваться в военных арсеналах");
    }
}