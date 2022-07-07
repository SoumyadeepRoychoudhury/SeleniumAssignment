package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class PostContents {
	

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Driver Browser\\chromedriver.exe");



WebDriver driver = new ChromeDriver();
driver.get("https://web.yammer.com/main/capgemini.com/");
//driver.manage().window().maximize();
driver.get("https://web.yammer.com/main/capgemini.com/");
Thread.sleep(3000);

driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("soumyadeep.roychoudhury@capgemini.com");

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();


Thread.sleep(20000);

driver.findElement(By.xpath("//*[@id=\"signOnButton\"]")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[2]/div/div/div/div/a/div/div/div[2]/div/div/div/div")).click();

//oneteamonefamily
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[2]/div/div/div/div/a/div/div/div[2]/div/div/div/div"));

//textopen
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div/button/div/div")).click();

//postcontent
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/span/div/div[2]/div/div/div/div")).sendKeys("Hi");

Thread.sleep(3000);
driver.close();
	}
	
	
}