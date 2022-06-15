package Home;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Add_date {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver_win32 (2)\\chromedriver.exe");
		int k=4;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter a date ");
		int b=scn.nextInt();
		String a=Integer.toString(b);
		String month="JUNE 2021";
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://159.89.175.58:8081/USWMDEMO/");
		Thread.sleep(1000);
		
		driver.findElementById("uname").sendKeys("admin");
		
		driver.findElementById("pass").sendKeys("Unizen@123");
		
		driver.findElementById("signin").click();
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElementByLinkText("Dashboard").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("dayreportfordate").click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td[contains(text(),"+a+")]")).click();
		
		//if (b<=k) {
		
		while(true) {	
		String text=driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")).getText();
		System.out.println(text);
		if (text.equals(month)) {
			
			break;
			
		}
		
		else {
			
			driver.findElementByClassName("next").click();
		}
		
		}
		}
		//else {
			
			
		//}
		
//	}

	}


