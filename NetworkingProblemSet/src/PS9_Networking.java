import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class PS9_Networking {

    static String Q1(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api and return the server's response
        // as a String
        //
        // Note: There will be very little feedback from Autolab for this assignment. You should run your code
        //       to verify that you are recieving a response from the server before sumbitting.
    	

        try {
			return Request.Get("http://fury.cse.buffalo.edu/api").execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
    }

    static String Q2(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_string and return the server's response
        // as a String
    	try {
			return Request.Get("http://fury.cse.buffalo.edu/api/get_string").execute().returnContent().asString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return "";
    }

    static int Q3(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_int and return the server's response
        // as an int. You may assume that the response is a well-formed integer
    	String Int=null;
    	try {
			 Int=Request.Get("http://fury.cse.buffalo.edu/api/get_int").execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Integer a=new Integer(Int);
    	

        return a;
    }

    static String Q4(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/post and return the
        // server's response as a String
    	try {
			return Request.Get("http://fury.cse.buffalo.edu/api/post").execute().returnContent().asString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return "";
    }

    static String Q5(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params and return the
        // server's response as a String
    	try {
			return Request.Get("http://fury.cse.buffalo.edu/api/get_with_params").execute().returnContent().asString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

        return "";
    }

    static String Q6(){
        // Send the empty String (eg. "") in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.
    	String result=null;
    	try {
    		result=Request.Post("http://fury.cse.buffalo.edu/api/post").bodyString("", ContentType.DEFAULT_TEXT).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;
    }

    static String Q7(){
        // Send "hello server" in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.
    	String result=null;
    	try {
    		result=Request.Post("http://fury.cse.buffalo.edu/api/post").bodyString("hello server", ContentType.DEFAULT_TEXT).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;

       
    }

    static String Q8(){
        // Send "how are you?" in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.
    	String result=null;
    	try {
    		result=Request.Post("http://fury.cse.buffalo.edu/api/post").bodyString("how are you?", ContentType.DEFAULT_TEXT).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;

        
    }

    static String Q9(String content){
        // Send the provided content in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.
    	String result=null;
    	try {
    		result=Request.Post("http://fury.cse.buffalo.edu/api/post").bodyString(content, ContentType.DEFAULT_TEXT).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;


       
    }

    static String Q10(Integer value){
        // Send the provided int value in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.
    	String result=null;
    	
    	try {
    		
    		
    		
    		
    		result=Request.Post("http://fury.cse.buffalo.edu/api/post").bodyString(Integer.toString(value), ContentType.DEFAULT_TEXT).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;

       
    }

    static String Q11(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "question" set to the value "11" and return the server's response as a String
    	String reponse =null;
    			try {
					reponse=Request.Get("http://fury.cse.buffalo.edu/api/get_with_params?question=11").execute().returnContent().asString();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        return reponse;
    }

    static String Q12(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value "value" and return the server's response as a String
    	String reponse =null;
		try {
			reponse=Request.Get("http://fury.cse.buffalo.edu/api/get_with_params?key=value").execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return reponse;
    }

    static String Q13(String param){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value of the provided param and return the server's response as a String
    	String reponse =null;
		try {
			reponse=Request.Get("http://fury.cse.buffalo.edu/api/get_with_params?key="+param).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return reponse;
    }

    static String Q14(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "question" set to the value "14" and a parameter "key" set to the value "turtle" and return
        // the server's response as a String
    	String reponse =null;
		try {
			reponse=Request.Get("http://fury.cse.buffalo.edu/api/get_with_params?question=14&key=turtle").execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return reponse;
    	
    	

       
    }

    static String Q15(String param1, String param2){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value of param1 and a parameter "query" set to the value of param2
        // and return the server's response as a String
    	String reponse =null;
		try {
			reponse=Request.Get("http://fury.cse.buffalo.edu/api/get_with_params?key="+param1+"&query="+param2).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

        return reponse;
    	
    	

        
    }

    public static void main(String[] args) {
    	
    	System.out.println(Q12()
    	);
    	
    	System.out.println(Q3()
    	    	);
    	System.out.println(Q4()
    	    	);
    	System.out.println(Q5()
    	    	);
    	
    	
    	

    }

}
