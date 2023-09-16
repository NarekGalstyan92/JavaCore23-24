package classwork.chapter6;

class BoxDemo7 {
    public static void main(String[] args) {
        // declare, allocate, and initialize Box objects
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box(3, 6 , 9);

        double vol;

        // get volume of the first box
        vol = myBox1.volume();
        System.out.println("Volume is: " + vol);
        // get volume of the second box
        vol = myBox2.volume();
        System.out.println("Volume is: " + vol);

    }
}
