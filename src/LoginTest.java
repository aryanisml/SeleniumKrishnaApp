import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class LoginTest {
	WebDriver driver;
	LoginModel loginModel;
	LoginPage loginInfo;
	
	LoginTest(){
		 loginModel= new LoginModel();
		 

        String workingDir = System.getProperty("user.dir");
        File filePath = new File(workingDir + File.separator);
        System.setProperty("webdriver.gecko.driver",filePath+File.separator+"geckodriver.exe");
	     driver = new FirefoxDriver();
	     loginInfo=PageFactory.initElements(driver, LoginPage.class );
	    	
	}
	
    
  @Test(priority=1)
  public void LoginSuccess() {
	 Assert.assertEquals(driver.getCurrentUrl(), loginModel.getUrl()+'/');
  }
  
  
  @Test(priority=2)
  public void EmailElementdisplay(){
	  Assert.assertEquals(true, loginInfo.EmailElementdisplay());
  }
  
  @Test(priority=3)
  public void ValidateMobileNumber(){
	  Assert.assertEquals(true, loginInfo.ValidMobileNumber(loginModel.getmobilenumber()));
  }
  

  @Test(priority=4)
  public void ValidateEmail(){
	  Assert.assertEquals(true, loginInfo.ValidEmailId(loginModel.getEmail()));
  }
  
 // ValidEmailId
  
  
  @Test(priority=4)
  public void SignUpStart(){
	  loginInfo.LoginStart(loginModel);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	    String loginDetail=ReadToString(loginModel.getFileName());
		String[] loginDetails= loginDetail.split(";");
		
		loginModel.setName(loginDetails[0]);
	    loginModel.setEmail(loginDetails[1]);
	    loginModel.setMobilenumber(loginDetails[2]);
	 	loginModel.setCity(loginDetails[3]);
        loginModel.setCountry(loginDetails[4]);
        loginModel.setBranch(loginDetails[5]);
        //loginModel.setMessage(loginDetails[6]);
	 	
	    driver.get(loginModel.getUrl());
	
  }

  @AfterTest
  public void afterTest() {
	  if(driver!=null){
		  driver.close();
		  driver.quit();
	  }
  }
  
	 public static String ReadToString(String FileToText)
	    {
	        StringBuilder contents=new StringBuilder();
	        String workingDir = System.getProperty("user.dir");
	        File filePath = new File(workingDir + File.separator);
	        System.out.println(filePath);

	        try
	        {
	            BufferedReader br = new BufferedReader(new FileReader(filePath+File.separator+FileToText));
	            String s;

	            while ((s = br.readLine()) != null) {
	                contents.append(s);
	            }

	        } catch (IOException e) {
	            System.out.println("Cannot read the text file");
	        }
	        return contents.toString();
	    }


}
