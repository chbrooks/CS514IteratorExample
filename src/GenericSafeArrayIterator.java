import java.util.Iterator;

public class GenericSafeArrayIterator<Type> implements Iterator<Type> {
     
    GenericSafeArray<Type> myArray;
    int counter;

    public GenericSafeArrayIterator(GenericSafeArray<Type> inputArray) {
        myArray = inputArray;
        counter = 0;
    }
    
    public boolean hasNext() {
        return (counter < myArray.internalSize);
    }
    
    public Type next() {
        return myArray.get(counter++);
    }
    
    public void remove() {
        myArray.remove(counter);
    }
    
}
