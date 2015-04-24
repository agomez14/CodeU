import java.util.ArrayList;
import java.util.List;


public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree(){
		root = null;
	}
	public BinaryTree(String payload){
		root = new BinaryTreeNode(payload);
	}
	
	public List<String> flatten(BinaryTreeNode start){
		List<String> result = new ArrayList<String>();
		if(start==null){
			return null;
		}
		if(start.leftChild!=null){
			result.addAll(flatten(start.leftChild));
		}
		if(start.rightChild!=null){
			result.add(start.payload);
			result.addAll(flatten(start.rightChild));
		}
		else{
			result.add(start.payload);
		}
			
		return result;
	}
	
	private void insertRefine(BinaryTreeNode parent, BinaryTreeNode newNode){
		if(newNode.payload.compareTo(parent.payload)<0){
			if(parent.leftChild == null){
				parent.leftChild = newNode;
				return;
			}else{
				insertRefine(parent.leftChild, newNode);
			}
		}else{
			if(parent.rightChild == null){
				parent.rightChild = newNode;
				return;
			}else{
				insertRefine(parent.rightChild, newNode);
			}
		}
	}
	
	public void insert(String payload){
		BinaryTreeNode newNode = new BinaryTreeNode(payload);
		if(root==null){
			root = newNode;
			return;
		}else{
			insertRefine(root, newNode);
		}
	}
	
	class BinaryTreeNode{
		private BinaryTreeNode leftChild, rightChild;
		private String payload;
		
		public BinaryTreeNode(String payload){
			this.payload = payload;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	public static void main(String[] args) {
		BinaryTree test1 = new BinaryTree();
		test1.insert("5");
		test1.insert("3");
		test1.insert("9");
		test1.insert("1");
		test1.insert("4");
		test1.insert("6");
		test1.insert("10");
		List flat1 = new ArrayList();
		flat1 = test1.flatten(test1.root);
		for(int i=0; i<flat1.size(); i++){
			System.out.print(flat1.get(i)+" ");
		}
		System.out.println();
		
		BinaryTree test2 = new BinaryTree();
		test2.insert("hello");
		List flat2 = new ArrayList();
		flat2 = test2.flatten(test2.root);
		for(int i=0; i<flat2.size(); i++){
			System.out.print(flat2.get(i)+" ");
		}
		
	}

}
