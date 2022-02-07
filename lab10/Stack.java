import java.util.Arrays;

public class Stack<T> {
    private int maxSize;
    private int currentSize;
    private T[] data;

    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
    this.maxSize = maxSize;
    this.data = (T[]) new Object[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public T pop() throws RuntimeException{
        if (currentSize == 0) {
            throw (new RuntimeException("empty stack"));
        }
        for (int i=0; i<currentSize-1; i++) {
            this.data[i] = this.data[i+1];
        }
        currentSize--;
        return this.data[currentSize];
    }

    public void push(T val) throws RuntimeException{
        if (currentSize == maxSize) {
            throw (new RuntimeException("full stack"));
        }
        for (int i=currentSize; i>0; i--) {
            this.data[i] = this.data[i-1];
        }
        this.data[0] = val;
        this.currentSize++;
    }

    public Stack<T> copy() {
        Stack<T> tmp = new Stack<>(this.maxSize);
        tmp.setCurrentSize(this.currentSize);
        for(int i=0; i<this.currentSize; i++) {
                    tmp.getData()[i]=this.data[i];
        }
//        tmp.setData(this.data.clone()); //fajny szybki sposób
        return tmp;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public T[] getData() {
        return data;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
