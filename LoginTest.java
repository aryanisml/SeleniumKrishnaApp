import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	System.setProperty("webdriver.gecko.driver","D:\\VSLearning\\geckodriver.exe" );	
    WebDriver driver = new FirefoxDriver();
    
    
  @Test
  public void f() {
	  LoginModel loginModel= new LoginModel();
	    LoginPage loginInfo=PageFactory.initElements(driver, LoginPage.class );
	    loginInfo.LoginStart(loginModel);
	    
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  LoginModel loginModel= new LoginModel();
	    String loginDetail=ReadToString(loginModel.getFileName());
		String[] loginDetails= loginDetail.split(";");
		
		loginModel.setName(loginDetails[0]);
	    loginModel.setEmail(loginDetails[1]);
	 	
	    driver.get(loginModel.getUrl());
	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
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
