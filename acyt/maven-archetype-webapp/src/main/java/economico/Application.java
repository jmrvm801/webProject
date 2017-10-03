package economico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class define the start application which invokes the Spring app.
 * @author Fernando
 * @version 1.0
 * 
 */
@SpringBootApplication
public class Application {
	
	/**
	 * This method allows the java app.
	 * @param args The arguments to control the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}