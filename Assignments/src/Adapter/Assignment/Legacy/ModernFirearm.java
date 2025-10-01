package Adapter.Assignment.Legacy;

public class ModernFirearm {
    private int ammunition;
    private final String model;
    private final boolean scope;
    private final boolean safetyOn;

    public ModernFirearm(int ammunition, String model, boolean scope, boolean safetyOn){
        this.ammunition =  ammunition;
        this.model = model;
        this.scope = scope;
        this.safetyOn = safetyOn;
    }

    public int getAmmunition(){return ammunition;}
    public String getModel(){return model;}
    public boolean getScope(){return scope;}
    public boolean isSafetyOn(){return safetyOn;}

    public FirearmResult fire() {
        if (safetyOn || ammunition <= 0) {
            return new FirearmResult(false, 0);
        }

        ammunition--;
        boolean hit = Math.random() > 0.5; // 50% hit chance for real firearms
        int damage = hit ? 25 + (int)(Math.random() * 20) : 0;

        return new FirearmResult(hit, damage);
    }

    public static class FirearmResult{
        public final boolean hit;
        public final int damage;

        public FirearmResult(boolean hit, int damage){
            this.hit = hit;
            this.damage = damage;
        }
    }
}
