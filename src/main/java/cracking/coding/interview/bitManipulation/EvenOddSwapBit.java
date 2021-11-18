package cracking.coding.interview.bitManipulation;

/**
 * Created by avinashkumarmishra on 10/11/21.
 */
public class EvenOddSwapBit {


    public static void main(String[] args) {

        int n = 5;

        int evenMask = 0xAAAAAAAA;

        int oddMask = 0x55555555;

        int even_shift = (n & evenMask ) >> 1;

        int odd_shift = (n & oddMask ) << 1;

        System.out.print(even_shift | odd_shift);
    }
}
