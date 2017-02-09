package core;

import static org.junit.Assert.*;

import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

//import org.testng.*;

public class SignUpTest {

	
		//SignUpPage supage = new SignUpPage(driver);
	    SignUpPage supage = PageFactory.initElements(driver, SignUpPage.class);
        static WebDriver driver = new FirefoxDriver();
		static String baseURL = "http://learn2test.net/qa/apps/sign_up/v1/";
		
		
		@Before
		public  void setUp() throws Exception {
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseURL);
			
		}
		
		@AfterClass
		public  static void tearDown() throws Exception {
			driver.quit();
		}
	
		
		@Test
		public void test_01_verify_HTML_title() {
						
				assertEquals("Page loaded sucessfully", "Welcome to Sign Up v1", supage.verify_HTML_title());
		}
		
		@Test
		public void test_02_verify_content_current_city(){
				
				assertEquals("San Francisco, CA", supage.verify_content());
		}
		
		
		@Test
		public void test_03_verify_content_current_weather(){
				
				assertEquals("64 ℉", supage.verify_content());
		}
		
		
		@Test
		public void test_04_verify_content_date(){
				
				assertEquals("[February 5, 2017]", supage.verify_content());
		}
		
		
		@Test
		public void test_05_verify_content_os(){
				
				assertEquals("OS X 10.11 El Capitan", supage.verify_content());
		}
		
		
		@Test
		public void test_06_verify_content_browser(){
				
				assertEquals("Firefox 50", supage.verify_content());
		}
		
		
		@Test
		public void test_07_verify_link_facebook(){
				
				assertEquals("https://www.facebook.com/", supage.verify_HTML_title());
		}
		
		
		@Test
		public void test_08_verify_link_twitter(){
				
				assertEquals("https://twitter.com/", supage.verify_HTML_title());
		}
		
		
		@Test
		public void test_09_verify_link_flick(){
				
				assertEquals("https://www.flickr.com/", supage.verify_HTML_title());
		}
		
		
		@Test
		public void test_10_verify_link_youtube(){
				
				assertEquals("https://www.youtube.com/", supage.verify_HTML_title());
		}
		
		
		@Test
		public void test_11_verify_submit_form() throws InterruptedException{
			
			supage.submit_form("Alex", "Moore", "alexmoore@gmail.com", "415 555-1212", "Male", "California", "Checked");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			assertEquals("Form sucessfully submited", "Confirmation", supage.verify_HTML_title());
		}
		
		
		@Test
		public void test_12_verify_error_handling_face_first_name(){
		
		assertEquals("Error message is displayed", "Invalid First Name: [a-zA-Z,.'-]{3,30}", supage.verify_error_handling("O"));
		}
		
		
		@Test
		public void test_13_verify_error_handling_face_last_name(){
		
		assertEquals("Error message is displayed", "Invalid Last Name: [a-zA-Z,.'-]{3,30}", supage.verify_error_handling("O"));
		}
		
		
		@Test
		public void test_14_verify_error_handling_email(){
		
		assertEquals("Error message is displayed", "Invalid Email Address: xx[min2]@x[min1].xx[2-6]", supage.verify_error_handling("O"));
		}
		
		
		@Test
		public void test_15_verify_error_handling_phone_number(){
		
		assertEquals("Error message is displayed", "Invalid Phone Number: should be 10 digits", supage.verify_error_handling("O"));
		}
		
		
		@Test
		public void test_16_verify_conirmation_page(){
		
		assertEquals("Confirmation", "First Name, Last Name, Email Address, Phone values", supage.verify_content());
		}
		
		
		@Test 
		public void test_17_verify_content_quotes() throws IOException {
			
			//FileReader filereader = new FileReader("/Users/VitaliyArcho/Documents/Workspace/Page_Object_Model/src/main/resources/TestData/quotes.txt");
			FileReader filereader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/TestData/quotes.txt");
			BufferedReader bfreader = new BufferedReader(filereader);
	    	String instring;
	    	final List <String> quotes = new ArrayList<String>();
	    	while((instring = bfreader.readLine()) !=null) {
	    		
	    		quotes.add(instring);
	    			    		 
	    	}
	    	
	    	filereader.close();
			
			boolean  quoteMatch = false;
			
			
			
			if (quotes.contains(supage.verify_content_quotes())){
				
				quoteMatch = true; 
				
			
					
				}
			
			else{
				
	
			}
			
		
			assertEquals(true, quoteMatch);
		}
		
		
		
		

	}



