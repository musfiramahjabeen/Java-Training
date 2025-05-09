## Java Training
**Problem Solving with JAVA** 

### 1. Sieve of Eratosthenes (Prime Detection)
An efficient algorithm to find all prime numbers up to a given limit by iteratively marking multiples of each prime as composite.
```java
import java.util.*;
public class SieveOfEratosthenes {
    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 50; // Example: Find primes <= 50
        sieve(n);
    }
}

```
### 2. N-Queens Problem
A classic backtracking problem that places N queens on an N×N chessboard so that no two queens can attack each other (no two queens share the same row, column, or diagonal).
```java
class NQueens {
    static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0);
    }
    static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
    static void printBoard(char[][] board) {
        for (char[] row : board) System.out.println(Arrays.toString(row));
        System.out.println();
    }
}
```
### 3. Number of Islands
Uses DFS or BFS to count connected groups of '1's in a 2D binary grid, representing islands surrounded by water ('0's).
```java
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i+1, j); dfs(grid, i-1, j);
        dfs(grid, i, j+1); dfs(grid, i, j-1);
    }
}
```
### 4. Knight's Tour
A backtracking algorithm to find a sequence of moves for a knight to visit every square exactly once on a chessboard.
```java
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
```
### 5. Rat in a Maze
A pathfinding algorithm using backtracking to find all possible paths from start to destination in a maze with obstacles.
```java
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
```
### 6. HashMap
Using hash tables to solve problems like counting word frequencies or finding duplicates with O(1) lookup time.
```java
class WordFrequency {
    public static void countWords(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        java.util.HashMap<String, Integer> freqMap = new java.util.HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (java.util.Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```
### 7. Longest Common Substring
Finds the longest string that appears as a contiguous substring in two input strings, typically using dynamic programming.
```java
class LongestCommonSubstring {
    public static String lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLen = 0, end = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - maxLen, end);
    }
}
```
### 8. Longest Common Subsequence
 Finds the longest sequence of characters that appear in the same order (but not necessarily consecutively) in both strings.
```java
class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

```
### 9. Jump Game(Jumping in Array)
A dynamic programming or greedy approach to determine if you can reach the end of an array where each element represents the maximum jump length.
```java
class JumpGame {
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static int minJumps(int[] nums) {
        if (nums.length <= 1) return 0;
        int jumps = 0, currEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return currEnd >= nums.length - 1 ? jumps : -1; // -1 if unreachable
    }
}
```
### 10. Sudoku Solver 
Uses backtracking to solve a 9×9 Sudoku puzzle by trying different values for empty cells and backtracking when no valid solution is found.
```java
class SudokuSolver {
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == num) return false;
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

```
### 11. Simple Calculator
A Simple Calculator is a basic Java program that performs arithmetic operations such as addition, subtraction, multiplication, and division. It takes two numeric inputs and an operator from the user, computes the result using a switch statement, and displays the output. It also handles errors like division by zero.
```java
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("=== Simple Calculator ===");
        System.out.print("Enter first number: ");
        num1 = sc.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        operator = sc.next().charAt(0);

        System.out.print("Enter second number: ");
        num2 = sc.nextDouble();

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result = " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result = " + result);
                } else {
                    System.out.println("Error: Division by zero is undefined.");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }

        sc.close();
    }
}

```
### 12. Palindrome Partitioning
Uses backtracking to find all ways to split a string into substrings that are all palindromes.
```java
public class PalindromePartitioning {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] minCuts = new int[n];
        
        for (int i = 0; i < n; i++) {
            minCuts[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        minCuts[i] = 0;
                    } else {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return minCuts[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts required: " + minCut(s));
    }
}

```
### 13. Recursive Staircase
Count distinct ways to climb N stairs when you can jump 1, 2, or 3 steps at a time.
```java
public class RecursiveStaircase {
    
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        int n = 4;  // Example: N = 4
        System.out.println("Distinct ways to climb " + n + " stairs: " + countWays(n));
    }
}

```
### 14. Word Ladder
Given two words (begin word and end word), and a dictionary, find the length of the shortest transformation sequence from begin word to end word, such that only one letter can be changed at a time.
```java
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            
            level++;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        
        String beginWord = "hit";
        String endWord = "cog";
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println("The length of the shortest transformation sequence is: " + result);
    }
}
```
### 15. N-th Fibonacci Number (Memoization/DP)
Find the n-th Fibonacci number using dynamic programming or memoization.
```java
public class Fibonacci {
    
    // Memoization approach
    private static int[] memo;
    
    public static int fibMemo(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }
    
    // Dynamic Programming approach (Tabulation)
    public static int fibDP(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 10;
        
        // Initialize memoization array
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        System.out.println("Fibonacci using Memoization: " + fibMemo(n));
        System.out.println("Fibonacci using DP (Tabulation): " + fibDP(n));
    }
}
```


