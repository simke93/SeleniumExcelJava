package datadriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.utility.TestUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class HalfNGTest {


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // Create a new instance of the Chrome driver
        driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");
    }

    @DataProvider
    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
        return testData.iterator();


    }

    @Test(dataProvider="getTestData")
    public void halfEbayRegPageTest(String firstName, String lastName, String email, String password){

        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);

        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);




    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
