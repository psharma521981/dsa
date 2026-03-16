package meta;

public class Battleship {
    public double getHitProbability(int R, int C, int[][] G) {

        if(G==null || G.length < R || G[0].length < C)
            return 0.0;

        int countBatteShip=0;
        for(int i=0;i<G.length;i++)
            for(int j=0;j<G[0].length;j++)
                if(G[i][j]==1)
                countBatteShip++;

        return (countBatteShip+0.0)/(G.length * G[0].length);
    }
}
