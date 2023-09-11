import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                         { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                         { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                         { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                         { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                         { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                         { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                         { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                         { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

        solve(maze);
    }

    static void printPath(ArrayList<int[]> path) {
        for (int pat[] : path) {
            System.out.print("(" + pat[0] + " " + pat[1] + ")->");
        }
        System.out.println();
    }

    static void solve(int maze[][]) {
        int m = maze.length;
        int n = maze[0].length;
        int vis[][] = new int[m][n];
        int corners[][] = { { 0, 0 }, { 0, n - 1 }, { m - 1, 0 }, { m - 1, n - 1 } };

        for (int i = 0; i < 4; i++) {
            ArrayList<int[]> path = new ArrayList<>();
            vis[corners[i][0]][corners[i][1]] = 1;
            path.add(new int[] { corners[i][0], corners[i][1] });
            helper(corners[i][0], corners[i][1], m, n, maze, vis, path);
            vis[corners[i][0]][corners[i][1]] = 0;
        }
    }

    static void helper(int row, int col, int m, int n, int maze[][], int vis[][], ArrayList<int[]> path) {
        if (row == m / 2 && col == n / 2) {
            printPath(path);
            return;
        }
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
        int val=maze[row][col];
        for (int k = 0; k < 4; k++) {
            int nRow = row + dx[k]*val;
            int nCol = col + dy[k]*val;
            if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && vis[nRow][nCol] == 0) {
                vis[nRow][nCol] = 1;
                path.add(new int[] { nRow, nCol });
                helper(nRow, nCol, m, n, maze, vis, path);
                vis[nRow][nCol] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
}
