
public class Main {
    public static void main(String[] args) {
        DirectCinemaBuilder director = new DirectCinemaBuilder();
        CinemaBuilder builder = new CinemaConcreteBuilder();
        Cinema cinema = director.constract(builder);
        System.out.println(cinema.getTitle());
    }

}

