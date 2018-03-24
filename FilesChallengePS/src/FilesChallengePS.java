import java.util.ArrayList;

import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FilesChallengePS {



    // 2 points
    static void Q1(String inputFilename, String outputFilename) {
        // You are given a csv file (inputFilename) with all the data on a single line. Separate the
        // values by commas and write each value on a separate line in a new file (outputFilename)
    	ArrayList <String> lines=new ArrayList <String>();
    	try {
			lines.addAll(Files.readAllLines(Paths.get(inputFilename)));
			Files.createFile(Paths.get(outputFilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	String a= "";
    	for(String e:lines){
    		
    		String [] c=e.split(",");
    		
    		for(int i=0;i<c.length;i++){
    			if(i==c.length-1){
    				a+=c[i];
    			}else{
    			a=c [i]+"\n";}
    			
    		}
    		
    		
    		
    	}
    	
    	try {
			Files.write(Paths.get(outputFilename),a.getBytes() );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    }


    // 3 points
    static ArrayList<String> Q2(String filename) {

        // You are given a file (filename) containing a different random phrase on each line. Return an
        // ArrayList containing each phrase, but without the first word of each phrase.
        //
        // Example: If the files contains the 2 phrases "roofed crossover" and "beneficiary charles frederick worth" the
        // ArrayList should contain "crossover" and "charles frederick worth"
    	 ArrayList<String> result= new ArrayList<String>();
    	 ArrayList<String> lines = new ArrayList<String>();
    	 try {
				lines.addAll(Files.readAllLines(Paths.get(filename))) ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 for(String e:lines){
    		String resultString="";
    		String [] linesplited=e.split(" ");
    		for(int i=1;i<linesplited.length;i++){
    			if(i==linesplited.length-1){
    				resultString+=linesplited[i];
    			}else{
    			resultString+=linesplited[i]+" ";}
    		}
    		result.add(resultString);
    	 }


        return result;
    }


    // 5 points
    static double Q3(String stockFilename, String date) {

        // Given a filename with stock data in the format "date,price,volume" and a date, return the total value of all
        // shares of the stock that were traded that day. The total value is price times (multiplication) volume.
    	


        return 0.0;
    }


    // 5 points
    static void Q4(String inputFilename, String outputFilename,
                                 double minLatitude, double maxLatitude,
                                 double minLongitude, double maxLongitude) {

        // Given a file of cities in the format "county code,city name,region,latitude,longitude" and a 
    	    // latitude/longitude range, write a new file containing only cities within the given range in 
    	    // both latitude and longitude.


    }


    public static void main(String[] args) {
    	
    }

}
