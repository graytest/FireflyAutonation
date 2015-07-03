package practicetwo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class LaunchFirefox {
	
  private WebDriver ffwb=null;
  private FirefoxProfile firefoxprofile=null;
  private String projectpath=System.getProperty("user.dir");
  
  @Test
  public void searchOnBaidu() {
      ffwb=new FirefoxDriver(firefoxprofile);
	//  ffwb.get("http://login.providerlink.healthcare.stg.covisint.com/providerlink");
      ffwb.get("http://www.baidu.com");
  }
  
  
  @BeforeClass
  public void startFirefox() {  
	 // System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
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
	  
  }

  @AfterClass
  public void releaseFirefoxDriver() {
	  ffwb.quit();
  }

}
