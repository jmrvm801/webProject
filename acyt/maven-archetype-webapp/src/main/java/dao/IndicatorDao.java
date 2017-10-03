package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Indicator;

/**
 * This class recovers the database information from the indicator table and
 * fill the data into an ArrayList
 * 
 * @author laoss
 *
 */
public class IndicatorDao extends DataBase implements IReader<Indicator> {


	/**
	 * @return ArrayList<Activity> Activity information which contains the data from
	 *         the indicator table.
	 */
	public ArrayList<Indicator> findAll() {
		ArrayList<Indicator> arr = new ArrayList<Indicator>();
		Indicator indicator;
		try {
			ResultSet rs = query("SELECT * FROM indicator ORDER BY inName ASC;");
			while (rs.next()) {
				indicator = new Indicator(rs.getString("inCode"), rs.getString("inName"));
				arr.add(indicator);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			close();
		}
		return arr;
	}
}