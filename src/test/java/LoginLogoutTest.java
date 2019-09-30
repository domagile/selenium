import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class LoginLogoutTest {
    public static void main(String[] args) throws InterruptedException, NoSuchElementException {

        String baseURL = "https://worldofwarcraft.com/en-us/login";
        String email = "domagile@gmail.com";
        String password = "vjzbuhf222";
        String email2 = "cubatarara400@gmail.com";
        String password2 = "vjzbuhf222";
        String email3 = "utestnotification@gmail.com";
        String password3 = "vjzbuhf222";

        //add chromedriver to path or uncomment
        //System.setProperty("webdriver.chrome.driver", "c:/app/webdriver/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()[contains(.,'Log in')]]")));

        driver.findElement(By.id("accountName")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()[contains(.,'Log in')]]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'domagile@')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'domagile@')]]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'Log Out')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'Log Out')]]")).click();

// start email2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'My Account')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'My Account')]]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()[contains(.,'Log In')]]")));
        driver.findElement(By.xpath("//button[text()[contains(.,'Log In')]]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()[contains(.,'Log in')]]")));
        driver.findElement(By.id("accountName")).clear();
        driver.findElement(By.id("accountName")).sendKeys(email2);
        driver.findElement(By.id("password")).sendKeys(password2);
        driver.findElement(By.xpath("//button[text()[contains(.,'Log in')]]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'cubatarara40')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'cubatarara40')]]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'Log Out')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'Log Out')]]")).click();

// start email3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'My Account')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'My Account')]]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'My Account')]]")));
        driver.findElement(By.xpath("//button[text()[contains(.,'Log In')]]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()[contains(.,'Log in')]]")));


        driver.findElement(By.id("accountName")).clear();
        driver.findElement(By.id("accountName")).sendKeys(email3);
        driver.findElement(By.id("password")).sendKeys(password3);
        driver.findElement(By.xpath("//button[text()[contains(.,'Log in')]]")).click();

        // check that login was successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'utestnot')]]")));
    }
}