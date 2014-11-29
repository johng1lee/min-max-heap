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
	    if(heapSize<3){
		    if(heap.get(1)>element){
			heap.add(heap.get(1));
			heap.set(1,element);
		    }
		    else{
			heap.add(element);
		    }
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
	int deletedItem=0;
	if(heapSize<1){
	    System.out.println("Heap doesn't exist");
	    return deletedItem;
	}
	else if(heapSize < 2){
	    deletedItem = heap.remove(1);
	    System.out.println("Deleted " + deletedItem);
	    System.out.println(heapSize);
	    heapSize--;
	    return deletedItem;
	}
	else{
	    deletedItem = heap.get(1);
	    System.out.println("Deleted " + deletedItem);
	    percolateDownMin(1);
	    return deletedItem;
	}

    }
    private void percolateDownMin(int vacantPosition){ // FINISH THIS
	int gChild;
	int tmp = heap.remove(heapSize);
	int minimumValue;
	int minimumIndex;
	int startIndex;
	int endIndex;
	int parent;
	int swapVal;
	heapSize--;
	while(vacantPosition*4 <= heapSize){
	    gChild = vacantPosition*4;
	    if(gChild != heapSize){
		minimumIndex = gChild;
		minimumValue = heap.get(gChild);
		endIndex = gChild+3;
		while(gChild <= endIndex && gChild <= heapSize){
		    if (heap.get(gChild) < minimumValue){
			minimumIndex = gChild;
			minimumValue = heap.get(gChild);
		    }
		    gChild++;
		}
		gChild = minimumIndex;
	    }
	    if(heap.get(gChild).compareTo(tmp)<0){
		heap.set(vacantPosition,heap.get(gChild));
		//		printMinMaxHeap(); // print!
		vacantPosition = gChild;
		parent = gChild/2;
		swapVal = heap.get(parent);
		if(swapVal<tmp){
		    heap.set(parent,tmp);
		    //		    printMinMaxHeap(); //PRINT
		    tmp = swapVal;
		}
	    }
	    else{
		heap.set(vacantPosition, tmp);
		//		printMinMaxHeap(); //PRINT
		break;
	    }
	    vacantPosition = gChild;
	}
	heap.set(vacantPosition, tmp);
	//	printMinMaxHeap(); //PRINT
	if(vacantPosition*2 <= heapSize){
	    int minChildIndex = vacantPosition*2;
	    int minChild = heap.get(vacantPosition*2);
	    if(minChildIndex+1 <= heapSize){
		int testChild = heap.get(minChildIndex+1);
		if(minChild > testChild){
		    minChild = testChild;
		    minChildIndex = minChildIndex+1;
		}
	    }
	    if(heap.get(vacantPosition) > heap.get(minChildIndex)){
		int swapChild = heap.get(vacantPosition);
		heap.set(vacantPosition, minChild);
		heap.set(minChildIndex, swapChild);
		//		printMinMaxHeap(); //PRINT
	    }
	}
    }

    public int deleteMax(){
	int deletedItem=0;
	if(heapSize<1){
	    System.out.println("Heap doesn't exist");
	    return deletedItem;
	}
	else if(heapSize < 2){
	    deletedItem = heap.remove(1);
	    System.out.println("Deleted " + deletedItem);
	    heapSize--;
	    return deletedItem;
	}
	else if(heapSize < 3){
	    deletedItem = heap.remove(2);
	    System.out.println("Deleted " + deletedItem);
	    heapSize--;
	    return deletedItem;
	}
	else if(heapSize < 4){
	    int lChild = heap.get(2);
	    int rChild = heap.get(3);
	    int root;
	    root=lChild>rChild ?2:3;
	    deletedItem = heap.remove(root);
	    heapSize--;
	    System.out.println("Deleted " + deletedItem);
	    return deletedItem;
	}
	else{
	    int lChild = heap.get(2);
	    int rChild = heap.get(3);
	    int root;
	    root=lChild>rChild ?2:3;
	    deletedItem = heap.get(root);
	    System.out.println("Deleted " + deletedItem);
	    percolateDownMax(root);
	    return deletedItem;
	}
    }
    private void percolateDownMax(int vacantPosition){ // FINISH THIS
	int gChild;
	int tmp = heap.remove(heapSize);
	int maximumValue;
	int maximumIndex;
	int startIndex;
	int endIndex;
	int parent;
	int swapVal;
	heapSize--;
	while(vacantPosition*4 <= heapSize){
	    gChild = vacantPosition*4;
	    if(gChild != heapSize){
		maximumIndex = gChild;
		maximumValue = heap.get(gChild);
		endIndex = gChild+3;
		while(gChild <= endIndex && gChild <= heapSize){

		    if (heap.get(gChild) > maximumValue){
			maximumIndex = gChild;
			maximumValue = heap.get(gChild);
		    }
		    gChild++;
		}
		gChild = maximumIndex;
	    }
	    if(heap.get(gChild).compareTo(tmp)>0){
		heap.set(vacantPosition,heap.get(gChild));
		//		printMinMaxHeap(); // print!
		vacantPosition = gChild;
		parent = gChild/2;
		swapVal = heap.get(parent);
		if(swapVal>tmp){
		    heap.set(parent,tmp);
		    //		    printMinMaxHeap(); //PRINT
		    tmp = swapVal;
		}
	    }
	    else{
		heap.set(vacantPosition, tmp);
		//		printMinMaxHeap(); //PRINT
		break;
	    }
	    vacantPosition = gChild;
	}
	heap.set(vacantPosition, tmp);
	//	printMinMaxHeap(); //PRINT
	if(vacantPosition*2 <= heapSize){
	    int maxChildIndex = vacantPosition*2;
	    int maxChild = heap.get(vacantPosition*2);
	    if(maxChildIndex+1 <= heapSize){
		int testChild = heap.get(maxChildIndex+1);
		if(maxChild > testChild){
		    maxChild = testChild;
		    maxChildIndex = maxChildIndex+1;
		}
	    }
	    if(heap.get(vacantPosition) < heap.get(maxChildIndex)){
		int swapChild = heap.get(vacantPosition);
		heap.set(vacantPosition, maxChild);
		heap.set(maxChildIndex, swapChild);
		//		printMinMaxHeap(); //PRINT
	    }
	}
    }

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
		    System.out.print(" ");
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
    public static void main(String[] args){
	try{
	    MinMaxHeap heap = new MinMaxHeap();
	    String instruction = "";
	    Scanner inputFileScanner = new Scanner(new File(args[0]));
	    while(inputFileScanner.hasNextLine()){
		instruction = inputFileScanner.nextLine();
		//		System.out.print("\n###" + instruction + "###\n");
		int instructionLength = instruction.length();
		if(instruction.contains("buildMinMaxHeap")){
		    String[] heapInitialValuesString = instruction.substring(
									     instruction.indexOf(":")+1,
									     instructionLength
									     ).split(",");
		    int heapInitialValuesLength = heapInitialValuesString.length;
		    int[] heapInitialValuesInt = new int[heapInitialValuesLength];
		    for(int i=0; i<heapInitialValuesLength; i++){
			heapInitialValuesInt[i] = Integer.valueOf(heapInitialValuesString[i].trim());
			// System.out.println(heapInitialValuesInt[i]);
		    }
		    heap.buildMinMaxHeap(heapInitialValuesInt);
		}
		else if(instruction.contains("peekMin")){
		    heap.peekMin();
		}
		else if(instruction.contains("peekMax")){
		    heap.peekMax();
		}
		else if(instruction.contains("insert")){
		    instruction = instruction.substring(6,instructionLength).trim();
		    int element = Integer.valueOf(instruction);
		    heap.insert(element);
		}
		else if(instruction.contains("deleteMin")){
		    heap.deleteMin();
		}
		else if(instruction.contains("deleteMax")){
		    heap.deleteMax();
		}
		else if(instruction.contains("printMinMaxHeap")){
		    heap.printMinMaxHeap();
		}
	    }
	}
	catch(FileNotFoundException fNFE){
	    fNFE.printStackTrace();
	}
	catch(Exception e){
	    e.printStackTrace();
	}
    }

}
