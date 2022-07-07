package com.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVWriter;

public class Stocks {

	public static void main(String[] args) throws IOException, InterruptedException {
		while (true) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver","C:\\Driver
		// Browser\\chromedriver.exe");
		// FileWriter file=new
		// FileWriter("C:\\Users\\SROYCHOU\\eclipse-workspace\\StockFetch\\TestFile\\stocks.csv");

		List<String[]> Answers = new ArrayList<String[]>();
		Writer outputFile = new FileWriter("data.csv");
		CSVWriter writer = new CSVWriter(outputFile);
		String[] Header = { "Stocks", "LTP", "%Chg", "Volume", "BuyPrice", "SellPrice", "BuyQty", "SellQty","Date" };
		WebElement Stocks, LTP, Chg, Volume, Buy, Sell, Byqty, sellqty;
		Answers.add(Header);

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		// Print the Date
		// System.out.println("Current date and time is " +date1);

		

			System.setProperty("webdriver.chrome.driver", "C:\\Driver Browser\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.moneycontrol.com/markets/indian-indices/");

			// List<WebElement>
			// tabs=driver.findElements(By.xpath("//a[@class=\"robo_medium\"]"));
			// List<WebElement>
			// prices=driver.findElements(By.xpath("//td[@class=\"tbl_redtxt\"]"));

			Thread.sleep(5000);

			for (int i = 1; i <= 20; i++) {
				Stocks = driver.findElement(By.xpath("//*[@id=\"indicesTable\"]/tbody/tr[" + i + "]/td[1]/a"));

				LTP = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[2]"));

				Chg = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[3]"));

				Volume = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[4]"));

				Buy = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[5]"));

				Sell = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[6]"));

				Byqty = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[7]"));

				sellqty = driver.findElement(By.xpath(
						"/html/body/section/div/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div[4]/div/div/div[1]/table/tbody/tr["
								+ i + "]/td[8]"));

				Answers.add(new String[] { Stocks.getText(), LTP.getText(), Chg.getText(), Volume.getText(),
						Buy.getText(), Sell.getText(), Byqty.getText(), sellqty.getText(), date1

				});

			}

			writer.writeAll(Answers);

			writer.close();

			driver.close();

			TimeUnit.MINUTES.sleep(10);
		}

	}
}
