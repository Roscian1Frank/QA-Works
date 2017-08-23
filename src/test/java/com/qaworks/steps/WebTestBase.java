package com.qaworks.steps;


import com.qaworks.helpers.Log;
import com.qaworks.helpers.WebCommonAction;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;



public class WebTestBase extends WebCommonAction{

	public static WebDriver driver;
	private static String chromeDriverMacPath = System.getProperty("user.dir")
			+ "/src/test/resources/chromeDriver/mac/chromedriver";
	private static String geckoDriver = System.getProperty("user.dir")
			+ "/src/test/resources/chromeDriver/mac/geckodriver";

	@Before

	public void startApp() throws IOException, ParseException{
			System.setProperty("webdriver.chrome.driver", chromeDriverMacPath);
			driver = new ChromeDriver();
			Point targetPosition = new Point(0, 0);
			driver.manage().window().setPosition(targetPosition);
			Dimension targetSize = new Dimension(1920, 1080);
			driver.manage().window().setSize(targetSize);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Log.info("********************** -- TEST START -- **************************");
			System.out.println("reaching hooks / local");
	}

	@After
	public void closeApp(Scenario scenario) throws IOException, URISyntaxException {

		if (scenario.isFailed()) {
			try {
				System.out.println("Failed scenario ----->> "+scenario.getSourceTagNames());
				Log.info(("Failed scenario ----->> "+scenario.getSourceTagNames()));
				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				Log.info("********************** -- TEST STOPPED ERROR OCCURED -- **************************");

			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		}
		System.out.println("Reaching Closing BaseDriver");
		Log.info("********************** -- TEST END -- **************************");
		driver.quit();
	}

}
