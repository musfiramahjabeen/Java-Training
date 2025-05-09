class RatMaze {
    public static void solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] sol = new int[n][n];
        if (solveMazeUtil(maze, 0, 0, sol)) {
            printSolution(sol);
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) return false; // avoid cycles
            sol[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, sol)) return true;
            if (solveMazeUtil(maze, x, y + 1, sol)) return true;
            sol[x][y] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1;
    }

    private static void printSolution(int[][] sol) {
        for (int[] row : sol) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}