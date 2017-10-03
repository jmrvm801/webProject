package model;

/**
 * This class contains the Country model.
 * 
 * @author Fernando
 * @version 1.0
 *
 */
public class Country {
	
	/**
	 * A country code as a key.
	 */
	private String coCode;
	
	/**
	 * A country name.
	 */
	private String coName;
	

	/**
	 * The default constructor.
	 */
	public Country() {

	}

	/**
	 * The overloaded constructor
	 * 
	 * @param coCode
	 *            The country code key.
	 * @param coName
	 *            the country name
	 */
	public Country(String coCode, String coName) {
		this.coCode = coCode;
		this.coName = coName;
	}

	/**
	 * This method returns the country code.
	 * 
	 * @return The Country code.
	 */
	public String getCoCode() {
		return coCode;
	}

	/**
	 * This method returns the country name.
	 * 
	 * @return The country name.
	 */
	public String getCoName() {
		return coName;
	}
}