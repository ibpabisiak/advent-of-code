package bingo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Point[][] points;
    private boolean added;
    private int val;

    public Board(Point[][] points) {
        this.points = points;
    }

    public void checkValue(int value) {
        for (int i = 0; i < 5; i++) {
            boolean a = false;
            for (int j = 0; j < 5; j++) {
                if(points[i][j].getValue() == value) {
                    points[i][j].setMarked(true);
                    a = true;
                    break;
                }
            }
            if(a)
                break;
        }
    }

    public boolean isMarkedRowOrColumn() {

        //check row
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if(points[i][j].isMarked()) {
                    count++;
                }
            }
            if(count == 5) {
                return true;
            }
        }

        //check column
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if(points[j][i].isMarked()) {
                    count++;
                }
            }
            if(count == 5){
                return true;
            }
        }

        return false;
    }

    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!points[i][j].isMarked()) {
                    score += points[i][j].getValue();
                }
            }
        }

        return score;
    }

    @Getter
    @Setter
    public static class Point {

        private int value;
        private boolean marked = false;

        public Point(int value) {
            this.value = value;
        }
    }
}
