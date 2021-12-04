package bingo;

import java.util.ArrayList;
import java.util.List;

public class GiantSquid {

    public static int calculatePartOne(List<Board> boards, List<Integer> values) {

        Board winner = null;
        int asd = 0;
        for (Integer value : values) {
            for(Board board : boards) {
                board.checkValue(value);
                if (board.isMarkedRowOrColumn()) {
                    winner = board;
                    asd = value;
                    break;
                }
            }
            if(winner != null) {
                break;
            }
        }

        if(winner != null) {
            System.out.println("SCORE: " + winner.calculateScore() * asd);
        }

        return 0;
    }

    public static int calculatePartTwo(List<Board> boards, List<Integer> values) {

        List<Board> winners = new ArrayList<>();
        for (Integer value : values) {
            for(Board board : boards) {
                board.checkValue(value);
                if (board.isMarkedRowOrColumn() && !board.isAdded()) {
                    board.setAdded(true);
                    board.setVal(value);
                    winners.add(board);
                }
            }
            if(winners.size() == boards.size())
                break;
        }

        System.out.println("PART TWO: " + winners.get(winners.size()-1).calculateScore() * winners.get(winners.size()-1).getVal());

        return 0;
    }
}
