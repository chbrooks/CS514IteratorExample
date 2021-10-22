import java.util.Iterator;

public class GenericSafeArray<Type> implements Iterable<Type> {

    /* Java doesn't let us create generic arrays, so let's use Object here */
    protected Object[] internalArray;
    int internalSize;

    public GenericSafeArray(int initialSize) {
        this.internalArray = new Object[initialSize];
        this.internalSize = 0;
    }

    /* default size - 10 */
    public GenericSafeArray() {
        this.internalArray = new Object[10];
        this.internalSize = 0;
    }

    public Iterator<Type> iterator() {
        return new GenericSafeArrayIterator<Type>(this);
    }

    /* add the value val at the end of the array.
     * If the array is full, create a new array of 2x size, and copy everything there. */
    public void add(Type val) {
        if (internalSize == internalArray.length) {
            int allocated = internalArray.length;
            Object[] temp = internalArray;
            internalArray = new Object[2 * allocated];
            for (int i = 0; i < allocated; i++) {
                internalArray[i] = temp[i];
            }
        }
        internalArray[internalSize] = val;
        internalSize++;
    }

    /* set array[index] = val */
    public void set(int index, Type val)  {
        if (index > internalSize || index < 0) {
            System.out.println("Invalid index");
        } else {
            internalArray[index] = val;
        }
    }

    public Type get(int index)  {
        if (index > internalSize || index < 0) {
            System.out.println("Invalid index");
            return null;
        } else {
            /* we need to explicitly cast here */
            return (Type)internalArray[index];
        }
    }

    /* return true if val is in the array */
    public boolean contains(Type val) {
        return (indexOf(val) != -1);
    }

    /* return the index where val is stored, or -1 if it's not present. */
    public int indexOf(Type val) {
        for (int i = 0; i < internalSize; i++) {
            if (internalArray[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    /* remove the element at index. *
       slide all elements in the array down.
     */
    public void remove(int index) {
        if (index > internalSize || index < 0) {
            System.out.println("Invalid index");
        } else {
            for (int i = index; i < internalSize - 1; i++) {
                internalArray[i] = internalArray[i + 1];
            }
            internalArray[internalSize] = null;
            internalSize--;
        }
    }

    public int size() {
        return internalSize;
    }


}
