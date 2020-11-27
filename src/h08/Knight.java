package h08;

import java.util.ArrayList;

public class Knight extends Chessman {

    public Knight(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> res = new ArrayList<>();
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int i = 1; i < 5; i++) {
            switch (i) {
                case 1:
                    x1 = x2 = pos.getX() - 2;
                    y1 = pos.getY() - 1;
                    y2 = pos.getY() + 1;
                    break;
                case 2:
                    y1 = y2 = pos.getY() - 2;
                    x1 = pos.getX() - 1;
                    x2 = pos.getX() + 1;
                    break;
                case 3:
                    x1 = x2 = pos.getX() + 2;
                    y1 = pos.getY() - 1;
                    y2 = pos.getY() + 1;
                    break;
                case 4:
                    y1 = y2 = pos.getY() + 2;
                    x1 = pos.getX() - 1;
                    x2 = pos.getX() + 1;
                    break;
            }
            if (Position.isValid(x1, y1)) {
                res.add(new Position(x1, y1));
            }
            if (Position.isValid(x2, y2)) {
                res.add(new Position(x2, y2));
            }
        }
        return res;
    }


    public String toString() {
        return "Springer: " + pos.toString();
    }
}
