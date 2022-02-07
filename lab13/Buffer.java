public class Buffer {
    private int maxSize;
    private int currentSize;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }

    synchronized void put() {
    while (currentSize == maxSize) {
        try { 
            System.out.println("Buffer is full, waiting...");
            wait(); 
        } catch(InterruptedException e) {
            /*...*/
        }
    }
    currentSize++;
    System.out.println("Element added to the buffer. Space: " + currentSize + "/" + maxSize);
    notify();
    }

    synchronized void get() {
    while(currentSize == 0) {
        try {
                System.out.println("Buffer is empty, waiting...");
                wait(); 
            } catch(InterruptedException e) {
                /*...*/
            }
        }
        currentSize--;
        System.out.println("Element removed from the buffer. Space: " + currentSize + "/" + maxSize);
        notify();
    }
}