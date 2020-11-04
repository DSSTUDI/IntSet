import java.util.ArrayList;

abstract class IntSet {


    public abstract IntSet add(int x);

    public abstract boolean contains(int x);

    public abstract String makeString();

    public abstract  IntSet union(IntSet set);

    public abstract ArrayList<Integer> getArray();

}
