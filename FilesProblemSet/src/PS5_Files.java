import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.StandardOpenOption;

public class PS5_Files {




    static ArrayList<String> Q1(String filename){
        // Return all lines of the file in an ArrayList with 1 String for each line in the file
    	try{
    	ArrayList<String> result=new ArrayList<String>(Files.readAllLines(Paths.get(filename)));
    	return result;
    	}
    	catch(IOException e){
    		
    		 e.printStackTrace();
    		
    	}

        return null;
    }


    static int Q2(String filename){
        // return the number of lines in the input file
    	

        try {
			return Files.readAllLines(Paths.get(filename)).size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return -1;
    }


    static double Q3(String number){
        // Return the double represented by the input String. You can assume the String contains a well-formed double.
    	Scanner c = new Scanner(number);
    	double a = 0;
    	
    	do {
    		
    	
    	
    	
    		if(c.hasNextDouble()){
    			
    			a=(c.nextDouble());
    			}
    			
    		if(c.hasNext()){
    			c.next();
    		}
    		
    		}

    			
    		while(c.hasNext());
    		
    	
    		
    		
    		
    	
    
    	
    	

        return a;
        
    }


    static int Q4(String filename, char letter){
        // return the number of times letter appears in the input file
    	int j=0;
    	try {
    		
			for(byte e:Files.readAllBytes(Paths.get(filename))){
				if(e==(byte)letter){
					j++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	Scanner c = null;
//		try {
			
//			c = new Scanner(Paths.get(filename));
//			c=new Scanner("a dadfnerjadfxczv");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
    	
//		int j = 0;
//		do{
//			
//			if(c.hasNext("a")){
//	    		
//				j++;
//	    		
//	    	}
//			if(c.hasNext()){
//				c.next();
//			}
//		}
//		while(c.hasNext());
//    	
    	
    	
    	
    			
    	
    	
    	
    	

        return j;
    }


    static boolean Q5(String filename) {
        // return true if the file can be successfully opened, false otherwise. Hint: If the file cannot be opened, an
        // IOException will be thrown.
    	
    	
    	try {
			Files.readAllLines(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return Files.exists(Paths.get(filename));
    	}
    	
    		
    		
    	  
    	

       
    


    static String Q6(String line){
        // Given a line containing comma-separated values, return the second value.
    	String [] a= line.split(",");
    	

        return a [1];
    }


    static int Q7(String line){
        // Given a line containing comma-separated values, return the second value as an int. You can assume the second
        // value is a well-formed integer.
    	 Scanner a = new Scanner(Q6( line));
    	
    	

        return  a.nextInt();
    }


    static ArrayList<Integer> Q8(String filename){
        // Read the file to populate an ArrayList of Integers and return the ArrayList. Each line of the file will
        // contain a well-formed integer.
    	ArrayList<Integer> b=new ArrayList<Integer>();
    	
    	try {
//    		ArrayList <String> a = new ArrayList <String>(Files.readAllLines(Paths.get(filename)));
//    		for (String e:a){
    			Scanner s= new Scanner(Paths.get(filename));
    			do{
    				if(s.hasNextInt()){
    					b.add(s.nextInt());
    				}else{
    					s.next();
    				}
    				
    			}while(s.hasNext());
    			 
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

        return b;
    }


    static ArrayList<String> Q9(String line){
        // Given a line containing comma-separated values, return an ArrayList of Strings containing each value in the
        // line separately. Example: Given "comma,separated,values" return ["comma","separated","values"] as 3 entries
        // in an ArrayList.
    	
    	
  
    

        return new ArrayList<String>(Arrays.asList(line.split(",")));
    }


    static HashMap<String, Integer> Q10(String filename){
        // Read the input file and add an entry into a HashMap for each line. The lines will contain comma separated
        // values with a String then an int (ex: "text,5"). For each line enter the String as the key and the int as
        // a value into the map and return the map.
    	HashMap<String, Integer> result=new HashMap<String, Integer> ();
    	try {
    		for(String e:Files.readAllLines(Paths.get(filename))){
    			
    			String [] Array =e.split(",");
    			Scanner s = new Scanner(Array [1]);
    			
    			result.put(Array [0],s.nextInt());
    		}
    		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;
    }


    static ArrayList<String> Q11(String filename){
        // Read the file to populate an ArrayList of Strings and return the ArrayList. The file will be comma separated
        // and only the 2nd value (index 1) is to be added into the ArrayList
    	ArrayList<String> result=new ArrayList<String>();
    	for(String e:Q1(filename)){
    		result.add(e.split(",") [1]) ;
    	}

        return result;
    }


    static ArrayList<Integer> Q12(String filename){
        // Read the file to populate an ArrayList of Integers and return the ArrayList. Each line of the file will
        // contain comma separated data and only the 3rd value (index 2) is to be added into the ArrayList as Integers.
        // You can assume the 3rd value on each line is a well-formed Integer.
    	ArrayList<Integer> result=new ArrayList<Integer>();
    	for(String e:Q1(filename)){
    		result.add(new Scanner(e.split(",") [2]).nextInt()) ;
    	}

        return result;
    }


    static void Q13(String filename, String data){
        // create a new file named filename and write the contents of data into it
    	
    	try {
    		Files.createFile(Paths.get(filename));
			Files.write(Paths.get(filename), data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    static void Q14(String filename, String data){
        // append the contents of data to the end of filename. You can assume a file named filename already exists
    	
    	try {
    		
			Files.write(Paths.get(filename), data.getBytes(),StandardOpenOption.APPEND);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }


    static void Q15(String inputFilename, String outputFilename){
        // read every line in inputFilename and write it to a file named outputFilename (make a copy of the file)
    	try {
			Files.copy(Paths.get(inputFilename), Paths.get(outputFilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }



    public static void main(String[] args) {
        // sample usage
    	
    	 System.out.println(Q3("32.0"));
        System.out.println(Q1("data/test0.txt"));
      ; 
      System.out.println(Q8("data/integers0.txt"));
      
     
			
			
		
        
       
    

}
    }
