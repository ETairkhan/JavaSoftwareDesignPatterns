package Adapter.Assignment.Legacy;

public class MagicStick {

    private final int mana;
    private final String name;
    private final boolean concentration;

    public MagicStick(int mana, String name, boolean concentration){
        this.mana = mana;
        this.name = name;
        this.concentration = concentration;
    }

    public int getMana() {return mana;}
    public String getName() {return name;}
    public boolean isConcentration() {return concentration;}


    public MagicStickResult castSpell() {
        if (mana <= 0) {
            return new MagicStickResult(false, 0);
        }

        // Magic has better accuracy but consumes mana
        boolean hit = Math.random() > 0.2; // 80% hit chance for magic
        int damage = hit ? 30 + (int)(Math.random() * 15) : 0;

        return new MagicStickResult(hit, damage);
    }

    public static class MagicStickResult{
        public final boolean hit;
        public final int damage;

        public MagicStickResult(boolean hit, int damage){
            this.hit = hit;
            this.damage = damage;
        }
    }



}
