package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
    
    public static void logIn() throws Exception {
    	
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://web.yammer.com/main/org/capgemini.com/feed");
		driver.manage().window().maximize();
		
		//login 
    	Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]"))
				.sendKeys("soumyadeep.roychoudhury@capgemini.com" + Keys.ENTER);
		
		Thread.sleep(20000);

		driver.findElement(By.xpath("//*[@id=\"signOnButton\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
    }

}