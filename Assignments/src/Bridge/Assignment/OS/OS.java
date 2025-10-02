package Bridge.Assignment.OS;

import Bridge.Assignment.Works.interfaces.Work;

import java.util.List;
public abstract class OS {
    protected List<Work> works;

    protected OS(List<Work> works) {
        this.works = works;
    }

    public void coding() {
        for (Work work : works) {
            runWork(work);
        }
    }
    protected abstract void runWork(Work work);

    public static class WindowsOS extends OS {
        public WindowsOS(List<Work> works){
            super(works);
        }

        @Override
        protected void runWork(Work work){
            System.out.println("Windows running: ");
            work.work();
        }
    }

    public static class MacOS extends OS {
        public MacOS(List<Work> works){
            super(works);
        }

        @Override
        protected void runWork(Work work){
            System.out.println("MacOS running: ");
            work.work();
        }
    }

    public static class LinuxOS extends OS {
        public LinuxOS(List<Work> works){
            super(works);
        }

        @Override
        protected void runWork(Work work){
            System.out.println("Linux running: ");
            work.work();
        }
    }

}
