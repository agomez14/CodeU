
public class AncestorDatabase {
	class AncestorTree{
		private Person root;
		
		public AncestorTree(){
			root = null;
		}
		
		public void addPerson(String child){
			addPerson(child, "UNKNOWN", "UNKNOWN");
		}
		
		private void addPerson(Person start,Person newMember){
			if(newMember.name.equals(start.father.name)){
				start.father = newMember;
			}
			else if(newMember.name.equals(start.mother.name)){
				start.mother = newMember;
			}else{
				addPerson(start.father, newMember);
				addPerson(start.mother, newMember);
			}
		}
		
		public void addPerson(String childName, String motherName, String fatherName){
			if(root == null){
				Person mother = new Person(motherName);
				Person father = new Person(fatherName);
				root = new Person(childName, mother, father);
			}else{
				Person mother = new Person(motherName);
				Person father = new Person(fatherName);
				Person newMember = new Person(childName,mother,father);
				addPerson(root,newMember);
			}
		}
		
		public int isAncestor(String descendentName, String ancestorName){
			Person start = findPerson(root,descendentName);
			if(findPerson(root, descendentName)==null || findPerson(root, ancestorName)==null){
				return -1;
			}
			return isAncestor(start, ancestorName);
		}
		
		private int isAncestor(Person start, String ancestorName){
			int generationsCount = 0;
			if(start==null){
				return -1;
			}
			if(start.father.name.equals(ancestorName) || start.mother.name.equals(ancestorName)){
				generationsCount++;
			}else{
				generationsCount += isAncestor(start.father, ancestorName)+1;
				if(generationsCount==0){
					generationsCount += isAncestor(start.mother, ancestorName)+1;
				}
			}
			return generationsCount;
		}
		
		public int isDescendent(String ancestorName, String descendentName){
			return isAncestor(descendentName, ancestorName);
		}
		
		private Person findPerson(Person start,String name){
			Person result = null;
			if(start==null){
				return result;
			}
			if(start.name.equals(name)){
				result = start;
			}else{
				result = findPerson(start.father, name);
				if(result==null){
					result = findPerson(start.mother, name);
				}
			}
			return result;
		}
		
		private String listRelationship(Person start, String ancestorName){
			String result = "";
			if(start==null){
				result = "Relationship does not exist.";
			}
			if(start.name.equals(ancestorName)){
				return start.name;
			}else{
				result += listRelationship(start.father, ancestorName);
				if(result.length()>0){
					result += "->"+start.name;
				}else{
					result += listRelationship(start.mother, ancestorName);
					if(result.length()>0){
						result += "->"+start.name;
					}
				}
			}
			
			return result;
		}
		
		public String listRelationship(String descendentName, String ancestorName){
			if(isAncestor(descendentName, ancestorName)<0){
				return "Relationship does not exist.";
			}else{
				return listRelationship(findPerson(root, descendentName), ancestorName);
			}
		}
	}
	
	public static class AncestorTest{
		private static int failCount, successCount;
		
		public static void init(){
			successCount = 0;
			failCount = 0;
		}
		
		public static void expectFalse(int expected, int result){
			if(expected==result){
				successCount++;
			}else{
				failCount++;
			}
		}
		
		public static void expectTrue(int expected, int result){
			if(expected==result){
				successCount++;
			}else{
				failCount++;
			}
		}
		
		public static void expectTrue(String expected, String result){
			if(expected.equals(result)){
				successCount++;
			}else{
				failCount++;
			}
		}
		
		public static void expectFalse(String expected, String result){
			if(!(expected.equals(result))){
				successCount++;
			}else{
				failCount++;
			}
		}
		
		 public static void reportSummary() {
	            if (successCount == 0) {
	                System.out.println("Summary: all " + failCount +
	                                   " tests FAILED!");
	            } else if (failCount == 0) {
	                System.out.println("Summary: all " + successCount +
	                                   " tests SUCCEEDED!");
	            } else {
	                System.out.println("Summary: " + successCount +
	                                   " tests succeeded, " + failCount +
	                                   " tests failed.");
	            }
	        }
	}
		
	class Person{
		private String name;
		private Person mother, father;
		
		Person(String name){
			this.name = name;
			this.mother = null;
			this.father = null;
		}
		
		Person(String individual, Person mother, Person father){
			this.name = individual;
			this.mother = mother;
			this.father = father;
		}
	}
	
	public static void main(String[] args) {
		AncestorTest.init();
		
		AncestorDatabase database1 = new AncestorDatabase();
		AncestorDatabase.AncestorTree tree1 = database1.new AncestorTree();
		tree1.addPerson("John", "Mary", "Jack");
		tree1.addPerson("Jack", "Martha", "Fred");
		AncestorTest.expectTrue(2, tree1.isAncestor("John", "Martha"));
		AncestorTest.expectTrue(1, tree1.isDescendent("Jack", "John"));
		AncestorTest.expectFalse(-1, tree1.isAncestor("John", "Butch"));
		AncestorTest.expectTrue("Fred->Jack->John", tree1.listRelationship("John","Fred"));
		AncestorTest.reportSummary();
	}

}