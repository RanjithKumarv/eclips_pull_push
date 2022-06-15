package Home;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\ChromeDrivernew\\chromedriver_win32 (4)\\chromedriver.exe");
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
		
		//Clicking on select block
		driver.findElementById("filterapartmentselect").click();
		
		WebElement dropdown=driver.findElementById("filterapartmentselect");
		System.out.println("here1");
		
		Select select= new Select(dropdown);
		Thread.sleep(1000);
		for(int j=1;j<=6;j++) {
		select.selectByIndex(j);
		Thread.sleep(1000);
		
		//Clicking on the Devices present in a particular block
		Select apartment=new Select(driver.findElement(By.id("filterblockselect")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 apartment.selectByIndex(4);
		 List<WebElement> ddoptions=apartment.getOptions();
		 int size=ddoptions.size();
		 for(int i=0;i<size;i++) {
		    	Thread.sleep(1000);
		    	  ddoptions.get(i).click();
		    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    	 String optionname=ddoptions.get(i).getText();
		    	//optionname.
		    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    	System.out.println(optionname);
		    //}
		
		
		
	}

}
}
}
