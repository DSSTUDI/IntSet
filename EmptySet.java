import java.util.ArrayList;

public class EmptySet extends IntSet {

    static EmptySet newSet = new EmptySet();

    private EmptySet(){

    }

    public static EmptySet SmartEmptySet(){
        return newSet;
    }

    public Singleton add(int x) {
        return Singleton.smartSingleton(x);
    }

    public boolean contains(int x) {
        return false;
    }

    public String makeString() {
        return "{}" ;
    }

    public IntSet union(IntSet other) {
        return other;
    }


    public ArrayList<Integer> getArray() {
        return new ArrayList<Integer>();
    }
}
