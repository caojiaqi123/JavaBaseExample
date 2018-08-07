package MyCollection;

public class MyArrayList2 {
    private Object[] elements;
    private int size;

    public MyArrayList2() {
        this(16);
    }

    public MyArrayList2(int size) {
        elements = new Object[size];
    }

    public int size() {
        return this.size;
    }

    public void add(Object e) {

        if (size + 1 > elements.length) {
            Object[] newArray = new Object[size * 2 + 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }

        elements[size++] = e;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            try {
                throw new Exception("越界");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int removeNum = size - index - 1;
        if (removeNum > 0) {
            System.arraycopy(elements, index + 1, elements, index, removeNum);
            elements[--size] = null;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception("越界");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return elements[index];
    }

    public static void main(String[] args) {

        MyArrayList2 myArrayList2 = new MyArrayList2(3);
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);
        myArrayList2.add(4);

        myArrayList2.remove(0);
        System.out.println(myArrayList2.get(2));
    }
}
