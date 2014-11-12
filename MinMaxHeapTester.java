import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class MinMaxHeapTester{
    public static void main(String[] args){
	try{
	    MinMaxHeap heap = new MinMaxHeap();
	    String instruction = "";
	    Scanner inputFileScanner = new Scanner(new File(args[0]));
	    while(inputFileScanner.hasNextLine()){
		instruction = inputFileScanner.nextLine();
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
		    heap.printLevels();
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
