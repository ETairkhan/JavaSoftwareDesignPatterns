public class CinemaConcreteBuilder implements CinemaBuilder {
    Cinema cinema = new Cinema();

    @Override
    public void setTitle(String title){
        cinema.setTitle(title);
    }

    @Override
    public void setDuration(int duration){
        cinema.setDuration(duration);
    }

    public Cinema build(){
        return cinema;
    }
}
