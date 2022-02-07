public class StackUtils {

    public static <T> String toString(Stack<T> tmp){
        String str = "[";
        for(int i=0; i<tmp.getCurrentSize()-1; i++ ) {
            str +=tmp.getData()[i] +", ";
        }
        return str + tmp.getData()[tmp.getCurrentSize()-1] + "]";
    }

    public static<T, U> boolean equals(Stack<T> f, Stack<U> s) {
    if (f.getClass() != s.getClass()) {
        return false;
    }
    if (f.getCurrentSize() != s.getCurrentSize() || f.getMaxSize() != s.getMaxSize()) return false;
    for (int i=0; i < f.getCurrentSize();i++) {
        if (!f.getData()[i].equals(s.getData()[i]))
            return false;
    }
    return true;
    }

    public static <T> Stack<T> swap(Stack<T> obj, int f, int s) throws ArrayIndexOutOfBoundsException {
        if (obj.getCurrentSize() < f) {
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than stack max size");
        }
        if (obj.getCurrentSize() < s) {
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than current stack size");
        }
        if (f < 0 || s < 0) {
            throw new ArrayIndexOutOfBoundsException("Given indexes are below zero");
        }
        T tmp = obj.getData()[f];
        obj.getData()[f] = obj.getData()[s];
        obj.getData()[s] = tmp;
        return obj.copy();
    }
}
