package Factory.learn.transport;

public interface Transport {
    void deliver();
}

class Ship implements Transport{
    public void deliver(){
        System.out.println("Deliver by ocean");
    }
}

class Truck implements Transport{
    public void deliver(){
        System.out.println("Deliver by land");
    }
}