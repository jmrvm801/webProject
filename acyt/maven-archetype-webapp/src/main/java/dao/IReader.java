package dao;

import java.util.ArrayList;

/**
 * This interface defines the contract between ActivityDao,
 * CountryDao & IndicatorDao classes in order to use the methods correctly.
 * 
 * @author Fernando
 * @version 1.0
 * @param <T>
 *            A parameterized (generic) field can be replaced by the
 *            Activity, Country & Indicator classes, which are in the model
 *            package.
 * @see ActivityDao
 * @see CountryDao
 * @see IndicatorDao
 */
public interface IReader<T> {
	
	/**
	 * The connection to be used in ActivityDao, CountryDao & IndicatorDao classes
	 */
	public String conn = "jdbc:mysql://localhost/economic?user=root&password=";

	/**
	 * 
	 * @return ArrayList<T> An ArrayList parameterized with T (Can be Activity,
	 *         Country or Indicator classes defined in the model package).
	 */
	public ArrayList<T> findAll();
}