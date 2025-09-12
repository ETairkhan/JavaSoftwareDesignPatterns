public class DirectCinemaBuilder {
    public Cinema constract(CinemaBuilder builder){
        builder.setDuration(10);
        builder.setTitle("MARVEL");
        return builder.build();
    }
}
