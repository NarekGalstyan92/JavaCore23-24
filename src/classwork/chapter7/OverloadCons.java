package classwork.chapter7;

class OverloadCons {
    public static void main(String[] args) {

        // Creating boxes using the various constructors
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box();
        Box myCube = new Box(7);

        double vol;

        // Get volume of the first box
        vol = myBox1.volume();
        System.out.println("Volume of myBox1 is: " + vol);

        // Get volume of the second box
        vol = myBox2.volume();
        System.out.println("Volume of myBox2 is: " + vol);

        // Get volume of cube
        vol = myCube.volume();
        System.out.println("Volume of myCube is: " + vol);

    }
}
