import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
public class PS6_Algorithms {



    static int Q1(ArrayList<Integer> input){
        // return the minimum value in the input ArrayList
//    	Collections.sort(input);
    	
    
    	
    	
		
    	for(int j=0;j<input.size();j++){
    		int minvalue = input.get(j);
    		int minindex=j;
    		for(int i=j+1;i<input.size();i++){
    			
    			if(minvalue>input.get(i)){
    				
    				minvalue=input.get(i);
    				minindex=i;
    			}
    			
    			
        		
    			
    		}
    		
    		input.set(minindex, input.get(j));
    		input.set(j, minvalue);
		
    		}

        return input.get(0);
    }


    static int Q2(ArrayList<Integer> input){
        // return the maximum value in the input ArrayList
    	Collections.sort(input);

        return input.get(input.size()-1);
    }


    static int Q3(ArrayList<Integer> input){
        // return the index containing the maximum value in the input ArrayList
    	int maxvalue=Integer.MIN_VALUE;
    	int index=0;
    	for(int i=0;i<input.size();i++){
    		int currence=input.get(i);
    		if(maxvalue<currence){
    			maxvalue=currence;
    			index=i;
    			
    		}
    	}
    	
    	

        return index;
    }


    static double Q4(ArrayList<Integer> input){
        // return the average of all the values in the input ArrayList
    	double sum=0;
    	for(double e:input){
    		sum+=e;
    	}

        return sum/input.size();
    }


    static String Q5(HashMap<String, Integer> input){
        // return the key corresponding to the maximum value in the input HashMap
    	int maxvalue=Integer.MIN_VALUE;
    	String key=null;
    	for(Map.Entry<String, Integer> e :input.entrySet()){
    		if(maxvalue<e.getValue()){
    			maxvalue=e.getValue();
    			key=e.getKey();
    		}
    	}
    	

        return key;
    }


    static double Q6(ArrayList<Double> input){
        // return the range (max - min) of the values in the input ArrayList
    	Collections.sort(input);

        return input.get(input.size()-1)-input.get(0);
    }


    static double Q7(ArrayList<Double> input){
        // Return the rate of change of the values of the input ArrayList. The rate of change is computed with the
        // first and last element of the list using the following formula: (last - first)/first
        //
        // Note: This is similar to computing ROI in hw2
    	
    	

        return (input.get(input.size()-1)-input.get(0))/input.get(0);
    }


    static int Q8(ArrayList<Integer> input){
        // Return the 2nd highest value in the input ArrayList
    	Q1(input);
    	int index=input.size()-2;
    	while (input.get(index)==input.get(index+1)){
    		index--;
    	}
    	
    	

        return input.get(index);
    }


    static int Q9(ArrayList<ArrayList<Integer>> input){
        // Return the minimum value in the input list of lists (matrix)
    	int min=Integer.MAX_VALUE;
    	for(ArrayList<Integer> e:input){
    		Q1(e);
    		
    			min=min>e.get(0)?e.get(0):min;
    		
    		
    	}

        return min;
    }


    static String Q10(ArrayList<String> input){
        // return the longest String in the input ArrayList. Ties can be broken arbitrarily
//    	Collections.sort(input);
    	String result=null;
    	int maxlength=-1;
    	
    	for(String e:input){
    		if(e.length()>maxlength){
    			maxlength=e.length();
    			result=e;
    			
    		
    		}
    	}
    	

        return result;
    }


    static double Q11(ArrayList<Integer> input1, ArrayList<Integer> input2){
        // return the average of all the values in both input ArrayLists
    	double sum=0;
    	for(double e:input1){
    		sum+=e;
    	}
    	for(double e:input2){
    		sum+=e;
    	}
    	
    	
    	

        return sum/(input1.size()+input2.size());
    }


    static double Q12(HashMap<String, ArrayList<Double>> input){
        // return the maximum value contained in any of the ArrayLists in the input HashMap.
    	double maximumvalue=Double.MIN_VALUE;
    	for(ArrayList<Double> e:input.values()){
    		Collections.sort(e);
    		
    		maximumvalue=maximumvalue<e.get(e.size()-1)?e.get(e.size()-1):maximumvalue;
    		

    		
    	}


        return maximumvalue;
    }


    static void Q13(ArrayList<Integer> input){
        // sort the input ArrayList in increasing order
    	Collections.sort(input);

    }


    static double Q14(ArrayList<Integer> input){
        // return the median value of the input ArrayList. If the size is even, return the average of the two
        // elements closests to the median
    	Q1(input);
    	
    	if(input.size()%2==0){
    		return (input.get(input.size()/2-1)+input.get(input.size()/2))/2.0;
    		
    	}

         return input.get(input.size()/2);
    }


    static int Q15(ArrayList<Integer> input){
        // return the mode value of the input ArrayList. Ties can be broken arbitrarily
    	int maxtime=0;
    	int result=0;
    	
    	
    	for(int e:input){
    		int time=0;
    		for(int e2:input){
    			if(e==e2){
    				time++;
 
    			}
    			
    			
    		}
    		if(maxtime<time){
    			result=e;
    			maxtime=time;
    			
			}
    	}

        return result;
    }


    public static void main(String[] args) {
    	ArrayList<Integer> input=new ArrayList<Integer>();
    	input.add(1);
    	input.add(3);
    	input.add( 2);
    	input.add(7);
    	input.add( 0
    			);
    	int i=3;
    	i++;
    	i=i+4;
    	
    
    	

    	System.out.println(Q3(input));
    	

    }

}
