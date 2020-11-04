import java.util.ArrayList;

public class Singleton extends IntSet {

    static Singleton s0 = new Singleton(0);
    static Singleton s1 = new Singleton(1);
    static Singleton s2 = new Singleton(2);
    static Singleton s3 = new Singleton(3);
    static Singleton s4 = new Singleton(4);
    static Singleton s5 = new Singleton(5);
    static Singleton s6 = new Singleton(6);
    static Singleton s7 = new Singleton(7);

    int value;

    private Singleton(int x) {
        value = x;
    }

    public static Singleton smartSingleton(int x) {
        switch (x) {
            case 0:
                return s0;
            case 1:
                return s1;
            case 2:
                return s2;
            case 3:
                return s3;
            case 4:
                return s4;
            case 5:
                return s5;
            case 6:
                return s6;
            case 7:
                return s7;
            default:
                return new Singleton(x);

        }
    }


    public TreeSet add(int x) {
        return new TreeSet(value, x);
    }

    public boolean contains(int x) {
        return (x == value);
    }

    public String makeString() {
        return "{" + value + "}";
    }

    public IntSet union(IntSet other){
        if (other instanceof EmptySet){
            return this;
        }

        if (other instanceof Singleton){
            if (Integer.parseInt(other.makeString().substring(1, other.makeString().length()-1)) == value) {
                return this;
            }
            else {
                return new TreeSet(this.value, ((Singleton) other).value);
            }
        }

        if (other instanceof TreeSet){
            if (other.contains(value)) {
                return other.add(value);
            }
            else {
                return other;
            }
        }

        else {
            return null;
        }

    }


    public ArrayList<Integer> getArray() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(value);
        return temp;
    }
}
