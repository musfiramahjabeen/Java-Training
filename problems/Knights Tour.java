import java.util.Arrays;
class KnightsTour {
    static int N = 8;
    static int[][] board = new int[N][N];
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void solve() {
        for (int[] row : board) Arrays.fill(row, -1);
        board[0][0] = 0;
        if (backtrack(0, 0, 1)) printBoard();
        else System.out.println("No solution");
    }
    static boolean backtrack(int x, int y, int move) {
        if (move == N*N) return true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == -1) {
                board[nx][ny] = move;
                if (backtrack(nx, ny, move + 1)) return true;
                board[nx][ny] = -1;
            }
        }
        return false;
    }
    static void printBoard() {
        for (int[] row : board) System.out.println(Arrays.toString(row));
    }
}