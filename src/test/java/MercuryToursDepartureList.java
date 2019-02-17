import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MercuryToursDepartureList {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        1. Open browser
        2. Go to http://www.newtours.demoaut.com/
        3. Login using username tutorial and password tutorial
        4. Verify default Departing From value is Acapulco
        5. Verify list of locations: Acapulco, Frankfurt, London, New York,
        Paris, Portland, San Francisco, Seattle, Sydney, Zurich
        6. Test Departing From dropdown functionality by changing different values
        */

        driver.get("http://www.newtours.demoaut.com/");
        WebElement username = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        username.sendKeys("tutorial");
        Thread.sleep(2000);
        password.sendKeys("tutorial");
        login.click();

        List<WebElement> departureList = driver.findElements(By.name("fromPort"));
        for(int i = 0; i < departureList.size(); i++){
            System.out.print(departureList.get(i).getText().trim());
        }

       }
}
