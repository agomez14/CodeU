public class Filter {
    // Write a function named "evens" that takes as input an array of
    // ints and returns a different array of ints containing
    // only the even elements of the input.
    public static int[] evens(int[] input) {
        int inputLength = input.length;
        int evenCount = 0;
        for(int i=0; i<inputLength; i++){
        	if(input[i]%2==0){
        		evenCount++;
        	}
        }
        int[] evenInput = new int[evenCount];
        int fullCount = 0;
        for(int x=0; x<inputLength; x++){
        	if(fullCount<evenCount){
        		if(input[x]%2==0){
        			evenInput[fullCount]=input[x];
        			fullCount++;
        		}
        	}
        }
        
        return evenInput;
    }
    public static void main(String[] args) { //
        // Expected output:
        // test1 results:
        // 8
        // 6
        // 0
        // test2 results:
        // 2
        // 18
        // 28
        // 18
        // 28
        // 90
        // //STUDENTS, ADD ADDITIONAL TEST CASES BELOW
        int[] test1 = {8, 6, 7, 5, 3, 0, 9};
        int[] ans = evens(test1);
        System.out.println("test1results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
        int[] test2 = {2, 7, 18, 28, 18, 28, 45, 90, 45};
        ans = evens(test2);
        System.out.println("test2results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
        int[] test3 = {100,4,13,6,58,31,100048572};
        ans = evens(test3);
        System.out.println("test3results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
    }
}
