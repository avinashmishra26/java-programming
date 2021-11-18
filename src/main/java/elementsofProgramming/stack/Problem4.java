package elementsofProgramming.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 04/10/21.
 * NORMALIZE PATHNAMES
 */
public class Problem4 {

    public static void main(String[] args) {
        System.out.print(shortestEquivalentPath("sc//./../tc/awk/././"));
    }

    public static String shortestEquivalentPath(String path) {

        if (path.isEmpty()) {
            throw new IllegalArgumentException("Empty string is not a valid path");
        }

        Deque<String> pathNames = new LinkedList<>();

        if(path.startsWith("/")) {
            pathNames.addFirst("/");
        }

        for ( String token : path.split("/")) {

            if ( token.equals("..")) {
                if(pathNames.isEmpty() || pathNames.peekFirst().equals("..")){
                    pathNames.addFirst(token);
                } else {
                    if (pathNames.peekFirst().equals("/")) {
                        throw new IllegalArgumentException("Trying to go up root");
                    }

                }
            } else if (!token.equals(".") && !token.isEmpty()) {
                pathNames.addFirst(token);
            }
        }

        StringBuilder result = new StringBuilder();
        if(!pathNames.isEmpty()){
            Iterator<String> it = pathNames.descendingIterator();
            String prev = it.next();
            result.append(prev);
            while(it.hasNext()) {
                if(!prev.equals("/")) {
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        }

        return result.toString();
    }

}
