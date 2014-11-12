import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class MinMaxHeap{
    private Node root;
    private int heapSize;
    private Node tmpNode;
    public MinMaxHeap(){
	root = null;
	heapSize = 0;
	tmpNode = null;
    }

    public void insert(int element){
	// root.value = element;
	// root.left = new Node(24);
	// root.right = new Node(15);
	Node elementNode = new Node(element);
	if(root == null){
	    root = elementNode;
	    heapSize++;
	}
	else if(){
	    
	}
	else{
	    int levelIndex = heapSize + 1;
	}
    }
    public void buildMinMaxHeap(int[] initialValues){
	for(int i=0; i<initialValues.length; i++){
	    insert(initialValues[i]);
	    printLevels();
	}
    }
    public int deleteMin(){return 0;}
    public int deleteMax(){return 0;}
    public void printMinMaxHeap(){}
    public void printLevels(){
	Stack<Node> nodeStack = new Stack<Node>();
	long counter = 0;
	long limit = 1;
	if(root == null){return;}
	else{
	    nodeStack.push(root);
	    while(!nodeStack.empty()){
		Node evaluateNode = (Node)nodeStack.pop();
		counter++;
		System.out.print(evaluateNode.value);
		if(counter >= limit){
		    System.out.println("");
		    limit = limit + limit * 2;
		}
		else{
		    System.out.print(", ");
		}
		if(evaluateNode.left != null){
		    nodeStack.push(evaluateNode.left);
		}
		if(evaluateNode.right != null){
		    nodeStack.push(evaluateNode.right);
		}
	    }
	}
	System.out.println("");
    }

    public int peekMin(){
	if(root == null){
	    System.err.println("Heap is empty");
	    return 0;
	}
	else{
	    System.out.println(root.value);
	    return root.value;
	}
    }
    public int peekMax(){
	Node maxNode = root.getMax(root);
	if(maxNode == null){
	    System.err.println("Heap does not have a max");
	}
	else{
	    System.out.println(maxNode.value);
	}
	return maxNode.value;
    }

    public class Node{
	public Node left = null;
	public Node right = null;
	public int value;
	public Node(){
	}
	public Node(int elementValue){
	    value = elementValue;
	}
	public Node getMax(Node parent){
	    if(parent == null){
		return null;
	    }
	    else{
		if(root.left == null && root.right == null){
		    return null;
		}
		else if(root.left == null){
		    return root.right;
		}
		else if(root.right == null){
		    return root.left;
		}
		else{
		    if(root.left.value >= root.right.value){
			return root.left;
		    }
		    else{
			return root.right;
		    }
		}
	    }
	}
    }
}
