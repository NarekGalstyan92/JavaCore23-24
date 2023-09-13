package classwork.chapter6;

class BoxDemo4 {
    public static void main(String[] args) {

        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;

        //assign values to myBox1's instance variables
        myBox1.width = 10;
        myBox1.height = 20;
        myBox1.depth = 15;

        //assign values to myBox2's instance variables
        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;

        // get volume of the first box
        vol = myBox1.volume();
        System.out.println("Volume is: " + vol);

        // get volume of the second box
        vol = myBox2.volume();
        System.out.println("Volume is: " + vol);
    }
}
