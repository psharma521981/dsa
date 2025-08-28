package recussion;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_1 {

    static List<List<Integer>> pascalTriangel = new ArrayList<>();
    public static List<List<Integer>> generatePascalTriangle(int numRows) {

        if(numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            pascalTriangel.add(0,row);
            return pascalTriangel;
        }
        if(numRows == 2) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            row.add(1);
            pascalTriangel.add(1,row);
            return pascalTriangel;
        }

        List<List<Integer>> pascalTriangel = generatePascalTriangle(numRows-1);
        List<Integer> previousRow = pascalTriangel.get(numRows-2);

        return pascalTriangel;
    }


    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
