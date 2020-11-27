package h08;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isValid(int x, int y) {
        return x < 9 && x > 0 && y < 9 && y > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position p) {
        return (p.x == this.x) && (p.y == this.y);
    }

    public String toString() {
        return "(" + x + "/" + y + ")";
    }
}
