package store;

public class Stats {
	static int cashierMax = 4;
	static int customerMax = 10;
	
	// Tid mellan nya cusotmers
	static double lambda = 4.0;
	
	// Tid att plocka varor
	static double plockMax = 1.0;
	static double plockMin = 0.5;
	
	// Tid att betala
	static double payMax = 1.0;
	static double payMin = 0.5;
	
	// Seed
	static int seed = 1234;
	
	// Time
	static double stopTime = 99999;
	static double closeTime = 10.0;
	static double startTime = 0;
	
	/**
	 * Returns the max amount of cashiers
	 * @return
	 */
	public static int getCashierMax(){
		return cashierMax;
	}
	
	/**
	 * Returns the seed
	 * @return
	 */
	public static int getSeed() {
		return seed;
	}
	
	/**
	 * Returns the exponential random parameter lambda
	 * @return
	 */
	public static double getLambda() {
		return lambda;
	}
	
	/**
	 * Returns the stop time
	 * @return
	 */
	public static double getStopTime() {
		return stopTime;
	}
	
	/**
	 * Returns the closing time of the store
	 * @return
	 */
	public static double getCloseTime(){
		return closeTime;
	}
	
	/**
	 * Returns the start time
	 * @return
	 */
	public static double getStartTime() {
		return startTime;
	}
	
	/**
	 * Returns the maximum time to "plocka varor"
	 * @return
	 */
	public static double getPlockMax() {
		return plockMax;
	}
	
	/**
	 * Returns the minimum time to "plocka varor"
	 * @return
	 */
	public static double getPlockMin() {
		return plockMin;
	}
	
	/**
	 * Returns the maximum time to pay
	 * @return
	 */
	public static double getPayMax() {
		return payMax;
	}
	
	/**
	 * Returns the minimum time to pay
	 * @return
	 */
	public static double getPayMin() {
		return payMin;
	}
	
	/**
	 * Returns the maximum amount of customers 
	 * @return
	 */
	public static int getCustomerMax() {
		return customerMax;
	}

}