package elementsofProgramming.greedy;

/**
 * Created by avinashkumarmishra on 11/10/21.
 */
public class Problem6_GasUp {

    public static void main(String[] args) {
        System.out.print(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));

    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int minValue = Integer.MAX_VALUE, idx = -1;
        int remainingGas = 0;

        for (int i = 0; i < gas.length; i++) {
            remainingGas += (gas[i] - cost[i]);
            if ( remainingGas < minValue) {
                minValue = remainingGas;
                idx = (i+1) % gas.length;
            }
        }
        return remainingGas >= 0? idx : -1;
    }
}
