package Bridge.Assignment;

public abstract class OS {
    protected Work work1;
    protected Work work2;
    protected OS(Work work1, Work work2){
        this.work1 = work1;
        this.work2 = work2;
    }
    abstract public void coding();

    public static class WindowsOS extends OS{
        public WindowsOS(Work work1, Work work2){
            super(work1, work2);
        }
        @Override
        public void coding(){
            work1.work();
            work2.work();
        }
    }
}
