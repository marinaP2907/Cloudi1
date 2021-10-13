package packageA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.*;



public class ClassA {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();

		//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get("https://staging.cloudinary.com/users/login");
	    
		//find the relevant attributes
		WebElement Email = driver.findElement(By.id("user_session_email"));
		WebElement Pwd = driver.findElement(By.id("user_session_password"));
		WebElement Signin=driver.findElement(By.id("sign-in"));
	
		//fill in the relevant attributes and sign in
		Email.sendKeys("qa_automation_team+testAccount@cloudinary.com");		
		Pwd.sendKeys("8Qfr%W6RqlPN");
		Signin.click();
		
		//open media Library tab
		WebElement mediaLibrary=driver.findElement(By.cssSelector("a[href='/console/media_library/folders/home']"));
		String link=mediaLibrary.getAttribute("href");		
		//System.out.println(link);
		driver.get(link);
		
		// Click with right-click on the image with the name ‘Home assignment’
		WebElement homeAssignment=driver.findElement(By.cssSelector("article[data-item-index='2']"));		
		Actions actions = new Actions(driver);
		actions.contextClick(homeAssignment).perform();
		
		//Click on the 'Manage' option from the popup
		WebElement manage=driver.findElement(By.cssSelector("div[data-test='item--primary-content']"));
	    manage.click();
	    
	    //Validate that title of the image is ‘Home assignment’
	    WebElement header=driver.findElement(By.cssSelector("input[value='home assignment']"));
	    String header_new=header.toString();	      
	    
	    Boolean bool =header_new.contains("home assignment");
	    if (bool)    
	    	System.out.println("Header equals \"home assignment ");
	    else 
	    System.out.println("Header is not equal \"home assignment\"");

    	
    		
	
		
		//closing the browser
		driver.close();

	}		
	
	

}
