package Bridge.TEst;

public abstract class Works {
    public static class Chelovechnya implements Work{
        @Override
        public void work(){
            System.out.println("Chelovechnya");
        }
    }
    public static class Beef implements Work{
        @Override
        public void work(){
            System.out.println("Beef");
        }
    }


}
