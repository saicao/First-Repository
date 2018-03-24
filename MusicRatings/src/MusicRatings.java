import com.eclipsesource.json.Json;


import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


// All imports from the solution have been included. You can import more classes, though it is confirmed
// that the assignment can be completed with the above imports only. This includes the bonus question.

// The Song class and this MusicRatings class will both be in the default package during graded.

/**
 * The MusicRating class is a collection of methods used to process data from the music ratings API.
 *
 * API url: http://fury.cse.buffalo.edu/musicRatings
 */
public class MusicRatings {
	


    /**
     * 5 points
     *
     * Returns the average rating of the given Song object. This method assumes the Song class is
     * in the default package.
     *
     * @param song  A Song object
     * @return the average rating of the song
     */
	
    public static double averageRating(Song song){
    	double total=0;
    	for(int e:song.getRatings()){
    		total+=e;
    	}
    	

        return total/song.getRatings().size();
    }



    /**
     * 5 points
     *
     * Converts a JSON Object into a Song object. This method assumes that the input is in the format:
     * {"title":"Lose Yourself", "artist":"Eminem", "ratings":[5,5,4,5], "youtubeID":"xFYQQPAOz7Y"}
     *
     * @param jsonSong  A song in JSON format
     * @return A Song object with the data from the JSON Value
     */
    public static Song jsonToSong(JsonObject jsonSong){
    	
    	
    	ArrayList <Integer> rat=new ArrayList <Integer>();
    	
    	
    	
    	JsonArray ratings = new JsonArray(jsonSong.get("ratings").asArray());
    	
    	
    	for(int i=0;i<ratings.size();i++){
//    		if(ratings.get(i).isString()){
//    			
//    			rat.add(new Integer(ratings.get(i).asString()));}
//    			
//    		else{
    		
    		
    			rat.add(ratings.get(i).asInt());
//    			}
    		}

    		
    		
    		
    		
    	
    	
  
        return new Song(jsonSong.get("youtubeID").asString(),
    			jsonSong.get("title").asString(),
    			jsonSong.get("artist").asString(),
    			
    			rat);
        }
    	
    


