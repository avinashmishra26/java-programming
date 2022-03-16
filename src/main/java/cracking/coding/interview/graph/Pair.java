package cracking.coding.interview.graph;

/**
 * Created by avinashkumarmishra on 18/02/22
 *
 *
 **/

public class Pair implements Comparable<Pair> {

    int wsf;
    String psf;

    public Pair(int wsf, String psf) {
        this.wsf = wsf;
        this.psf = psf;
    }

    @Override
    public int compareTo(Pair p) {
        return wsf - p.wsf;
    }

    @Override
    public String toString(){
        return "Weight so far " +wsf + " ,path so far " + psf;
    }
}