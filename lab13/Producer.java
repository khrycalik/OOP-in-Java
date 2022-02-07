public class Producer extends Thread {
    Buffer b;

    public Producer(Buffer b) {
        this.b=b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Adding element to the buffer, producer: " + Thread.currentThread());
                b.put();
                Thread.sleep((int)(Math.random() * 10000));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
