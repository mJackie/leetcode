package code;
/*
 * 542. 01 Matrix
 * 题意：0,1矩阵，每个点找离自己最近的0的距离
 * 难度：Medium
 * 分类：Depth-first Search, Breadth-first Search
 * 思路：广度优先搜索
 * Tips：
 */
import java.util.LinkedList;
import java.util.Queue;

public class lc542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> qu = new LinkedList();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    qu.add(new int[]{i,j});
                }
                else matrix[i][j]=Integer.MAX_VALUE;
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!qu.isEmpty()){
            int[] cell = qu.remove();
            for(int i=0; i<4; i++){
                int cur_row = cell[0]+dirs[i][0];
                int cur_col = cell[1]+dirs[i][1];
                if(cur_row<0||cur_row>=matrix.length||cur_col<0||cur_col>=matrix[0].length||matrix[cur_row][cur_col]<=matrix[cell[0]][cell[1]]+1) continue;
                matrix[cur_row][cur_col] = matrix[cell[0]][cell[1]]+1;
                qu.add(new int[]{cur_row,cur_col});
            }
        }
        return matrix;
    }
}
