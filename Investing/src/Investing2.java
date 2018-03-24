import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * A class containing methods to compute the return on investment (ROI) of trades throughout 2016.
 *
 * -There is no intra-day trading in this assignment.
 * -All prices given are the price at the close of trading for each day.
 * -We will assume all trades for a given day are made at this price.
 *
 * Stock prices obtained from Yahoo Finance.
 */
public class Investing2 {


    /**1
     * 5 points
     *
     * Return the price of the stock at the given date as a double. Each line of the file contains 3 comma separated
     * values "date,price,volume" in the format "2016-03-23,106.129997,25703500" where the data is YYYY-MM-DD, the price
     * is given in USD and the volume is the number of shares traded throughout the day.
     *
     * @param stockFileName The filename containing the prices for a stock for each day in 2016
     * @param date          The date to lookup given in YYYY-MM-DD format
     * @return The price of the stock represented in stockFileName on the given date
     */
    public static double getPrice(String stockFileName, String date) {
    	double price=0.0;
    	try{
    		for(String line:Files.readAllLines(Paths.get(stockFileName))){
    			String[] a=line.split(",");
    			if(date.equals(a[0])){
    				price=new Double( a[1]);
    			}
    
    			
    		}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

        return price;
    }


    /**2
     * 5 points
     *
     * Return the cost of a single trade (stock price times number of shares).
     * If the trader is selling the shares this number should be negative.
     *
     * @param stockFileName  The filename containing the prices for a stock for each day in 2016
     * @param date           The date to lookup given in YYYY-MM-DD format
     * @param buyOrSell      Equals either "buy" or "sell" indicating the direction of the trade
     * @param numberOfShares the number of shares being bought or sold
     * @return The cost of a trade defined by the inputs
     */
    public static double costOfTrade(String stockFileName, String date, String buyOrSell, int numberOfShares) {
        double cost=0.0;
        double price=0.0;
        try{
    		for(String line:Files.readAllLines(Paths.get(stockFileName))){
    			String[] a=line.split(",");
    			if(date.equals(a[0])){
    				price=new Double(a[1]);
    				cost=price*numberOfShares;
    			}
    		}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cost=price*numberOfShares;
        if(buyOrSell.equalsIgnoreCase("sell")){
        	cost=-1*cost;
        }
        return cost;
    }


    /**3
     * 10 points
     *
     * Determine whether or not the given trader made all valid trades. The file for a trader contains the details
     * of all trades throughout the year in chronological order with one trade on each line in the
     * format "date,buyOrSell,numberOfShares,tickerSymbol" (ex. "2012-05-18,buy,100,GOOG"). Each trader is given a
     * certain amount of starting cash and their cash will fluctuate throughout the year of trading. A trade is
     * invalid if any of the following are true:
     *
     * 1. The trader buys more shares of a stock than can be afforded with their current cash
     * 2. The trader sells more shares of a stock than they own
     * 3. The date of the trade was not a valid trading day, or not a date in 2016 (any day not in the given files)
     * 4. There is no data for the ticker symbol of the trade (not AAPL, GOOG, or MSFT)
     *
     * @param traderFileName  The name of a file containing all the trades made by a trader throughout the year
     * @param startingCash    The amount of cash the trader has available at the start of the year
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     * @return true if all trades are valid, false otherwise
     */
//    public static boolean isTradingValid(String traderFileName, double startingCash,
//                                         HashMap<String, String> tickerFilenames) {
//        int share=0;
//    	try{
//        	for(String line:Files.readAllLines(Paths.get(traderFileName))){
//               String[] a=line.split(",");
//               if(a[0].contains("2016")){
//            	   if( tickerFilenames.containsKey(a[3])){
//            		   if(a[1].equals("buy")){
//            			   double price=getPrice(tickerFilenames.get(a[3]), a[0]);
//            			   if(price>startingCash){
//            				   return false;
//            			   } else {
//            			   startingCash=startingCash-price;
//            			   share=share+new Integer(a[2]);
//            			   }
//            		   }
//            		   if(a[1].equals("sell")){
//            			   double price=getPrice(tickerFilenames.get(a[3]), a[0]);
//            			   if(new Integer(a[2])>share){
//            				   return false;
//            			   } else {
//            			   startingCash=startingCash+price;
//            			   }
//            		   }
//            	   }else{
//            		   return false;
//            	   }
//               } else {
//            	   return false;
//               }
//        	}
//        } catch (IOException e){
//        	e.printStackTrace();
//        }
//        return true;
//    }
    public static boolean isTradingValid(String traderFileName, double startingCash,
            HashMap<String, String> tickerFilenames) {
ArrayList <String> Lines=null;
try {
Lines= new ArrayList <String>(Files.readAllLines(Paths.get(traderFileName)));

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
HashMap<String,Integer> number=new HashMap<String,Integer>();

for(String e:Lines){
String [] details= e.split(",");

startingCash+=-costOfTrade(tickerFilenames.get(details [3]),
details [0],
details [1],
new Integer(details[2])
);
if(startingCash<0){
return false;
}

if(number.containsKey(details [3])){

number.replace(details [3], number.get(details [3])+
(details [1].equals("sell")?-new Integer(details[2]):new Integer(details[2])));

}else{
number.put(details [3],new Integer(details[2]));}
if(number.get(details [3])<0){
return false;
}







}
return true;
}

    


    /**4
     * 10 points
     *
     * Compute the ROI of a given trader with a given starting cash.
     * Compute ROI as a fraction, as opposed to a percentage.
     * ROI is computed with the change in cash over the year and the value of all owned stocks.
     * The value of an owned stock is computed by it's price on the last trading day of the year ("2016-12-30").
     * You can assume all traders start the year owning no shares of any stock.
     *
     * Examples:
     * If a trader started with $1000 and ended the year with $1100 and $100 worth of stocks their ROI is 0.2
     * If a trader started with $8000 and ended the year with $6000 and $1500 worth of stocks, their ROI is -0.0625
     *
     * If the trader makes any invalid trades, return 0.0;
     *
     * @param traderFileName  The name of a file containing all the trades made by a trader throughout the year
     * @param startingCash    The amount of cash the trader has available at the start of the year
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     * @return The ROI for the given trader and starting cash, or 0.0 is trading is invalid
     */
    public static double getTraderROI(String traderFileName, double startingCash,
                                      HashMap<String, String> tickerFilenames) {
         double roi=0.0;
         int shareAAPL=0;
         int shareGOOG=0;
         int shareMSFT=0;
         double stock=0.0;
         double cash=startingCash;
         double lastPriceAAPL=0.0;
         double lastPriceGOOG=0.0;
         double lastPriceMSFT=0.0;
         try{
     		for(String line:Files.readAllLines(Paths.get(traderFileName))){
     			String[] a=line.split(",");
     			boolean valid=isTradingValid(traderFileName,startingCash,tickerFilenames);
     			if(valid==false){
     				return 0.0;
     			}
     	      if (a[3].equals("AAPL")){
     	    	 if(a[1].equals("buy")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash-price*new Integer(a[2]);
          			shareAAPL=shareAAPL+new Integer(a[2]);
          		  }
          		  if(a[1].equals("sell")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash+price*new Integer(a[2]);
          			shareAAPL=shareAAPL-new Integer(a[2]);
          		  }
     	      }
     	      if (a[3].equals("GOOG")){
     	    	 if(a[1].equals("buy")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash-price*new Integer(a[2]);
          			shareGOOG=shareGOOG+new Integer(a[2]);
          		  }
          		  if(a[1].equals("sell")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash+price*new Integer(a[2]);
          			shareGOOG=shareGOOG-new Integer(a[2]);
          		  }
     	      }
     	      if (a[3].equals("MSFT")){
     	    	 if(a[1].equals("buy")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash-price*new Integer(a[2]);
          			shareMSFT=shareMSFT+new Integer(a[2]);
          		  }
          		  if(a[1].equals("sell")){
          			double price=getPrice(tickerFilenames.get(a[3]), a[0]);
          			cash=cash+price*new Integer(a[2]);
          			shareMSFT=shareMSFT-new Integer(a[2]);
          		  }
     	      }
     		   
     		}
     	} catch (IOException e) {
 			e.printStackTrace();
 			
 		}
        lastPriceAAPL=getPrice("historicPrices/AAPL_2016.csv", "2016-12-30");
    	lastPriceGOOG=getPrice("historicPrices/GOOG_2016.csv","2016-12-30");
    	lastPriceMSFT=getPrice("historicPrices/MSFT_2016.csv", "2016-12-30");
        stock=lastPriceAAPL*shareAAPL+lastPriceGOOG*shareGOOG+lastPriceMSFT*shareMSFT;
        roi=(cash+stock-startingCash)/startingCash;
        return roi;
    }


    /**5
     * 10 points
     *
     * Compute the ROI of the firm.
     *
     * Compute the total ROI given a map of traders and their starting cash
     * Note: Total ROI is not the average of each individual ROI. The total gain/loss of each trader must be considered
     * Example:
     * A trader starting with $5 and an ROI of 2.0 made $15. Another trader with $200 and ROI of -0.5 lost $100.
     * The average ROI is 1.25, but the total cash went from $205 to $120 for a total ROI of -0.4146
     *
     * @param traderFileNamesAndStartingCash A map with each traders filename as the keys and their corresponding
     *                                       starting cash as values
     * @param tickerFilenames                Maps ticker symbols to the stock's filename
     * @return The total ROI of the firm (all traders in traderFileNamesAndStartingCash)
     */
    public static double getTotalROI(HashMap<String, Double> traderFileNamesAndStartingCash,
                                     HashMap<String, String> tickerFilenames) {
        
        return 0.0;
    }


    /**6
     * Challenge Question
     * Bonus: 10 points
     *
     * Historical Algorithmic Trader: Create a sheet of trades to maximize ROI given x starting capital.
     *
     * @param outputFilename  The filename of the resulting trades file
     * @param startingCash    Cash at the beginning of 2016
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     */
    public static void historicalAlgorithmicTrader(String outputFilename, double startingCash,
                                                   HashMap<String, String> tickerFilenames) {

        // Compute the optimal trading that would maximize ROI over the year with the given starting cash. You must
        // never buy more shares of a stock than you can afford or the trade is invalid. If you buy and sell shares on
        // the same day you can assume all the sells are executed before any of the buys. Write all trades to the
        // output file in the same format as the given trading files.
        //
        // Your algorithm must work for any stocks given in tickerFilenames which won't necessarily be the three used
        // for the assignment. You can assume the trading days will be the same (all of 2016).
        //
        // Points are all-or-nothing. Even a single penny short of optimal trading will result in 0 points.
        //
        // Note: This is a true challenge!


    }


    // The following testing code is to provided to help you get started testing your code. Provided are
    // methods to test getPrice and getTradePrice along with sample calls to test getPrice.
    //
    // *You are encouraged to write similar testing code for the rest of the assignment

    public static void testGetPrice(String priceFile, String date, double confirmedPrice) {
        double computedPrice = getPrice(priceFile, date);
        System.out.println("getPrice(\"" + priceFile + "\", \"" + date + "\"); \nreturned : " + computedPrice);
        System.out.println("Confirmed price: " + confirmedPrice + "\n");
    }

    public static void testGetTradeCost(String priceFile, String date, String buyOrSell, int numberOfShares, double confirmedPrice) {
        double computedPrice = costOfTrade(priceFile, date, buyOrSell, numberOfShares);
        System.out.println("costOfTrade(\"" + priceFile + "\", \"" + date + "\", \"" + buyOrSell + "\", " + numberOfShares + "); \nreturned : " + computedPrice);
        System.out.println("Confirmed price: " + confirmedPrice + "\n");
    }

    public static void main(String[] args) {

        String priceFile = "historicPrices/AAPL_2016.csv";
        String date = "2016-03-04";
        double confirmedPrice = 103.010002;
        testGetPrice(priceFile, date, confirmedPrice);

        priceFile = "historicPrices/GOOG_2016.csv";
        date = "2016-01-04";
        confirmedPrice = 741.840027;
        testGetPrice(priceFile, date, confirmedPrice);

        priceFile = "historicPrices/GOOG_2016.csv";
        date = "2016-03-09";
        confirmedPrice = 705.23999;
        testGetPrice(priceFile, date, confirmedPrice);

        priceFile = "historicPrices/MSFT_2016.csv";
        date = "2016-10-11";
        String buyOrSell = "sell";
        int numberOfShares = 100;
        double confirmedCost = -5718.9999;
        testGetTradeCost(priceFile, date, buyOrSell, numberOfShares, confirmedCost);

        
        // sample usage of getTraderROI
        HashMap<String, String> tickerFilenames = new HashMap<>();
        tickerFilenames.put("AAPL", "historicPrices/AAPL_2016.csv");
        tickerFilenames.put("GOOG", "historicPrices/GOOG_2016.csv");
        tickerFilenames.put("MSFT", "historicPrices/MSFT_2016.csv");

        double traderROI = getTraderROI("trades/lightTrader0.csv", 10000.0, tickerFilenames);
        double expectedROI = 0.06148999100000001;
        System.out.println("expected ROI: " + expectedROI);
        System.out.println("computed ROI: " + traderROI);
        System.out.println();

        System.out.println("If the price in the file and computed price do not match, please check your code in the " +
                "getPrice function.\nIf you are struggling, come to office hours. We are waiting for your " +
                "questions and are always happy to help.");
    }



}
