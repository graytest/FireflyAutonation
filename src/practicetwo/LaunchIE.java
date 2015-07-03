package practicetwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class LaunchIE {
	
  private WebDriver iewb=null;
  private DesiredCapabilities caps=null;
  private String projectpath=System.getProperty("user.dir");
  
  @Test
  public void searchOnBaidu() {
	
	  iewb.get("http://www.baidu.com");
  }
  
  
  @BeforeClass
  public void startIE() {
	   
	  System.setProperty("webdriver.ie.driver", projectpath+"\\tools\\IEDriverServer.exe");
	  caps=DesiredCapabilities.internetExplorer();
	  caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
	  caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
      caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, "true");
      caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

      iewb=new InternetExplorerDriver(caps);
  }

  @AfterClass
  public void releaseIEDriver() {
	  iewb.quit();
  }

}
