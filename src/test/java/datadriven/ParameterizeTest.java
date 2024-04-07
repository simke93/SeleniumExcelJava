package datadriven;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Xls_Reader;

public class ParameterizeTest {

    public static void main(String[] args) {

        //webdriver code:
        WebDriverManager.chromedriver().setup();// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();// Use the driver to navigate to a webpage
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//Data Driven Approach(Parameterization) -- used to create data driven framework: driving the data from excel files
        //get test data from excel:
        Xls_Reader reader = new Xls_Reader("C:/Users/P52s-Workstation/IT Akademija vezbanje " +
                "QA/java_programs/DDFSeleniumExcel/DDFSeleniumExcel/src/test/java/testdata" +
                "/HalfTestData.xlsx");
        int rowCount = reader.getRowCount("RegTestData");

        reader.addColumn("RegTestData", "Status");

        //parameterization
        for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
            System.out.println("===================");
            String firstName = reader.getCellData("RegTestData", "firstname",rowNum);
            System.out.println(firstName);

            String lastName = reader.getCellData("RegTestData", "lastname",rowNum);
            System.out.println(lastName);

            String email = reader.getCellData("RegTestData", "email",rowNum);
            System.out.println(email);

            String telephone = reader.getCellData("RegTestData", "telephone",rowNum);
            System.out.println(telephone);

            String password = reader.getCellData("RegTestData", "password",rowNum);
            System.out.println(password);

            String passwordConfirm = reader.getCellData("RegTestData", "passwordconfirm",rowNum);
            System.out.println(passwordConfirm);


            driver.findElement(By.id("input-firstname")).clear();
            driver.findElement(By.id("input-firstname")).sendKeys(firstName);

            driver.findElement(By.id("input-lastname")).clear();
            driver.findElement(By.id("input-lastname")).sendKeys(lastName);

            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(email);

            driver.findElement(By.id("input-telephone")).clear();
            driver.findElement(By.id("input-telephone")).sendKeys(telephone);

            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password")).sendKeys(password);

            driver.findElement(By.id("input-confirm")).clear();
            driver.findElement(By.id("input-confirm")).sendKeys(passwordConfirm);

            reader.setCellData("RegTestData", "Status", rowNum, "Pass"); //write the data into a
            // cell



        }

        driver.quit();

    }


}
