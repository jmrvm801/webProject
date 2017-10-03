package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Country;

/**
 * This class recovers the database information from the country table and fill
 * the data into an ArrayList
 * 
 * @author Fernando
 *
 */
public class CountryDao extends DataBase implements IReader<Country> {
	/**
	 * @return ArrayList<Activity> Activity information which contains the data from
	 *         the country table.
	 */
	public ArrayList<Country> findAll() {
		ArrayList<Country> arr = new ArrayList<Country>();
		Country country;
		try {
			ResultSet rs = query("SELECT * FROM country ORDER BY coCode ASC;");
			while (rs.next()) {
				country = new Country(rs.getString("coCode"), rs.getString("coName"));
				arr.add(country);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			close();
		}
		return arr;
	}
}