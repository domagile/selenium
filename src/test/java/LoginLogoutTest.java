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

        // check that logout was successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()[contains(.,'My Account')]]")));
    }
}