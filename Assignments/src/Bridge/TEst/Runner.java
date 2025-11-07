package Bridge.TEst;

import java.util.Arrays;

public class Runner {
    public void Start(){
        Burgers blackBread = new Burgers.BlackBread(Arrays.asList(
                new Works.Chelovechnya(),
                new Works.Beef()
        ));

        Burgers whiteBread = new Burgers.WhiteBread(Arrays.asList(
                new Works.Chelovechnya(),
                new Works.Beef()
        ));

        System.out.println("---- Cherry ----");
        blackBread.nachinka();

        System.out.println("---- Strawberry ----");
        whiteBread.nachinka();
    }
}
