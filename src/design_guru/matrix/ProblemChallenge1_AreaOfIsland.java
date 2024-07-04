package matrix;

public class ProblemChallenge1_AreaOfIsland {
    public int findIslandPerimeter(int[][] matrix) {

        if(matrix == null || matrix.length < 0)
            return 0;

        int irlandCount = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i < matrix.length;i++) {
            for(int j=0;j < matrix[0].length;j++) {

                if(matrix[i][j] == 1 && !visited[i][j])
                    return  countIrland(matrix,visited,i,j);
            }
        }

        return 0;
    }

    private int countIrland(int[][] matrix,boolean[][] visited,int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if((i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 0))
            return 1;

        if(visited[i][j])
            return 0;

        visited[i][j] = true;

        return  countIrland(matrix,visited,i+1,j) + countIrland(matrix,visited,i-1,j)
                + countIrland(matrix,visited,i,j + 1) + countIrland(matrix,visited,i,j-1);

    }

    public static void main(String[] args) {
        ProblemChallenge1_AreaOfIsland sol = new ProblemChallenge1_AreaOfIsland();
        System.out.println(sol.findIslandPerimeter(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(sol.findIslandPerimeter(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 1, 0, 0 }
                }));
    }
}
