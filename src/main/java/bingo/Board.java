package bingo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Point[][] points;

    public Board(Point[][] points) {
        this.points = points;
    }

    @Getter
    @Setter
    public static class Point {

        private int value;
        private boolean marked;

        public Point(int value) {
            this.value = value;
        }
    }
}
