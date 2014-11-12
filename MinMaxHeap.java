import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class MinMaxHeap{
    private ArrayList<Integer> heap;
    private int heapSize;
    public MinMaxHeap(){
	heap = new ArrayList<Integer>();
	heapSize = 0;
    }

    public void insert(int element){
	if(heap.size() == 0){
	    heap.add(element);
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
    public void printMinMaxHeap(){printLevels();}
    public void printLevels(){
	int counter = 0;
	long limit = 1;
	if(heap.size() < 1){return;}
	else{
	    while(counter < heap.size()){
		System.out.print(heap.get(counter));
		counter++;
		if(counter >= limit){
		    System.out.println("");
		    limit = limit + limit * 2;
		}
		else{
		    System.out.print(", ");
		}
	    }
	}
	System.out.println("");
    }

    public int peekMin(){
	if(heap.size() <= 0){
	    System.err.println("Heap is empty");
	    return 0;
	}
	else{
	    System.out.println(heap.get(0));
	    return heap.get(0);
	}
    }
    public int peekMax(){
	if(heap.size() < 1){
	    System.err.println("Heap is empty");
	    return 0;
	}
	else if(heap.size() < 2){
	    System.err.println("Heap does not have a max");
	    return 0;
	}
	else if(heap.size() < 3){
	    System.out.println(heap.get(1));
	    return heap.get(1);
	}
	else{
	    int left = heap.get(1);
	    int right = heap.get(2);
	    if(left < right){
		System.out.println(right);
		return right;
	    }
	    else{
		System.out.println(left);
		return left;
	    }
	}
    }
}
