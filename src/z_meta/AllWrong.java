package meta;

public class AllWrong {
    /*
    N = 3
C = ABA
Expected Return Value = BAB

N = 5
C = BBBBB

Expected Return Value = AAAAA
     */
    public String getWrongAnswers(int N, String C) {
        // Write your code here
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++) {
            if(C.charAt(i) == 'A')
                sb.append('B');
            else
                sb.append('A');
        }

        return sb.toString();
    }
}
