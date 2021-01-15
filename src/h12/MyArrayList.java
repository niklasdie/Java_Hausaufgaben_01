package h12;

/**
 * Diese Klasse ist eine vereinfachte, selbst geschriebene ArrayList<T>.
 *
 * @param <T> Objekttyp welches die ArrayList fuellen soll.
 */
public class MyArrayList<T> {

    private T[] arr;
    private int index;

    /**
     * Konstruktor fuer MyArrayList.
     */
    @SuppressWarnings("unchecked")// wegen Konstruktor von T[]
    public MyArrayList() {
        this.arr = (T[]) new Object[10];
        this.index = 0;
    }

    /**
     * Fuegt den Parameter vorne an der ArrayList hinzu.
     *
     * @param data Objekt welches hinzugefuegt werden soll
     */
    public void addFirst(T data) {
        this.proof();
        int i = this.index;
        while (i > 0) {
            this.arr[i] = this.arr[i - 1];
            i--;
        }
        this.arr[0] = data;
        this.index++;
    }

    /**
     * Fuegt den Parameter hinten an der ArrayList hinzu.
     *
     * @param data Objekt welches hinzugefuegt werden soll
     */
    public void addLast(T data) {
        this.proof();
        this.arr[index] = data;
        this.index++;
    }

    /**
     * Gibt das Element an der Stelle des eingegebenen Index zurueck.
     *
     * @param i Index
     * @return Element aus der ArrayList
     */
    public T get(int i) {
        if (i < 0 || i >= this.index) {
            throw new ArrayIndexOutOfBoundsException("i ist negativ oder zu groß!");
        } else {
            return this.arr[i];
        }
    }

    /**
     * Loescht die gesamte ArrayList.
     */
    @SuppressWarnings("unchecked") // wegen Konstruktor von T[]
    public void clear() {
        this.arr = (T[]) new Object[10];
        index = 0;
    }

    /**
     * Gibt die Groesse der ArrayList zurueck.
     *
     * @return Groesse der ArrayList
     */
    public int size() {
        return this.index;
    }

    /**
     * Hilfsmethode die ueberprueft ob in der ArrayList Platz fuer ein weiteres Element ist.
     */
    private void proof() {
        if (this.arr[this.arr.length - 1] != null) this.extendAndCopy();
    }

    /**
     * Hilfsmethode die falls kein Platz mehr fuer ein weiteres Element in der ArrayList verfuegbar ist,
     * um das dopplete erweitert.
     */
    @SuppressWarnings("unchecked") // wegen Konstruktor von T[]
    private void extendAndCopy() {
        T[] temp = this.arr;
        this.arr = (T[]) new Object[temp.length * 2];
        this.index = 0;
        for (T x : temp) {
            this.arr[index] = x;
            this.index++;
        }
    }

    // Test
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.addLast(2);
        System.out.println("Groesse der Liste: " + list1.size()); // 1
        for (int i = 0; i < 10; i++) {
            list1.addFirst(i);
        }
        System.out.println("Groesse der Liste: " + list1.size()); // 11
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " "); // 9 8 7 6 5 4 3 2 1 0 2
        }
        System.out.println();
        list1.clear();
        System.out.println("Groesse der Liste: " + list1.size()); // 0
        MyArrayList<String> list2 = new MyArrayList<>();
        list2.addFirst("Java");
        String s = list2.get(0);
        System.out.println(s); // Java
    }
}
