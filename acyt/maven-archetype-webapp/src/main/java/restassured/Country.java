package restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import com.jayway.restassured.RestAssured;

public class Country {
	/**
	 * This method validates that the restful server contains as a response the MEX
	 * & USA Country Codes
	 */
	@Test
	public void test_allCountries_shouldBeContainMexUsa() {
		RestAssured.baseURI = "http://localhost:8888";
		given().when().get("/getCountry").then().body("coCode", hasItems("MEX", "USA"));
	}

	/**
	 * This method validates that the restful server contains as a response the
	 * "BG.GSR.NFSV.GD.ZS" & "NY.ADJ.SVNX.CD" Indicator Codes
	 */
	@Test
	public void test_allIndicator_shouldBeContainSomeIndicators() {
		RestAssured.baseURI = "http://localhost:8888";
		given().when().get("/getIndicator").then().body("inCode", hasItems("BG.GSR.NFSV.GD.ZS", "NY.ADJ.SVNX.CD"));
	}

	/**
	 * This method validates that the restful server contains as a response the
	 * Mexico Key when the country Code is MEX.
	 */
	@Test
	public void test_getDataDefault_shouldBeContainMexico() {
		RestAssured.baseURI = "http://localhost:8888";
		given().parameter("countries", "MEX").when().get("/getDataBank").then().body("key", hasItems("Mexico"));
	}

	/**
	 * This method validates that the restful server contains as a response Mexico
	 * and United States when the country code are MEX & USA.
	 */
	@Test
	public void test_getDataByYears_shouldBeContainMexicoUnitedStates() {
		RestAssured.baseURI = "http://localhost:8888";
		given().parameters("countries", "MEX,USA", "minValue", "1985", "maxValue", "2003").when().get("/getDataBank")
				.then().body("key", hasItems("Mexico", "United States"));
	}

	/**
	 * This method validates that the restful server contains as response a 2 size
	 * collection because there are two country codes to looking for information.
	 */
	@Test
	public void test_getDataByCountries_shouldBeContanin2Elements() {
		RestAssured.baseURI = "http://localhost:8888";
		given().parameters("countries", "MEX,USA", "minValue", "1990", "maxValue", "2000").when().get("/getDataBank")
				.then().body("$", hasSize(2));
	}

	/**
	 * This method validates that the restful server contains as response a 57 size
	 * collection because There aren't minValue & maxValue years. So the services
	 * uses a default values (1960, 2016) and recover the data.
	 */
	@Test
	public void test_getDataByCountries_shouldBeContanin57ElementsInYears() {
		RestAssured.baseURI = "http://localhost:8888";
		given().parameter("countries", "MEX,USA").when().get("/getDataBank").then().body("values[0]", hasSize(57));
	}

	/**
	 * This method validates that the restful server contains as a response 1970
	 * because there are a minValue as 1970. So the services recovers the
	 * information since 1970.
	 */
	@Test
	public void test_getDataByCountries_shouldBeContanin1970AsInitialYear() {
		RestAssured.baseURI = "http://localhost:8888";
		given().parameters("countries", "ABW", "minValue", "1970", "maxValue", "2000").when().get("/getDataBank").then()
				.body("values[0][0].x", equalTo(1970));
	}
}