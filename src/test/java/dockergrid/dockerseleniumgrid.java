package dockergrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class dockerseleniumgrid {

	public WebDriver driver ;
	
		// TODO Auto-generated method stub
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserType) throws MalformedURLException
	{		
		DesiredCapabilities cap = new DesiredCapabilities();
		if(browserType.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName(BrowserType.CHROME);	
			System.out.println("#################TEST CASE EXECUION STARTED ON ==> " + browserType );
			
		}
		else if(browserType.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName(BrowserType.FIREFOX);
			System.out.println("#################TEST CASE EXECUION STARTED ON ==> " + browserType );
		}
		else if (browserType.equalsIgnoreCase("edge"))
		{
			cap.setBrowserName(BrowserType.EDGE);
			System.out.println("#################TEST CASE EXECUION STARTED ON ==> " + browserType );
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444") , cap);
		
	}
	
	@Test
	public void googleOnCHROMETest() throws MalformedURLException, InterruptedException
	{
	
	DesiredCapabilities cap = DesiredCapabilities.chrome();
		
	try
	{
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Assertion a = new Assertion();
		a.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(8000);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
	}	
	
	@Test
	public void linkedOnFFTest()
	{
		try
		{
			driver.get("https://www.linkedin.com");
			System.out.println(driver.getTitle());
			Assertion a = new Assertion();
			a.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up");
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void gmailOnEdge()
	{
		try
		{
			driver.get("https://www.gmail.com");
			System.out.println(driver.getTitle());
			Assertion a = new Assertion();
			a.assertEquals(driver.getTitle(), "Gmail");
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		System.out.println("#######TEST CASE EXECUTION ENDED######");
		driver.quit();
		
	}
	
}
