package core;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	WebDriver driver; 
	
	public SignUpPage(WebDriver wd) {
		
		driver = wd;
	}
	
	@FindBy(id = BasePage.firstNameField)
	@CacheLookup
	public WebElement firstNameField;
	
	@FindBy(id = BasePage.lastNameField)
	public WebElement lastNameField;
	
	@FindBy(id = BasePage.emailField)
	public WebElement emailField;
	
	@FindBy(id = BasePage.phoneField)
	public WebElement phoneField;
	
	@FindBy(id = BasePage.radioButton_Male)
	public WebElement radioButton_Male;
	
	@FindBy(id = BasePage.radioButton_Female)
	public WebElement radioButton_Female;
	
	@FindBy(id = BasePage.state_SelectList)
	public WebElement state_SelectList;
	
	@FindBy(id = BasePage.toaCheckbox)
	public WebElement toaCheckbox;
	
	@FindBy(id = BasePage.submitButton)
	public WebElement submitButton;
	
	@FindBy(id = BasePage.errorLine)
	public WebElement errorLine;
	
	@FindBy(id = BasePage.currentLocation)
	public WebElement currentLocation;
	
	@FindBy(id = BasePage.quote)
	public WebElement quote;
		
    public String verify_HTML_title(){
					
			String title_sign_up_actual = driver.getTitle();
			return title_sign_up_actual;
               
					
	}
    
    public void submit_form(String first_name, String last_name, String email, String phone_number, String gender,String state, String terms ){
    	
    	firstNameField.sendKeys(first_name);
    	lastNameField.sendKeys(last_name);
    	emailField.sendKeys(email);
    	phoneField.sendKeys(phone_number);
    	if (gender.equals("Male")){
    		radioButton_Male.click();
    	}
    	else{
    		radioButton_Female.click();
    	}
    	Select select = new Select(state_SelectList);
    	select.selectByVisibleText(state);
    	
    	if (terms.equals("Checked")) {
    		toaCheckbox.click();
    	}
    	
    	submitButton.click();
    	
    	
    }
    
    public String verify_error_handling(String first_name){
    	
    	firstNameField.sendKeys(first_name);
    	submitButton.click();
    	String errorMessage = errorLine.getText();
    	return errorMessage;
    }
    
    public String  verify_content(){
    	
    	return currentLocation.getText();
    	
    	
    	
    }
    
    public String verify_content_quotes() throws IOException{
    
    	return quote.getText();
    	 
    	
    }

				
}
		
	
//end

