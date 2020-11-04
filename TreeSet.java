import java.util.ArrayList;

public class TreeSet extends IntSet {

    private IntSet odd = EmptySet.SmartEmptySet();

    private IntSet even = EmptySet.SmartEmptySet();

    public TreeSet(IntSet left, IntSet right) {
        even = left;
        odd = right;

    }

    public TreeSet(int x, int y){
        if (x % 2 == 1) {
            odd = odd.add(x/2);
        }
        else {
            even = even.add(x/2);
        }
        if (y % 2 == 1) {
            odd = odd.add(y/2);
        }
        else {
            even = even.add(y/2);
        }
    }


    public TreeSet add(int x) {
        IntSet newEven = even;
        IntSet newOdd = odd;

        if (x % 2 == 0) {
            newEven = even.add(x/2);
        }
        else {
            newOdd = odd.add(x/2);
        }
        return new TreeSet(newEven, newOdd);
    }

    public boolean contains(int x) {
        if (x % 2 == 0) {
            return even.contains(x/2);
        }
        else {
            return odd.contains(x/2);
        }
    }

    public String makeString() {
        String out = "";
        ArrayList<Integer> temp = this.getArray();
        out = out + temp.get(0);
        for (int c = 1; c < temp.size(); c++){
            out = out + "," + temp.get(c);
        }
        return ("{" + out + "}");
    }

    public IntSet union(IntSet other){
        if (other instanceof EmptySet){
            return this;
        }

        if (other instanceof Singleton){
            if (this.contains(Integer.parseInt(other.makeString().substring(1, other.makeString().length()-1)))){
                return this;
            }
            else{
                return this.add(Integer.parseInt(other.makeString().substring(1, other.makeString().length()-1)));
            }
        }

        if (other instanceof TreeSet){
            TreeSet tempSet = (TreeSet)other;
            IntSet newOdd = tempSet.odd.union(odd);
            IntSet newEven = tempSet.even.union(even);
            return new TreeSet(newEven, newOdd);
        }

        else {
            return null;
        }
    }

    public ArrayList<Integer> getArray() {
        ArrayList<Integer> finalArray = new ArrayList<Integer>();

        ArrayList<Integer> evenArray = even.getArray();
        ArrayList<Integer> oddArray = odd.getArray();

        for (int c = 0; c < evenArray.size(); c++) {
            finalArray.add(evenArray.get(c)*2);
        }
        for (int c = 0; c < oddArray.size(); c++) {
            finalArray.add(oddArray.get(c)*2+1);
        }

        return finalArray;

    }


}
