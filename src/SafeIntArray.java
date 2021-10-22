import java.util.Iterator;

public class SafeIntArray implements Iterable {

    int[] internalArray;
    int internalSize;

    class SafeIntArrayIterator implements Iterator {
        private int counter;
        SafeIntArray sa;

        /* you do this part. */
        public SafeIntArrayIterator(SafeIntArray arr) {
            sa = arr;
        }


        /* you do this part. */
        public boolean hasNext() {
            return (counter < sa.internalSize);
        }

        /* you do this part. */
        public Integer next() {
            return sa.internalArray[counter++];
        }

        /* you do this part. */

        public void remove() {
            sa.remove(counter);
        }
    }

    public SafeIntArray(int initialSize) {
        this.internalArray = new int[initialSize];
        this.internalSize = 0;
    }

    public Iterator iterator() {
        return new SafeIntArrayIterator(this);
    }


    /* default size - 10 */
    public SafeIntArray() {
        this.internalArray = new int[10];
        this.internalSize = 0;
    }


    /* add the value val at the end of the array.
     * If the array is full, create a new array of 2x size, and copy everything there. */
    public void add(int val) {
        if (internalSize == internalArray.length) {
            int allocated = internalArray.length;
            int[] temp = internalArray;
            internalArray = new int[2 * allocated];
            for (int i = 0; i < allocated; i++) {
                internalArray[i] = temp[i];
            }
        }
        internalArray[internalSize] = val;
        internalSize++;
    }

    /* set array[index] = val */
    public void set(int index, int val)  {
        if (index > internalSize || index < 0) {
            System.out.println("Invalid index");
        } else {
            internalArray[index] = val;
        }
    }

    public int get(int index)  {
        if (index > internalSize || index < 0) {
            System.out.println("Invalid index");
            return -1;
        } else {
            return internalArray[index];
        }
    }

    /* return true if val is in the array */
    public boolean contains(int val) {
        return (indexOf(val) != -1);
    }

    /* return the index where val is stored, or -1 if it's not present. */
    public int indexOf(int val) {
        for (int i = 0; i < internalSize; i++) {
            if (internalArray[i] == val) {
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
            internalArray[internalSize] = 0;
            internalSize--;
        }
    }

    public void insertAt(int index, int elementToInsert) {

    }


    public int size() {
        return internalSize;
    }
}





