package test;

import java.util.Scanner;

public class Tree {
	
	Node root;
	
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	Tree() { 
		root = null; 
	}

	void insert(int key) {
	root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);
		return root;
	}
	
	public Node search(Node root, int key)
	{
		if (root==null || root.key==key)
			return root;
		if (root.key > key)
			return search(root.left, key);
		return search(root.right, key);
	}
	
	public boolean search(int searchInt) {
		Node out=search(root,searchInt);
		if(out!=null) return true;
		return false;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Tree tree = new Tree();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size");
		int i=0,search, size=scanner.nextInt();
		System.out.println("Enter integer");
	    for(;i<size;i++){
	    	int num = scanner.nextInt();
			tree.insert(num);
		}
		
	    System.out.println("Enter search integer");
	    search = scanner.nextInt();
		System.out.println(tree.search(search));
	
	}
}
