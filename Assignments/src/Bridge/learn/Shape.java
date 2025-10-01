package Bridge.learn;

public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI api){
        this.drawAPI = api;
    }
    public abstract void draw();

    public static class Circle extends Shape {
        private int r, x ,y;
        public Circle(int r,int x, int y, DrawAPI api){
            super(api);
            this.r = r;
            this.x = x;
            this.y = y;

        }
        public void draw(){
            drawAPI.drawCircle(r, x, y);
        }
    }
}
