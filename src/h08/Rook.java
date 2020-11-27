package h08;

import java.util.ArrayList;

public class Rook extends Chessman {

    public Rook(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> res = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            res.add(new Position(i, pos.getY()));
            res.add(new Position(pos.getX(), i));
        }
        return res;
    }

    public String toString() {
        return "Turm: " + pos.toString();
    }
}
