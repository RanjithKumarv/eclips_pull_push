package Home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PacketCheckMirror {

	public static void main(String[] args) throws InterruptedException{
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\chromedriver_win32 (6)\\\\chromedriver.exe");
		Scanner scn=new Scanner(System.in);//asking for user input
		System.out.println("Enter a date ");
		int b=scn.nextInt();//capturing user data in b
		String a=Integer.toString(b);//converting integer data type to string data type
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://159.89.175.58:8081/USWMDEMO/"); //http://159.89.175.58:8081/USWMDEMO_report/, //http://159.89.175.58:8081/USWMDEMO_reports/
		Thread.sleep(1000);
		
		driver.findElementById("uname").sendKeys("admin");//sendKeys("admin");sendKeys("Soorya");
		
		driver.findElementById("pass").sendKeys("Unizen@123");//sendKeys("Unizen@123");sendKeys("Admin@!23");
		
		driver.findElementById("signin").click();
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Here we are selecting Dashboard option
		driver.findElementByLinkText("Dashboard").click();
		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        //Here we are selecting date
        Thread.sleep(5000);
		driver.findElementById("dayreportfordate").click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td[contains(text(),"+a+")]")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //Creating an empty list
		  ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
		
		//Clicking on select block
		driver.findElementById("filterapartmentselect").click();
				
		WebElement dropdown=driver.findElementById("filterapartmentselect");
		String dropdown1=dropdown.getText();
		
		
		System.out.println(dropdown1);
				
		Select select= new Select(dropdown);
		Thread.sleep(1000);
		for(int j=6;j<=6;j++) {
		select.selectByIndex(j);
		Thread.sleep(1000);
		
		//Clicking on the Devices present in a particular block
				Select apartment=new Select(driver.findElement(By.id("filterblockselect")));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 //apartment.selectByIndex(4);
				 List<WebElement> ddoptions=apartment.getOptions();
				 int size=ddoptions.size();
				 for(int i=1;i<size;i++) {
				    	Thread.sleep(1000);
				    	  ddoptions.get(i).click();
				    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				    	 String optionname=ddoptions.get(i).getText();
				    	//optionname.
				    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				    	System.out.println(optionname);
				    	System.out.println("here2");
				    //}
				    	
		 //To select time and consumption at a particular time interval.
				    String verticalXpath="//*[local-name()='svg']//*[name()='circle']";
				    List<WebElement> circleList=driver.findElements(By.xpath(verticalXpath));
				    //count contains the number circles present at any given line graph at any point in time
				    int count=circleList.size();
				    //System.out.println("counts are"+circleList.size());
	     //capturing system date and time
					// Create object of SimpleDateFormat class and decide the format, here i am capturing only system hours value ("HH/mm/ss")
					 DateFormat dateFormat = new SimpleDateFormat("HH");
					 //get current date time with Date()
					 Date date = new Date();
					 // Now format the date
					 String currentHour= dateFormat.format(date); 
					 
					 // Print the Date
					// System.out.println(currentHour);
					 //making hour-1 and converting string to integer
					 int currentHour1=Integer.parseInt(currentHour);
					 //System.out.println(currentHour1);
					 int currentHour2=currentHour1-1;
					 //System.out.println(currentHour2);
					 System.out.println("We are here");
					 //now we are inspecting the total water consumption in every device
					 String waterConsumption= driver.findElement(By.xpath("//*[@id=\"Totalconsumptionoftheday\"]")).getText();
					 //Converting string to int
					 int waterConsumption1=Integer.parseInt(waterConsumption);
					 System.out.println(waterConsumption);
					
					 if(currentHour2>count || waterConsumption1>10000 ) {
					 list.add(optionname);
						 
					 }
						 //else {
						// System.out.println("all the devices are working fine");
					// }
					 
					
					 
					
				          
					// System.out.println(list);      
				    
				
				    
		}		

	}
		
		System.out.println(list);  
		 	
						
}
}


