public class Consumer extends Thread {
    Buffer b;

    public Consumer(Buffer b){
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Removing element from the buffer, customer: " + Thread.currentThread());
                b.get();
                Thread.sleep((int)(Math.random() * 10000));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
