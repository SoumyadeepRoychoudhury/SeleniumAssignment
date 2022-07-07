import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SeleniumB {
    public static void main(String[] args) throws InterruptedException, IOException  {
         List<String[]> Answers = new ArrayList<String[]>();
         Writer outputFile = new FileWriter("data.csv");
         CSVWriter writer = new CSVWriter(outputFile);
         String[] Header = { "Heading", "Answer", "Views", "Votes" };
         WebElement Heading, Answer, Views, Votes;
         Answers.add(Header);
         System.setProperty("webdriver.chrome.driver","C:\\Driver Browser\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stackoverflow.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='search']/div/input")).sendKeys("java.lang.ArrayIndexOutOfBoundsException"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/button[1]")).click();
        Thread.sleep(1000);
        for(int i = 1; i <= 10 ; i++) {
            Heading = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/h3/a"));

            Answer = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/div[1]"));

            Views = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[3]/span[1]"));

            Votes = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[1]/span[1]"));

            Answers.add(new String[] { Heading.getText(), 
                                        Answer.getText(), 
                                        Views.getText(), 
                                        Votes.getText()}); 
            }

        writer.writeAll(Answers);
        writer.close();
        }
}