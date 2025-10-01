package Bridge.Assignment;

public abstract class Works{
    public static class Terminal implements Work{
        @Override
        public void work(){
            System.out.println("Coded Terminal");
        }
    }

    public static class FileExplorer implements Work{
        @Override
        public void work(){
            System.out.println("Coded FileExplorer to make it convenient");
        }
    }
    public static class Settings implements Work {
        @Override
        public void work() {
            System.out.println("Opening system settings");
        }
    }
    public static class SecurityCenter implements Work {
        @Override
        public void work() {
            System.out.println("Running security check");
        }
    }
}
