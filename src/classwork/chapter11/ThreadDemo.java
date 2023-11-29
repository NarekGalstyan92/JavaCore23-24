package classwork.chapter11;

class ThreadDemo {
    public static void main(String[] args) {
        NewThread nt = new NewThread("Some name"); // create a new thread

    //    nt.start(); // Start the thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