    /**
     * 10 points
     *
     * Return every song from the music ratings API as an ArrayList of Song objects.
     *
     * A JSON string containing the information for every rated song can be obtained with a GET
     * request to the url: http://fury.cse.buffalo.edu/musicRatings/getAllSongs
     * The format of the returned string is a JSON list of songs represented as JSON objects in the
     * same format as the input of the previous method. To see this format and the data you can paste
     * the url into a web browser.
     *
     * @return An ArrayList containing all the songs from the music ratings API
     */
    public static ArrayList<Song> getAllSongsFromAPI() {
    	
    	String data = null;
    	ArrayList <Song> songs=new ArrayList<Song>();
    	
    	
    	
    	
    	try {
			data=Request.Get("http://fury.cse.buffalo.edu/musicRatings/getAllSongs").execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	JsonValue jsonValue = Json.parse(data);
    	
    	
    	
    	JsonArray da = new JsonArray(jsonValue.asArray());
    
    	
    	for(JsonValue e: da){
    		
    		try{songs.add(jsonToSong(e.asObject()));
    		}
    		catch (Exception e1){
    			System.out.println(e.asObject().toString());
    			
    		}
    	}
    	
    	
    	
    	
    	

        return songs;
    }


    /**
     * 10 points
     *
     * Returns the song from the music ratings API that has been rated the most number of times as
     * a Song object. The rating of the songs should not be considered in this method, only the number
     * of times they have been rated. Ties can be broken arbitrarily.
     *
     * @return A Song with the most reviews
     */
    public static Song getMostRatedSong(){
    	ArrayList <Song> songs=getAllSongsFromAPI();
    	Song MostRatedSong=null;
    	int maxrating=Integer.MIN_VALUE;
    	for(Song e: songs){
    		if(maxrating<e.getRatings().size()){
    			maxrating=e.getRatings().size();
    			MostRatedSong=e;
    		}
    	}
    	

        return MostRatedSong;
    }


    /**
     * 10 points
     *
     * Returns an ArrayList containing all songs from the song ratings API with at least "minRating" average
     * rating and at least "minNumberOfRatings" number of ratings. The songs can be listed in any order.
     *
     * @param minRating  minimum rating of returned songs
     * @param minNumberOfRatings  minimum number of ratings of returned songs
     * @return all songs from the song ratings API with >= minRating and >= minNumberOfRatings
     */
    public static ArrayList<Song> getPlaylist(double minRating, int minNumberOfRatings){
    	ArrayList <Song> Songs=getAllSongsFromAPI();
    	ArrayList <Song>  result=new ArrayList <Song>();
    	
    	
    	for(Song e: Songs){
    		if(averageRating(e)>=minRating&&e.getRatings().size()>=minNumberOfRatings){
    			result.add(e);
    		}
    		
    	}
    	
    	
    	
    	

        return result;
    }
    


    /**
     * Challenge Question
     * Bonus: 10 points
     *
     * Returns an ArrayList of the top k songs sorted by the bayesian average of their ratings.
     *
     * references:
     * https://en.wikipedia.org/wiki/Bayesian_average
     * http://fulmicoton.com/posts/bayesian_rating/
     *
     * For m use the average rating cast across all songs. Note that this is not the average of
     * all the average ratings, but the average of all individual ratings. For example if the API
     * contained only 2 songs with ratings [4,4,4] and [5] m would be 4.25.
     *
     * For C use the average number of ratings across all songs. In the example with 2 songs with
     * ratings [4,4,4] and [5] C would be 2. C is not necessarily an integer so if the 2 songs had 
     * ratings [4,4] and [5] C would be 1.5.
     *
     * @return The k best songs based on the bayesian average of their ratings starting with
     *         the best song at index 0
     */
    public static ArrayList<Song> getBestPlaylist(int k){
        // Earning credit for this question will require self-learning. The concepts needed to complete
        // this method have not been covered in this course, or were only covered briefly.
    
    	ArrayList <Song> Songs=getAllSongsFromAPI();
//    	ArrayList <Entry<Song, Double>> SD=new ArrayList <Entry<Song, Double>>() ;
    	ArrayList <Song> reuslt=new ArrayList <Song>() ;
    	double m=getm(Songs);
    	double c=getc(Songs);
//    	HashMap <Song,Double> SongtoA=new HashMap <Song,Double>();
    	ArrayList <song> so=new ArrayList <song>() ;
    	
    	
    	
    	
    	
    	
    	
    	for(Song e:Songs){
    		double average=0;
    		double total=0;
        	double reviwers=e.getRatings().size();
    		for(int e1:e.getRatings()){
        		total+=e1;
        		
        	}
    		
        	average=(c*m+total)/(c+reviwers);
        	so.add(new MusicRatings().new song(e, average));
        	
//        	SongtoA.put(e, average);
    	}
    	so.sort(new Comparator<song> (){

			@Override
			public int compare(song o1, song o2) {
				// TODO Auto-generated method stub
				if( o1.D-o2.D<0){
					
					return 1;
							
				}else if( o1.D-o2.D>0){
					return -1;
				}else{
					return 0;
				}
				
			}

			
			});
    	for(int i=0;i<k;i++){
    		reuslt.add(so.get(i).s);
    	}
    	return reuslt;
    	
    	
    	
    	
//    	SD.addAll(SongtoA.entrySet());
//    	Comparator<Entry<Song, Double>> C=new Comparator<Entry<Song, Double>>(){
//
//			@Override
//			public int compare(Entry<Song, Double> o1, Entry<Song, Double> o2) {
//				
//				if( o1.getValue()-o2.getValue()<0){
//					
//					return 1;
//							
//				}else if( o1.getValue()-o2.getValue()>0){
//					return -1;
//				}else{
//					return 0;
//				}
//					
//			}
//    		
//
//    		
//    		
//    	};
//    	
//    	SD.sort(C);
//    	
//    	for(int i=0;i<k;i++){
//    		
//    		reuslt.add(SD.get(i).getKey());
//    	}

//    	return reuslt;
        }
    public static double getm(ArrayList <Song> Songs){
    	double total=0;
    	int reviewer=0;
    	for(Song e: Songs){
    		for(double e1:e.getRatings()){
    			total+=e1;
    		}
    		reviewer+=e.getRatings().size();
    	}
    	return total/reviewer;
    	
    }
    public static double getc(ArrayList <Song> Songs){
    	
    	double reviewer=0;
    	for(Song e: Songs){
    		
    		
    		reviewer+=e.getRatings().size();
    	}
    	return reviewer/Songs.size();
    	
    }
    class song {
    	Song s;
    	double D;
    	public song(Song s,double D){
    		this.s=s;
    		this.D=D;
    	}
    	
    }
    
    
    
    
    
    
    
    
    



    public static void main(String[] args) {

    	ArrayList<Song> a=getAllSongsFromAPI();
        System.out.println(getBestPlaylist(1));
   
    	
    	
    	
    	
    	
    	
    	
        
    	
    	
    	

    }

}
