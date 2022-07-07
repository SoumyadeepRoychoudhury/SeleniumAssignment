package com.main;

import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MostActiveDay {

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


Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\"Pivot18-Tab1\"]/span/span/span/span")).click();

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/ul/li[3]/div/a/span")).click();;


Thread.sleep(5000);
List<WebElement> graph = driver.findElements(By.xpath("//div[@class='highcharts-container ']//*[name()='svg']//*[local-name()='path' and @class='highcharts-point']"));

// get the attribute value of each element of svg
TreeMap<Integer, String> svgData = new TreeMap<Integer, String>();
for (WebElement ele : graph) {
	// getting the data and spliting it accordingly
	System.out.println("All data ->");
	System.out.println(ele.getAttribute("aria-label"));
	String[] tempArray = ele.getAttribute("aria-label").split("\\W");
	svgData.put(Integer.parseInt(
			tempArray[5]),
			tempArray[2] + " " + tempArray[3]
		);
}
//sorting the data and printing the out put 
Integer[] highest = svgData.keySet().toArray(new Integer[svgData.size()]);
String communityName = "";
System.out.println( communityName);
System.out.println("The Day when user are most active in " + communityName + "is : "+ svgData.get(highest[highest.length - 1]));
System.out.println("And the number of user is: " + highest[highest.length - 1]);

Thread.sleep(2000);
driver.close();

	}

}
