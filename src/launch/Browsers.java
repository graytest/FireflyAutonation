package launch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	  public WebDriver driver=null;
	  private DesiredCapabilities caps=null;
	  private FirefoxProfile firefoxprofile=null;
	  private String projectpath=System.getProperty("user.dir");
	  
	  
	 public Browsers(BrowsersType browserstype){
		switch(browserstype){
		case firefox:
			  File firebug=new File(projectpath+"\\tools\\firebug-2.0.11-fx.xpi");
			  File firepath=new File(projectpath+"\\tools\\firepath-0.9.7.1-fx.xpi");
			  firefoxprofile=new FirefoxProfile();
			  
			  try{
				  firefoxprofile.addExtension(firebug);
				  firefoxprofile.addExtension(firepath);
				  firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true");
				  firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.11");
				  
			  }catch(IOException e){
				  e.printStackTrace();
			  }
			driver=new FirefoxDriver(firefoxprofile);
			driver.manage().window().maximize();
			break;
		case ie:
			  System.setProperty("webdriver.ie.driver", projectpath+"\\tools\\IEDriverServer.exe");
			  caps=DesiredCapabilities.internetExplorer();
			  caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			  caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		      caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, "true");
		      caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		      driver=new InternetExplorerDriver(caps);
		      driver.manage().window().maximize();
			  break;
		case chrome:
			  System.setProperty("webdriver.chrome.driver", projectpath+"\\tools\\chromedriver.exe");
			  caps=DesiredCapabilities.chrome();
			  caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //��������browser
			  driver=new ChromeDriver(caps);
			  driver.manage().window().maximize();
			break;
		}
	}

}
