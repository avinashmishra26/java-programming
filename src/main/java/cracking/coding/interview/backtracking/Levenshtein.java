package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 07/11/21.
 */
public class Levenshtein {

    public static void main(String[] args) {
        System.out.print(getLevenshteinDistance("carthorse", 0, "orchestra", 0));
    }

    
    private static int getLevenshteinDistance(String source, int sourceIdx, String destination, int destinationIdx ) {

        if(destinationIdx == destination.length() && sourceIdx == source.length()){
            return 0;
        } else if(destinationIdx == destination.length()){
            return source.length() - sourceIdx;
        } else if(sourceIdx == source.length()){
            return destination.length() - destinationIdx;
        }

        if(source.charAt(sourceIdx) == destination.charAt(destinationIdx)) {
            return getLevenshteinDistance(source, sourceIdx+1, destination, destinationIdx+1);
        } else {
            //Delete
            return (1 + Math.min(Math.min(getLevenshteinDistance(source, sourceIdx + 1, destination, destinationIdx),
                    //insert
                    getLevenshteinDistance(source, sourceIdx, destination, destinationIdx + 1)),
                    //substitute
                    getLevenshteinDistance(source, sourceIdx + 1, destination, destinationIdx + 1)));

        }

    }
}
