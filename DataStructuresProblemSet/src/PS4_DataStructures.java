import java.util.ArrayList;
import java.util.HashMap;

public class PS4_DataStructures {


    static int Q1(ArrayList<Integer> listOfNumbers){
        // return the number of integers in listOfNumbers
    	

        return listOfNumbers.size();
    }

    static void Q2(ArrayList<String> input){
        // add the String "movie" to the end of the input list
    	input.add("movie");
    }

    static int Q3(ArrayList<Integer> input, int index){
        // return the element at index i from the input list
        // You can assume the input contains at least i+1 values
    	
    	
        return input.get(index);
    }

    static boolean Q4(ArrayList<Integer> input, int value){
        // return true if value is in the input list, false otherwise
    	for(int i=0; i<input.size();i++){
    		if(input.get(i).equals(value)){
    			return true;
    		}
    	}

        return false;
    }

    static String Q5(ArrayList<String> words){
        // return a string containing every word of the input concatenated into a single String and separated by spaces
        // Example: If the input is ["war", "never", "changes"] the output is "war never changes"
    	String result="";
    	for(int i=0;i<words.size()-1;i++){
    		result=result+words.get(i)+" ";
    		
    	}
    	    result=result+words.get(words.size()-1);
    	

        return result;
    }

    static ArrayList<Integer> Q6(){
        // Create and return an ArrayList of the integers 1 through 10 (including 1 and 10)
    	ArrayList<Integer> result=new ArrayList<Integer>();	
    	for(int i=0; i<10;i++){
    		result.add(i, i+1);
    		
    	}

        return result;
    }

    static ArrayList<String> Q7(){
        // create and return an ArrayList of Strings containing the strings "memory", "is", "the", "key" in that order
    	ArrayList<String> result=new ArrayList<String>();
    	String [] a={"memory", "is", "the", "key"
    			
    	};
    	for(int i=0;i<a.length;i++){
    		result.add(a [i]);	
    	}
    	
    			
    			
    	

        return result;
    }

    static void Q8(HashMap<String, Integer> input, String key, int value){
        // add an entry into the map with the the given key and value
    	input.put(key, value);

    }

    static boolean Q9(HashMap<Integer, Boolean> input, int key){
        // return the value in the input map at the given key
    	

        return input.get(key);
    }

    static boolean Q10(HashMap<String, Integer> input, int value){
        // return true if value is in the input map as a value at any key, false otherwise
    	

        return input.containsValue(value);
    }

    static int Q11(HashMap<String, Double> input){
        // return the number of entries in the input map
    	

        return input.size();
    }

    static ArrayList<Integer> Q12(HashMap<String, Integer> input){
        // return a list of all values in the input map
        // Note: input.values() returns a Collection, but you must return an ArrayList
    	ArrayList<Integer> result= new ArrayList<Integer>(input.values());
    	System.out.println(result);
    	
    	
        return result;
    }

    static ArrayList<String> Q13(HashMap<String, Integer> input){
        // return a list of all keys in the input map
        // Note: input.keySet() returns a Set, but you must return an ArrayList
    	ArrayList<String> result=new ArrayList<String>(input.keySet());

        return result;
    }

    static boolean Q14(HashMap<Integer, Integer> input, int key){
        // return true if key is a key in the input map, false otherwise
    	if(input.containsKey(key)){
    		return true;
    	}

        return false;
    }

    static int Q15(HashMap<Integer, Integer> input, int value){
        // return the number of times value is in the input map as a value
    	ArrayList<Integer> result=new ArrayList<Integer>(input.values());
    	int j=0;
    	for(Integer e: result){
    		if(e==value){
   			 j++;
   			 }
   		}
    	/*
    	   for(int e: result){
    		if(e==value){
   			 j++;
   			 }
   		}
    	 
    	 */
    		
    	
    	/*for(int i=0;i<result.size();i++){
    		if(result.get(i)==(value)){
    			 j++;
    		}
    	}*/

        return j;
    }

    public static void main(String[] args) {
    	
    	HashMap<String,Integer> c=new HashMap<String,Integer>();
    	c.put("fff", 123);
    	c.put("ddd", 456);
    	c.put("TTT", 456);
    	c.put("FFF", 456);
    	
    	System.out.println(c.size());
    	
    	
    	
    	

    }


}
