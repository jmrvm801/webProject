package economico;

import java.util.ArrayList;
import dao.ActivityDao;
import model.Activity;
import model.Coords;

/**
 * This class contains the recourses to manipulate the objects which are into an
 * ArrayList parameterized with Activity.
 * 
 * @author Fernando
 * @version 1.0
 *
 */
public class ActivityResources {

	/**
	 * An ArrayList parameterized with Activity objects
	 */
	private static ArrayList<Activity> list;

	/**
	 * This constructor initializes the list by creating an ActivityDao instance as
	 * a anonymous class followed by calling to findAll method.
	 */
	public ActivityResources() {
		list = new ActivityDao().findAll();
	}

	/**
	 * This method recovers the list like an ArrayList parameterized with Activity.
	 * 
	 * @return An ArrayList parameterized with Activity.
	 */
	public ArrayList<Activity> getList() {
		return list;
	}

	/**
	 * This method filter the activities by looking for an indicator. If the
	 * indicator match with the indicators into the Activity class, it will be
	 * stored into another ArrayList and finally returns it.
	 * 
	 * @param activities
	 *            The ArrayList parameterized with Activity class who contains the
	 *            information to be filtered.
	 * @param indicator
	 *            The indicator to compare with.
	 * @return An ArrayList parameterized with Activity which contains the
	 *         activities filtered.
	 */
	public ArrayList<Activity> getByIndicator(ArrayList<Activity> activities, String indicator) {
		ArrayList<Activity> selected = new ArrayList<Activity>();
		for (Activity activity : list)
			if (activity.getAcInCode().equals(indicator))
				selected.add(activity);
		return selected;
	}

	/**
	 * This method filter the activities by looking for countries. If the country
	 * (or countries) match with the country into the Activity class, it will be
	 * stored into another ArrayList and finally returns it.
	 * 
	 * @param activities
	 *            The ArrayList parameterized with Activity class who contains the
	 *            information to be filtered.
	 * @param countries
	 *            The ArrayList parameterized with Country to compare with.
	 * @return An ArrayList parameterized with Activity which contains the
	 *         activities filtered.
	 * @see Country
	 */
	public ArrayList<Activity> getByCountries(ArrayList<Activity> activities, ArrayList<String> countries) {
		ArrayList<Activity> selected = new ArrayList<Activity>();
		for (Activity activity : activities)
			for (String country : countries)
				if (activity.getAcCoCode().equals(country))
					selected.add(activity);
		return selected;
	}

	/**
	 * This method filter the data organized by years from an Activity class.
	 * 
	 * @param activity
	 *            A specific Activity class to be filtered.
	 * @param minValue
	 *            The year since the information will be filtered.
	 * @param maxValue
	 *            The year until the information will be filtered.
	 * @return An ArrayList parameterized with Coords class as Year and data
	 *         respectively.
	 */
	public ArrayList<Coords> getByYears(Activity activity, Integer minValue, Integer maxValue) {
		ArrayList<Coords> years = new ArrayList<Coords>();
		int value = minValue - 1960;
		for (int i = value, min = minValue; i <= (maxValue - minValue) + value; i++, min++)
			years.add(new Coords(min, activity.getAcValues().get(i)));
		return years;
	}
}