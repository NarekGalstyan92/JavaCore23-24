package classwork.chapter6;


class BoxDemo6 {
    public static void main(String[] args) {
        // declare, allocate, and initialize Box objects
        Box myBox1 = new Box();
        Box myBox2 = new Box();

        double vol;

        // get volume of the first box
        vol = myBox1.volume();
        System.out.println("Volume is: " + vol);
        // get volume of the second box
        vol = myBox2.volume();
        System.out.println("Volume is: " + vol);

    }
}
