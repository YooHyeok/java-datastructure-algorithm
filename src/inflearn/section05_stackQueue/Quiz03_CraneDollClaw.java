package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz03_CraneDollClaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(answer(n, board, m, moves));
    }
    // 4, 3, 1, 1, 3, 2, X, 4
    // 4, 1, 1, 1, 3
    private static int answer(int length, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i]-1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][move] != 0) {
                    if(stack.size() > 0 && stack.peek() == board[j][move]) {
                        answer++;
                        stack.pop();
                        board[j][move] = 0;
                        break;
                    }
                    stack.add(board[j][move]);
                    board[j][move] = 0;
                    break;
                }
            }
        }
        return answer * 2;
    }


}
