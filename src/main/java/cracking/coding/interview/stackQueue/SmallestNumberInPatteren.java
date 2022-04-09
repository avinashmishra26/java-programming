package cracking.coding.interview.stackQueue;

import java.util.Stack;

public class SmallestNumberInPatteren {

    public static void main(String[] args) {

        getpatteren("iddiidd");


       myMethod("iddiiddd");
    }

    //my-method
    private static int[] myMethod(String pattern) {

        int[] res = new int[pattern.length()+1];
        int arrIdx = 0;

        Stack<Integer> stk = new Stack();


        int num = 1;

        for(int i = 0; i < pattern.length(); i++) {

            if( i > 0 && pattern.charAt(i) == 'i' && pattern.charAt(i-1) == 'd') {
                stk.push(num);
                num++;

                while(stk.size() > 0) {
                    res[arrIdx] = stk.pop();
                    arrIdx++;
                }

            }
            if(pattern.charAt(i) == 'i' && res[i] == 0) {
                res[i] = num;
                num++;
                arrIdx++;
            } else if(pattern.charAt(i) == 'd'){
                stk.push(num);
                num++;
            }

        }

        if(stk.size() > 0) {
            stk.push(num);
            num++;
            while(stk.size() > 0) {
                res[arrIdx] = stk.pop();
                arrIdx++;
            }
        }

        if(pattern.charAt(pattern.length()-1) == 'i') {
            res[arrIdx] = num;
        }

        return res;

    }

    private static void getpatteren(String pattern) {

        int num = 1;

        Stack<Integer> ind = new Stack();


        for(int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            if(ch == 'd') {
                ind.push(num);
                num++;
            } else {
                ind.push(num);
                num++;

                while(ind.size() > 0) {
                    System.out.print(ind.pop()+" ");
                }
            }

        }
        ind.push(num);
        while(ind.size() > 0) {
            System.out.print(ind.pop()+ " ");
        }

    }
}