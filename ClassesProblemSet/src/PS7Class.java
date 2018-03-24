
public class PS7Class{

    // This problem set will be much different than in that you will be populating this class (PS7Class) with
    // variables and methods instead of filling in predefined static methods.

    // All defined methods should be public

    // Note: Many of the questions in this problem set are correlated and you can lose points on a question if
    //       some of the previous questions haven't been completed.



    // Q1: Create private instance variables all of type int and name them x, y, and z
	private int x,y,z;


    // Q2: Write a default constructor that initializes x, y, and z all to 1
	public PS7Class(){
		x=1;
		y=1;
		z=1;
		
	}


    // Q3: Write a constructor that take 3 ints as input and assigns these ints to x, y, and z in that order
	public PS7Class(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}


    // Q4: Write getter methods for each instance variable named getX, getY, and getZ that take no parameters and return
    //     ints
	

    // Q5: Write setter methods for each instance variable names setX, setY, and setZ that take 1 int as a parameter
    //     and returns void


    // Q6: Write a method named add that takes no parameters and returns the sum of x, y, and z as an int
	public int add(){
		
		return x+y+z;
	}


    // Q7: Write a method named multiply that takes no parameters and returns the multiplication of x, y, and z as an int
	public int multiply(){
		return x*y*z;
	}


    // Q8: Write a method named magnitude that takes no parameters and returns a double representing the magnitude of
    //     PS7Class if x, y, and z are interpreted as a 3d vector. The magnitude of a vector is the square root of the
    //     sum of the squares of x, y, and z (ie. the distance from (0, 0, 0)).
	public double magnitude(){
		
		return Math.sqrt(x*x+y*y+z*z);
	}


    // Q9: Write a method named distance that takes an instance of the PS7Class as a parameter and returns a double
    //     representing the distance between this instance and the given instance if x, y, and z are interpreted as a
    //     3d vector. The distance is the square root of the sum of the squares of the differences in x, y, and z.
	public double distance (PS7Class a){
		
		double XD=(x-a.x)*(x-a.x);
		double YD=(y-a.y)*(y-a.y);
		double ZD=(z-a.z)*(z-a.z);
		return Math.sqrt(XD+YD+ZD);
		  
		
	}


    // Q10: Override the toString method to print the values of x, y, and z in the format (x, y, z)
	public String toString(){
		return "("+x+", "+y+", "+z+")";
	}






    /*** Static methods (Some questions above must be working to get these points) ***/


    public static PS7Class Q11(int x, int y, int z){
        // return a new instance of your PS7Class with the provided x, y, and z values
    	


        return new PS7Class (x,y,z);
    }


    public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}


	public static int Q12(PS7Class input){
        // given an instance of your PS7Class, return its y value
		


        return input.y;
    }


    public static double Q13(PS7Class input){
        // given an instance of your PS7Class, return its magnitude
    	


        return input.magnitude();
    }


    public static void Q14(PS7Class input, int x, int y, int z){
        // set the values of x, y, and z of the input object to the provided values of x, y, and z
    	input.x=x;
    	input.y=y;
    	input.z=z;
    	


    }


    public static double Q15(PS7Class input1, PS7Class input2){
        // return the distance between the two inputs
    	

        return input1.distance(input2);
    }




    public static void main(String[] args){
    	PS7Class a = new PS7Class();
    	System.out.println(a.toString());

    }

}
