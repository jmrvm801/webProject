package economico;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dao.CountryDao;
import dao.IndicatorDao;
import model.Activity;
import model.Coords;
import model.Country;
import model.Indicator;
import model.Result;

/**
 * This class define the controller and contains the request mapping in order to
 * use as a restful server.
 * 
 * @author Fernando
 * @version 1.0
 *
 */
@RestController
public class EconomicController {
	
	/**
	 * A static field which contains the ActivityResources object.
	 */
	private static ActivityResources ar;
	
	/**
	 * A static field which contains the CountryDao object.
	 */
	private static CountryDao countries = new CountryDao();

	/**
	 * A constructor which initializes the ar field
	 */
	public EconomicController() {
		if (ar == null)
			ar = new ActivityResources();
	}

	/**
	 * This method gets the countries information by CountryDao object.
	 * 
	 * @return An ArrayList parameterized with Country that allows to Google convert
	 *         the ArrayList into a JSON.
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/getCountry")
	public ArrayList<Country> getCountry() {
		ArrayList<Country> a = new ArrayList<Country>();
		a = new CountryDao().findAll();
		return a;
	}

	/**
	 * This method get the Country name by the code.
	 * 
	 * @param countryCode
	 *            The Country code.
	 * @return Country class which contains the country name and code.
	 */
	public Country getCountry(String countryCode) {
		Country found = null;
		for (Country country : countries.findAll())
			if (country.getCoCode().equals(countryCode))
				found = country;
		return found;
	}

	/**
	 * This method gets the indicators information by IndicatorDao object.
	 * 
	 * @return An ArrayList parameterized with Indicator that allows to Google
	 *         convert the ArrayList into a JSON
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/getIndicator")
	public ArrayList<Indicator> getIndicator() {
		ArrayList<Indicator> a = new ArrayList<Indicator>();
		a = new IndicatorDao().findAll();
		return a;
	}

	/**
	 * This method gets the data using the indicator, minValue, maxValue and
	 * countries like a filter between the data and the requested data.
	 * 
	 * @param indicator
	 *            Indicator code used to filter the data. If doesn't exists into the
	 *            request, uses as default value "BG.GSR.NFSV.GD.ZS".
	 * @param minValue
	 *            Initial year used to filter the data. If doesn't exists into the
	 *            request, uses as default value "1960".
	 * @param maxValue
	 *            Final year used to filter the data. If doesn't exists into the
	 *            request, uses as default value "2016".
	 * @param countries
	 *            ArrayList parameterized with String which contains the country or
	 *            countries required to filter the data. If doesn't exists into the
	 *            request, uses as default value "MEX".
	 * @return An ArrayList parameterized with Result class that allows to Google
	 *         convert the Map into a JSON.
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/getDataBank")
	public ArrayList<Result> getDataBank(
			@RequestParam(value = "indicator", defaultValue = "BG.GSR.NFSV.GD.ZS") String indicator,
			@RequestParam(value = "minValue", defaultValue = "1960") Integer minValue,
			@RequestParam(value = "maxValue", defaultValue = "2016") Integer maxValue,
			@RequestParam(value = "countries", defaultValue = "MEX") ArrayList<String> countries) {
		minValue = (minValue < 1960 || minValue > 2016) ? 1960 : minValue;
		maxValue = (maxValue < 1960 || maxValue > 2016) ? 2016 : maxValue;
		ArrayList<Activity> activity = new ArrayList<Activity>();
		activity = ar.getByIndicator(ar.getList(), indicator);
		activity = ar.getByCountries(activity, countries);
		ArrayList<Result> data = new ArrayList<Result>();
		ArrayList<Coords> year = null;
		for (Activity a : activity) {
			year = ar.getByYears(a, minValue, maxValue);
			data.add(new Result(getCountry(a.getAcCoCode()).getCoName(), year));
		}
		return data;
	}
}