package programming.level2;

/**
 *  Created by avinashkumarmishra on 05/04/22.
 *
 *  Josephus Problem p:
 *
 **/

public class Problem4 {

    public static void main(String[] args) {

        boolean[] people = new boolean[8];
        int k = 3;

        solve(people, 0, 0, 3);

        for(int i = 0; i < people.length; i++) {
            if(people[i] == false){
                System.out.println(i);
            }
        }

        System.out.println(solve(8, 3) );
    }


    //linear time : Best solution
    private static int solve(int n, int k) {
        if(n == 1) {
            return 0;
        }

        int id = solve(n-1, k);

        return (id+k) % n;
    }

    private static void solve(boolean[] people, int cnt, int start, int k) {

        if(cnt == (people.length-1)) {
            return;
        }

        int i = 0;

        while(i != k) {
            if(people[start % people.length] == false) {
                i++;
                if(i == k) {
                    break;
                }
            }
            start++;
            start = start % people.length;
        }
        people[start] = true;

        solve(people, cnt+1,  (start+1) % people.length, k);
    }
}