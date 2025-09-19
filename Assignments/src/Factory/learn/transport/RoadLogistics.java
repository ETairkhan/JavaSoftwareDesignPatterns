package Factory.learn.transport;

public class RoadLogistics extends Logistics{
    public Transport createTransport(){
        return new Truck();
    }
}

class SeaLogistics extends Logistics{
    public Transport createTransport(){
        return new Ship();
    }
}