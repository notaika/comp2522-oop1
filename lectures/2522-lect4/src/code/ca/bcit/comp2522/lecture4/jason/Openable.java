interface Openable {
    void open();
    void close();
}
class Door implements Openable, Comparable<Door>{
    private final int heightCm;
    Door(final int heightCm) {
        this.heightCm = heightCm;
    }
    @Override
    public int compareTo(final Door that){
        return this.heightCm - that.heightCm;
    }
    @Override
    public void open(){
        System.out.println("turn handle, push");
    }
    @Override
    public void close(){
        System.out.println("close on hinges");
    }
}
class App implements Openable{
    @Override
    public void open()    {
        System.out.println("swipe, use face id");
    }
    @Override
    public void close()    {
        System.out.println("tap X");
    }
}
class Main2{
    public static void main(final String[] args) {
        final Door o1;
        final Door o2;
        final Door o3;
        final Door o4;
        o1 = new Door(30);
        o2 = new Door(37);
        o3 = new Door(25);
        o4 = new Door(35);

        System.out.println(o1.compareTo(o2));  // -7
        System.out.println(o1.compareTo(o3));  // +5
        System.out.println(o1.compareTo(o4));  // -5
        System.out.println(o3.compareTo(o2));  // -12
        System.out.println(o4.compareTo(o2));  // -2
        System.out.println(o3.compareTo(o4));  // -10




        // o2 = new App();
        o1.open();
        o1.close();
        o2.open();
        o2.close();
    }
}
