package model;

/**
 * This class contains the Indicator model.
 * 
 * @author fernando
 * @version 1.0
 *
 */
public class Indicator {
	
	/**
	 * An Indicator code key.
	 */
	private String inCode;
	
	/**
	 * An Indicator name.
	 */
	private String inName;
	

	/**
	 * The default constructor.
	 */
	public Indicator() {

	}

	/**
	 * The overloaded constructor.
	 * 
	 * @param inCode
	 *            The indicator code key.
	 * @param inName
	 *            The indicator name.
	 */
	public Indicator(String inCode, String inName) {
		this.inCode = inCode;
		this.inName = inName;
	}

	/**
	 * This method returns the activity key.
	 * 
	 * @return the indicator code key.
	 */
	public String getInCode() {
		return inCode;
	}

	/**
	 * This method returns the activity name.
	 * 
	 * @return The indicator name.
	 */
	public String getInName() {
		return inName;
	}
}