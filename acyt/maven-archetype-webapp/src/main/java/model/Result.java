package model;

import java.util.ArrayList;

/**
 * This class contains the Result model
 * 
 * @author Fernando
 * @version 1.0
 *
 */
public class Result {

	/**
	 * String key that means Country.
	 */
	private String key;

	/**
	 * Values by this country name with an ArrayList parameterized with Coords
	 * class.
	 */
	private ArrayList<Coords> values;

	/**
	 * Contructors which receives a key (country name) and values (years and data by
	 * year).
	 * 
	 * @param key
	 *            Country.
	 * @param values
	 *            Years and values.
	 */
	public Result(String key, ArrayList<Coords> values) {
		this.key = key;
		this.values = values;
	}

	/**
	 * This method returns a String (country name)
	 * 
	 * @return Key value (country name).
	 */
	public String getKey() {
		return key;
	}

	/**
	 * this method sets the country name.
	 * 
	 * @param key
	 *            country name.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * this method returns an ArrayList parameterized with Coords class.
	 * 
	 * @return ArrayList parameterized with Coords class.
	 */
	public ArrayList<Coords> getValues() {
		return values;
	}

	/**
	 * this method sets the data by this country name.
	 * 
	 * @param values
	 *            The value names as an ArrayList.
	 */
	public void setValues(ArrayList<Coords> values) {
		this.values = values;
	}
}