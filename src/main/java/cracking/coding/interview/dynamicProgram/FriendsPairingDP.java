package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 12/11/21.
 */
public class FriendsPairingDP {


    public static void main(String[] args) {
        System.out.print(countFriendPair(4));
    }

    public static int countFriendPair(int friends) {

        if (friends <=2)  return friends;

        int[] dp = new int[friends+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=friends; i++) {
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[friends];
    }
}
