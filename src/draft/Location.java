package draft;

public class Location {

    private int i, j;

    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int i() {
        return i;
    }

    public int j() {
        return j;
    }

    public void print() {
        System.out.println("(" + i + "," + j + ")");
    }

    public Location north() {
        return new Location(i - 1, j);
    }

    public Location south() {
        return new Location(i + 1, j);
    }

    public Location east() {
        return new Location(i, j + 1);
    }

    public Location west() {
        return new Location(i, j - 1);
    }
}