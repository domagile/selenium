package tutby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Opens vacancies for QA on tut.by
 */
public class TutbyJobChecker
{
    public static void main(String[] args)
    {
        String baseURL = "https://www.tut.by";
        String position = "QA Engineer";

        //add chromedriver to path or uncomment
        //System.setProperty("webdriver.chrome.driver", "c:/app/webdriver/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()[contains(.,'Все вакансии')]]")));
        driver.findElement(By.xpath("//span[text()[contains(.,'Все вакансии')]]")).click();

        //switch to newly opened window
        List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()[contains(.,'Найден')]]")));

        driver.findElement(By.name("text")).sendKeys(position);
        driver.findElement(By.xpath("//span[text()[contains(.,'Найти')]]")).click();
    }
}
