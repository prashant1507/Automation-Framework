package org.automation.elk;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;
import org.automation.utils.PropertyUtils;
import static io.restassured.RestAssured.*;

/**
 * This class is to display data in real time dashboard
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 9, 2021
 * @author User1
 * @version 1.0
 * 
 */
public final class ELKUtils {
	/**
	 * 
	 * Private constructor to avoid external instantiation
	 * <br>
	 * Apr 9, 2021
	 */
	private ELKUtils() {
	}
	
	/**
	 * This method sends details of test execution to ELK
	 * <br>
	 * Apr 9, 2021
	 * @param testName name of the test case
	 * @param testStatus test case status
	 *
	 */
	public static void sendDetailsToELK(String testName, String testStatus) {
		if (PropertyUtils.get(ConfigProperties.USEELK).equalsIgnoreCase(FrameworkConstants.getYes())) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("TestName", testName);
			map.put("Status", testStatus);
			map.put("ExecutionTime", LocalDateTime.now().toString());
			
			given().header("Content-Type", "application/json")
					.when()
					.body(map)
					.post(PropertyUtils.get(ConfigProperties.ELKSUITEURL));
			
		}
	}
}
