package datadriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Xls_Reader;

public class DataDrivenTest {

    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("C:/Users/P52s-Workstation/IT Akademija vezbanje " +
                "QA/java_programs/DDFSeleniumExcel/DDFSeleniumExcel/src/test/java/testdata" +
                "/HalfTestData.xlsx");

        String firstName = reader.getCellData("RegTestData", "firstname",2);
        System.out.println(firstName);

        String lastName = reader.getCellData("RegTestData", "lastname",2);
        System.out.println(lastName);

        String email = reader.getCellData("RegTestData", "email",2);
        System.out.println(email);

        String telephone = reader.getCellData("RegTestData", "telephone",2);
        System.out.println(telephone);

        String password = reader.getCellData("RegTestData", "password",2);
        System.out.println(password);

        String passwordConfirm = reader.getCellData("RegTestData", "passwordconfirm",2);
        System.out.println(passwordConfirm);

        WebDriverManager.chromedriver().setup();// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();// Use the driver to navigate to a webpage
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        driver.findElement(By.id("input-firstname")).sendKeys(firstName);

        driver.findElement(By.id("input-lastname")).sendKeys(lastName);

        driver.findElement(By.id("input-email")).sendKeys(email);

        driver.findElement(By.id("input-telephone")).sendKeys(telephone);

        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(passwordConfirm);


    }

}

