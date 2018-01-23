import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	@FindBy(how= How.NAME,using="txtfname")
	private WebElement nameField;
	
	@FindBy(how= How.NAME,using="txtfemail")
	private WebElement emailField;
	
	@FindBy(how= How.NAME,using="txtfmobile")
	private WebElement mobileField;
	
	@FindBy(how= How.NAME,using="txtcity")
	private WebElement cityField;
	

	@FindBy(how= How.NAME,using="txtpdest")
	private WebElement countryElement;
	
	@FindBy(how= How.NAME,using="txtnbrach")
	private WebElement branchElement;
	
	
	@FindBy(how= How.NAME,using="txtfmsg")
	private WebElement messageField;
	
	
	@FindBy(how= How.NAME,using="txtagree")
	private WebElement agreeField;
	

	@FindBy(how= How.ID,using="btnSubevnt")
	private WebElement saveField;
	
	
	
	
	public Select getSelectOptions(WebElement element){
		return new Select(element);
	}
	
	public void setOption(String value,WebElement element)
	{
	  getSelectOptions(element).selectByVisibleText(value);
	}

	public String getSelectedOption(WebElement element)
	{
	    return getSelectOptions(element).getFirstSelectedOption().getText();
	}
	
	
	

     public void LoginStart(LoginModel loginModel ){
    	 
    	 nameField.sendKeys(loginModel.getName());
    	 emailField.sendKeys(loginModel.getEmail());
    	 mobileField.sendKeys(loginModel.getmobilenumber().toString());
    	 cityField.sendKeys(loginModel.getCity());
    	 setOption(loginModel.getCountry(), countryElement);
    	 setOption(loginModel.getBranch(), branchElement);
    	// messageField.sendKeys(loginModel.getMessage());
    	 agreeField.click();
    	 saveField.click();
    	 
     }
     
     
     public boolean ValidMobileNumber(String MobileNumber){
    	 String regexStr = "^[0-9\\-]*$";
    	 if(MobileNumber.matches(regexStr)){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     
     public boolean ValidEmailId(String EmailId){
    	 String regexStr = "[a-zA-Z0-9]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z0-9]{3}";
    	 if(EmailId.matches(regexStr)){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
      
     
     
     
     public boolean EmailElementdisplay(){
    	 return emailField.isDisplayed(); 
    	 
     }
	 
	
}
