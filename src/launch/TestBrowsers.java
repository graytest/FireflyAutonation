package launch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestBrowsers {
	
	 private WebDriver driver;
	
	  @Test
	  public void f() {
	  }
	  @BeforeClass
	  public void beforeClass() {
		  Browsers browser=new Browsers(BrowsersType.firefox);
		  driver=browser.driver;
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
