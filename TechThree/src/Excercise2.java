import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Excercise2 {

	public static boolean hasMajority(List input){
		int count = 0;
		int startIndex = 0;
		outer:
			for(int i=startIndex; i<input.size(); i++){
				if(!(count > ((input.size()*1.0)/2) )){
					inner:
						for(int j=i+1; j<=input.size();j++){
							if(input.get(i)==input.get(j)){
								count++;
							}else{
								if(j!=input.size()-1){
									startIndex = j;
									break inner;
								}
								break outer;
							}
						}
				}else{
					return true;
				}
			}
		return false;
	}
	
	public static void main(String[] args) {
		List<Integer> test1 = new ArrayList<Integer>();
		test1.add(5);
		test1.add(3);
		test1.add(9);
		test1.add(4);
		test1.add(3);
		test1.add(3);
		test1.add(8);
		test1.add(3);
		test1.add(3);
		Collections.sort(test1);
		System.out.println(hasMajority(test1));
		
		List<Integer> test2 = new ArrayList<Integer>();
		test2.add(5);
		test2.add(3);
		test2.add(9);
		test2.add(4);
		test2.add(3);
		test2.add(3);
		test2.add(8);
		test2.add(3);
		System.out.println(hasMajority(test2));
	}

}
