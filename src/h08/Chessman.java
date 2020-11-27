package h08;

import java.util.ArrayList;

public abstract class Chessman {

    Position pos;

    public Chessman(Position pos) {
        this.pos = pos;
    }

    public abstract ArrayList<Position> getMoveList();

    public Position getPosition() {
        return this.pos;
    }

    public void moveTo(Position pos) {
        this.pos = pos;
    }

    public boolean canMoveTo(Position pos) {
        return this.getMoveList().contains(pos);
    }
}
