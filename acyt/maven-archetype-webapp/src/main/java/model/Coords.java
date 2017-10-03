package model;

/**
 * This class contains the Coords Model
 * @author Fernando
 * @version 1.0
 *
 */
public class Coords {
	
	/**
	 * x position in the chart (year).
	 */
	private int x;
	
	/**
	 * y position in the chart (data)
	 */
	private Long y;

	/**
	 * Constructor which receives a year and data associated with it.
	 * 
	 * @param x
	 *            Year
	 * @param y
	 *            Data
	 */
	public Coords(int x, Long y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method returns the year.
	 * 
	 * @return Year.
	 */
	public int getX() {
		return x;
	}

	/**
	 * this method sets the year.
	 * 
	 * @param x
	 *            Year.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * this method return the data associated with the year.
	 * 
	 * @return Data associated with the year.
	 */
	public Long getY() {
		return y;
	}

	/**
	 * this method sets the data.
	 * 
	 * @param y
	 *            the data.
	 */
	public void setY(Long y) {
		this.y = y;
	}
}