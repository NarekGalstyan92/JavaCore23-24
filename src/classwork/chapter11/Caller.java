package classwork.chapter11;

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
