import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cse115.math.NormalDistribution;
import cse115.math.Polynomial;
import cse115.words.Words;

public class PS8_Libraries{


    static double Q1(NormalDistribution distro, double x){
        // return the z-score of x in the given distribution
    

        return 	distro.zScore(x);
    }


    static Polynomial Q2(){
        // return a new Polynomial representing "8x^2 + 5x - 6"
    	ArrayList <Double> a = new ArrayList <Double>();
    	a.add(-6.0);
    	a.add(5.0);
    	a.add(8.0);
    	
    	

        return new Polynomial(a);
    }


    static Polynomial Q3(ArrayList<Double> coefficients){
        // return a new Polynomial with the provided coefficients

        return new Polynomial(coefficients);
    }


    static double Q4(Polynomial equation, double x){
        // return the evaluation of the input polynomial at x


        return 	equation.evaluate(x);
    }


    static Polynomial Q5(Polynomial equation){
        // return the derivative of the input polynomial

        return equation.getDerivative();
    }



    static int Q6(String word){
        // return the number of syllable in the input word
    	

        return Words.numberOfSyllables(word);
    }


    static boolean Q7(String word1, String word2){
        // return true if the two input words rhyme at least 1 syllable, false otherwise
        //
        // Words rhyme if they end with the same syllable
    	
    	
    	
    	

        return Words.rhymeLength(word1,word2)>=1?true:false;
    }


    static boolean Q8(String word1, String word2, String word3){
        // return true if the three input words all rhyme at least 1 syllable, false otherwise
    	
       if( Words.rhymeLength(word1, word2)>=1&&Words.rhymeLength(word2, word3)>=1){
    	   return true;
       }
    	
        
    	return false;
    }
   


    static boolean Q9(String word1, String word2){
        // return true if the two input words alliterate with at least 1 sound, false otherwise.
        //
        // Words alliterate if they start with the same sound
    	

    	 return Words.alliterationLength(word1, word2)>=1?true:false;
    }
    


    static boolean Q10(String word1, String word2, String word3){
        // return true if the three input words all alliterate with at least 1 sound, false otherwise
    	if(Words.alliterationLength(word1, word2)>=1&&Words.alliterationLength(word2, word3)>=1){
    		return true;
    	}

        return false;
    }


    static int Q11(String sentence){
        // return the number of syllables in the given sentence. The input is sentence with each word separated by
        // spaces and no punctuation.
    	int result=0;
    	for(String e:sentence.split(" ")){
    		result+=Words.numberOfSyllables(e);
    	}

        return result;
    }


    static ArrayList<String> Q12(String word){
        // return all possible parts of speech of the given word
    


        return 	Words.getPartsOfSpeech(word);
    }


    static int Q13(String sentence, String partOfSpeech){
        // return the maximum possible number of words in the input sentence that can have the given part of speech.
    	int result=0;
    	for(String e:sentence.split(" ")){
    		for(String e1:Words.getPartsOfSpeech(e))
    		if(e1==partOfSpeech)
    			result++;
    	}

        return result;
    }


    static boolean Q14(String sentence1, String sentence2){
        // return true if the two input sentences rhyme at one syllable. The sentences rhyme if their last words rhyme.
    	String [] S1=sentence1.split(" ");
    	String [] S2=sentence2.split(" ");
    	
    	
        return Words.rhymeLength(S1[S1.length-1], S2[S2.length-1])>=1?true:false;
    }


    static boolean Q15(ArrayList<String> words){
        // return true if all the words in the input list alliterate with at least 1 sound, false otherwise
    	
    	int j=1;
    	for(int i=0;i<words.size()-1;i++){
    		if(!(Words.alliterationLength(words.get(i), words.get(j))>0)){
    		return false;
    		}
    	}
    		
    
    	
        return true;
        }
    
   


    public static void main(String[] args){

    }

}
