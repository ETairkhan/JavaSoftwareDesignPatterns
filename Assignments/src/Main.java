import Builder.AnimalConcrete;
import Builder.AnimalDirector;

public class Main {
    public static void main(String[] args) {
        AnimalDirector director = new AnimalDirector(new AnimalConcrete());

        System.out.println(director.buildTiger());
        System.out.println(director.buildElephant());
        System.out.println(director.buildDog());

    }

}

