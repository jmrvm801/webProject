package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Activity;

/**
 * This class recovers the database information from the historial table and
 * fill it into an ArrayList
 * 
 * @author Fernando
 * @version 1.0
 */
public class ActivityDao extends DataBase implements IReader<Activity> {

	
	/**
	 * @return Activity information which contains the data from the historial
	 *         table.
	 */
	public ArrayList<Activity> findAll() {
		ArrayList<Activity> arr = new ArrayList<Activity>();
		Activity activity = null;
		ArrayList<Long> values;
		ResultSet rs = query("SELECT * FROM historial;");
		if (rs == null)
			return arr;
		try {
			while (rs.next()) {
				values = new ArrayList<Long>();
				for (int anio = 1960; anio < 2017; anio++)
					values.add(rs.getLong("a" + anio));
				activity = new Activity(rs.getLong("hiId"), rs.getString("hiCoCode"), rs.getString("hiInCode"), values);
				arr.add(activity);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			close();
		}
		return arr;
	}
}