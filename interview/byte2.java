package interview;

import java.util.Scanner;

public class byte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(m*n==0) {
            System.out.println(0);
            return;
        }
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if( grid[i][j]==1 ){
                    count++;
                    grid[i][j] = 0;   //置0， 下次不用考虑
                    search(grid,i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void search(int[][] grid, int i, int j){
        if( i>0 && grid[i-1][j]==1) {
            grid[i-1][j] = 0;     //置0， 下次不用考虑
            search(grid, i - 1, j);
        }
        if( j>0 && grid[i][j-1]==1) {
            grid[i][j-1] = 0;
            search(grid, i, j-1);
        }
        if( i+1<grid.length && grid[i+1][j]==1) {
            grid[i+1][j] = 0;
            search(grid, i + 1, j);
        }
        if( j+1<grid[0].length && grid[i][j+1]==1) {
            grid[i][j+1] = 0;
            search(grid, i, j+1);
        }
        if( i>0 && j>0 && grid[i-1][j-1]==1){
            grid[i-1][j-1] = 0;
            search(grid, i-1, j-1);
        }
        if( i+1<grid.length && j+1<grid[0].length && grid[i+1][j+1]==1){
            grid[i+1][j+1] = 0;
            search(grid, i+1, j+1);
        }
        if( i>0 && j+1<grid[0].length && grid[i-1][j+1]==1){
            grid[i-1][j+1] = 0;
            search(grid, i-1, j+1);
        }
        if( i+1<grid.length && j>0 && grid[i+1][j-1]==1){
            grid[i+1][j-1] = 0;
            search(grid, i+1, j-1);
        }
        return;
    }
}
