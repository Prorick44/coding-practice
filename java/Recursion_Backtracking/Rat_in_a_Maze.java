package java.Recursion_Backtracking;

import java.util.*;

public class Rat_in_a_Maze {
  public static ArrayList<String> findPath(int[][] m, int n) {
    ArrayList<String> result = new ArrayList<>();
    boolean[][] visited = new boolean[n][n];
    solve(0, 0, m, n, "", visited, result);
    return result;
  }

  static void solve(int row, int col, int[][] m, int n, String path, boolean[][] visited, ArrayList<String> result) {
    if (row == n - 1 && col == n - 1) {
      result.add(path);
      return;
    }

    int[] dr = { 1, 0, 0, -1 };
    int[] dc = { 0, -1, 1, 0 };

    char[] dir = { 'D', 'L', 'R', 'U' };

    for (int i = 0; i < 4; i++) {
      int nr = row + dr[i];
      int nc = col + dc[i];
      if (nr >= 0 && nc >= 0 && nr < n && nc < n && visited[nr][nc] == false && m[nr][nc] == 1) {
        visited[row][col] = true;
        solve(nr, nc, m, n, path + dir[i], visited, result);
        visited[row][col] = false;
      }
    }
  }
}
