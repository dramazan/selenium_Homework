import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zurmo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.zurmo.com/demos/stable/app/index.php/zurmo/default/login");

        String actualTitle = driver.getTitle();
        if(actualTitle.equals("ZurmoCRM - Sign in")){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED");
        }

        WebElement username = driver.findElement(By.xpath("//input[@id='LoginForm_username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='LoginForm_password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[@class='z-label']"));
        WebElement checkBox = driver.findElement(By.xpath("//label[@class='hasCheckBox']"));
        username.sendKeys("super");
        Thread.sleep(1500);
        password.sendKeys("super");
        Thread.sleep(1500);
        checkBox.click();
        Thread.sleep(1500);
        loginButton.click();

        WebElement schedule = driver.findElement(By.xpath("//*[@id=\"calendarHomeDashboard1_35_container\"]/div/table/tbody/tr[5]/td[4]"));
        schedule.sendKeys("hello");

    }
}
