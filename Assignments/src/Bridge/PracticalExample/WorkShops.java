package Bridge.PracticalExample;

public abstract class WorkShops {
    public static class Produce  implements WorkShop{
        @Override
        public void work(){
            System.out.println("Produced");
        }
    }

    public static class  Assemble implements WorkShop{
        @Override
        public void work(){
            System.out.println(" And");
            System.out.println(" Assembled.");
        }
    }


}
