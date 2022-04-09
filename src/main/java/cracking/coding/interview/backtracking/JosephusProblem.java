package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 23/10/21.
 * 2022
 */
public class JosephusProblem {

    public static void main(String[] args) {

        int n = 5;
        boolean[] peopleKilled = new boolean[n];
        solution(peopleKilled, 3, 0);

        for(int i =0; i< peopleKilled.length; i++) {
            if(!peopleKilled[i]) {
               System.out.print(i+1);
            }
        }
    }

    private static void solution(boolean[] peopleKilled, int k, int idx){
        if(isOnePeopleLeft(peopleKilled)){
            return;
        }

        int i = 1;
        while( i <= 3){
            idx = idx % peopleKilled.length;
            if(peopleKilled[idx] == false){
                if ( i == 3 )
                    peopleKilled[idx] = true;
                i++;
            }
            idx++;
        }

        solution(peopleKilled, k, idx);

    }

    private static boolean isOnePeopleLeft(boolean[] people) {
        int count = 0;
        for(boolean b :people) {
            if(!b) {
                count++;
            }
            if ( count > 1){
                return false;
            }
        }
        return true;
    }
}
