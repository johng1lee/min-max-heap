import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class MinMaxHeap{
    private ArrayList<Integer> heap;
    private int heapSize;
    public MinMaxHeap(){
	heap = new ArrayList<Integer>();
	heap.add(null);
	heapSize = 0;
    }

    public void insert(int element){
	if(heapSize == 0){
	    heap.add(element);
	    heapSize++;
	}

	else{
	    int addPosition = heapSize + 1;
	    insertHelper(addPosition,element);
	    heapSize++;
	}
    }
    private void insertHelper(int addPosition, int element){
	int currentHeapLevel = getHeapLevel(addPosition);
	//recursive function to complete the insert function
	if(currentHeapLevel < 2){
	    if(heapSize<4){
		heap.add(element);
	    }
	    else{
		heap.set(addPosition, element);
	    }
	    return;
	}
	else{
	    int parent = addPosition/2;
	    int gParent = addPosition/4;
	    heap.add(0);
	    if(currentHeapLevel % 2 == 0){ //even
		if(heap.get(parent) < element){
		    //swap current spot with parent 
		    //recursively call insert with new current spot
		    heap.set(addPosition,heap.get(parent));
		    addPosition = addPosition/2;
		    insertHelper(addPosition,element);
		}
		else if(heap.get(gParent) > element){
		    //swap current spot with gParent
		    //recursively call insert with new current spot
		    heap.set(addPosition,heap.get(gParent));
		    addPosition = addPosition/4;
		    insertHelper(addPosition,element);
		}
		else{
		    //insert normally
		    heap.set(addPosition,element);
		}
	    }
	    else{ //odd
		if(heap.get(parent) > element){
		    //swap current spot with parent 
		    //recursively call insert with new current spot
		    heap.set(addPosition,heap.get(parent));
		    addPosition = addPosition/2;
		    insertHelper(addPosition,element);
		}
		else if(heap.get(gParent) < element){
		    //swap current spot with gParent
		    //recursively call insert with new current spot
		    heap.set(addPosition, heap.get(gParent));
		    addPosition = addPosition/4;
		    insertHelper(addPosition,element);
		}
		else{
		    //insert normally
		    heap.set(addPosition,element);
		}
	    }
	}
    }
    private int getHeapLevel(int addPosition){
	int numLevels = 0;
	addPosition = addPosition / 2;
	while(addPosition > 0){
	    addPosition = addPosition / 2;
	    numLevels++;
	}
	return numLevels;
    }
    public void buildMinMaxHeap(int[] initialValues){
	for(int i=0; i<initialValues.length; i++){
	    insert(initialValues[i]);
	}
    }
    public int deleteMin(){
	if(heapSize<1){
	    System.out.println("Heap doesn't exist");
	}
	percolateDown(1);
    }
    private void percolateDown(int vacantPosition){
	int child;
	int tmp = heap.remove(heap.size()-1);
    }
    public int deleteMax(){return 0;}
    public void printMinMaxHeap(){
	int counter = 1;
	long twoExp = 2;
	long limit = 3;
	if(heapSize < 1){return;}
	else{
	    System.out.println(heap.get(counter));
	    counter++;
	    while(counter <= heapSize){
		System.out.print(heap.get(counter));
		counter++;
		if(counter > limit){
		    System.out.println("");
		    twoExp = twoExp * 2;
		    limit = limit + twoExp;
		}
		else{
		    System.out.print(", ");
		}
	    }
	}
	System.out.println("");
    }

    public int peekMin(){
	if(heapSize <= 0){
	    System.err.println("Heap is empty");
	    return 0;
	}
	else{
	    
	    System.out.printf("The minimum is %d\n",heap.get(1));
	    return heap.get(1);
	}
    }
    public int peekMax(){
	if(heapSize < 2){
	    System.err.println("Heap does not have a max");
	    return 0;
	}
	else if(heapSize < 3){
	    System.out.printf("The maximum is %d\n",heap.get(2));
	    System.out.println(heap.get(2));
	    return heap.get(2);
	}
	else{
	    int left = heap.get(2);
	    int right = heap.get(3);
	    if(left < right){
	    System.out.printf("The maximum is %d\n",right);
		return right;
	    }
	    else{
	    System.out.printf("The maximum is %d\n",left);
		return left;
	    }
	}
    }
}
