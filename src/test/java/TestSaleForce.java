import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSaleForce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://basic-fit--uat.sandbox.my.salesforce.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("Shari.sasidharannair@basic-fit.com.uat");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("April@2024");
        driver.findElement(By.cssSelector("input[id='Login']")).click();
        Thread.sleep(20000);
        WebElement ele=driver.findElement(By.xpath("//a[@href='/lightning/o/Account/home']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);



    }
}
