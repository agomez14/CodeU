import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FilterList {
    // Write a function named "evens" that takes as input a
    // list of Integer (almost but not quite int) and returns
    // a new list of ints containing only the even elements
    // of the input.
    public static List<Integer> evens(List<Integer> input) {
        List<Integer> result = new ArrayList<Integer>();
        for(Integer n: input){
        	if(n.intValue()%2==0){
        		result.add(Integer.valueOf(n));
        	}
        }
    	return result;
    	// Here are some reminders:
        //
        // You can find input's length using input.size().
        //
        // You can find the remainder of a division using %. For instance,
        // 2 == 11%3 and 1 == 25 % 4.
        //
        // You can declare a new list named "clown" of length n with the
        // syntax:
        //
        // List<Integer> clown = new ArrayList<Integer>(10);

        // STUDENTS, WRITE CODE HERE.
    }

    public static void main(String[] args) {
        List<Integer> test1 =
            new ArrayList<Integer>(Arrays.asList(8,6,7,5,3,0,9));
        List<Integer> ans = evens(test1);
        // Expected output: 8, 6, 0
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        List<Integer> test2 =
            new ArrayList<Integer>(Arrays.asList(2,7,18,28,18,28,45,90,45));
        ans = evens(test2);
        // Expected output: 2, 18, 28, 18, 28, 90
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();
        
        List<Integer> test3 = new ArrayList<Integer>();
        ans = evens(test3);
        for (Integer n: ans) {
        	System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();
        
        List<Integer> test4 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,11));
        ans = evens(test4);
        for (Integer n: ans) {
        	System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();
        
        // STUDENTS: ADD YOUR TEST CASES HERE.
    }
}