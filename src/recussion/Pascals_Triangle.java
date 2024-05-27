package recussion;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {

    static List<List<Integer>> pascalTriangel = new ArrayList<>();
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        // TODO: Write your code here
        pascalTriangle(1,numRows);

        return pascalTriangel;
    }

    private static void pascalTriangle(int counter, int numRows) {

        if(counter > numRows)
            return;

        if(counter == 1) {
            List<Integer> row= new ArrayList<>();
            row.add(1);
            pascalTriangel.add(0,row);
        } else if(counter == 2) {
            List<Integer> row= new ArrayList<>();
            row.add(0,1);
            row.add(1,1);
            pascalTriangel.add(1,row);
        } else {
            List<Integer> row= new ArrayList<>();
            row.add(0,1);
            List<Integer> temp = pascalTriangel.get(counter-2);
            for(int i=1;i<counter-1;i++) {
                row.add(i,temp.get(i-1)+temp.get(i));
            }
            row.add(counter-1,1);
            pascalTriangel.add(counter-1,row);
        }
        pascalTriangle(++counter,numRows);
    }

    public static void main(String[] args) {
        int numRows = 2;
        List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
