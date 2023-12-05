package classwork.chapter11;

public class JoinExample {
    public static void main(String[] args) {
        Thread threadToJoin = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Count: " + i);
                try {
                    Thread.sleep(500); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the thread
        threadToJoin.start();

        try {
            // Main thread waits for threadToJoin to finish
            threadToJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread continues after threadToJoin is done.");
    }
}
