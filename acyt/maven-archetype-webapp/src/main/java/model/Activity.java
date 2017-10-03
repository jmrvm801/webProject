package model;

import java.util.ArrayList;

/**
 * This class contains the Activity model.
 * 
 * @author Fernando
 * @version 1.0
 *
 */
public class Activity {
	
	/**
	 * An Activity key.
	 */
	private long acId;
	
	/**
	 * A country code as a foreign key.
	 */
	private String acCoCode;
	
	/**
	 * An indicator code as a foreign key.
	 */
	private String acInCode;
	
	/**
	 * An ArrayList parameterized with Long which contains the values between 1960
	 * and 2016.
	 */
	private ArrayList<Long> acValues;

	/**
	 * The default constructor.
	 */
	public Activity() {

	}

	/**
	 * The overloaded constructor.
	 * 
	 * @param acId
	 *            The activity key.
	 * @param acCoCode
	 *            the country code.
	 * @param acInCode
	 *            the indicator code.
	 * @param acValues
	 *            the values by this Activity like an ArrayList parameterized with
	 *            Long.
	 */
	public Activity(long acId, String acCoCode, String acInCode, ArrayList<Long> acValues) {
		this.acId = acId;
		this.acCoCode = acCoCode;
		this.acInCode = acInCode;
		this.acValues = acValues;
	}

	/**
	 * This method returns the activity key.
	 * 
	 * @return The activity key.
	 */
	public long getAcId() {
		return acId;
	}

	/**
	 * This method returns the country code.
	 * 
	 * @return The country code.
	 */
	public String getAcCoCode() {
		return acCoCode;
	}

	/**
	 * This method returns the indicator code.
	 * 
	 * @return The indicator code.
	 */
	public String getAcInCode() {
		return acInCode;
	}

	/**
	 * This method returns the values for this activity since 1960 until 2016.
	 * 
	 * @return The values by this Activity like an ArrayList parameterized with
	 *         Long.
	 */
	public ArrayList<Long> getAcValues() {
		return acValues;
	}

	/**
	 * This method sets the value for this activity.
	 * 
	 * @param acValues
	 *            The ArrayList parameterized with Long which contains the values
	 *            between 1960 and 2016.
	 */
	public void setAcValues(ArrayList<Long> acValues) {
		this.acValues = acValues;
	}
}