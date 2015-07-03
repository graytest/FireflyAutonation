package practicetwo;


import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class LaunchChrome {
	
  private WebDriver chromewb=null;
  private DesiredCapabilities caps=null;
  private String projectpath=System.getProperty("user.dir");
  
  @Test
  public void searchOnBaidu() {
	  chromewb=new ChromeDriver(caps);
	  chromewb.get("http://www.baidu.com");
  }
  
  
  @BeforeClass
  public void startChrome() {
	   
	  System.setProperty("webdriver.chrome.driver", projectpath+"\\tools\\chromedriver.exe");
	  caps=DesiredCapabilities.chrome();
	  caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //×î´ó»¯ä¯ÀÀÆ÷browser

  }

  @AfterClass
  public void releaseChromeDriver() {
	  chromewb.quit();
  }

}
