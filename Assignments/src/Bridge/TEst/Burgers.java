package Bridge.TEst;

import Bridge.TEst.*;

import java.util.List;
public abstract class Burgers {
    protected List<Work> works;

    protected Burgers(List<Work> works) {
        this.works = works;
    }

    public void nachinka() {
        for (Work work : works) {
            runWork(work);
        }
    }
    protected abstract void runWork(Work work);

    public static class BlackBread extends Burgers {
        public BlackBread(List<Work> works){
            super(works);
        }

        @Override
        protected void runWork(Work work){
            System.out.println("BlackBread running: ");
            work.work();
        }
    }

    public static class WhiteBread extends Burgers {
        public WhiteBread(List<Work> works){
            super(works);
        }

        @Override
        protected void runWork(Work work){
            System.out.println("WhiteBread running: ");
            work.work();
        }
    }



}
