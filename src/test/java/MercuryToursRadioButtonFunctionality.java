import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercuryToursRadioButtonFunctionality {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        1. Open browser
        2. Go to http://www.newtours.demoaut.com/
        3. Login using username tutorial and password tutorial
        4. Verify Round Trip is selected by default
        5. Verify One Way is not selected by default
        6. Click one way
        7. Verify Round Trip selected not selected
        8. Verify One Way is selected
        */

        driver.get("http://www.newtours.demoaut.com/");
        WebElement username = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        username.sendKeys("tutorial");
        Thread.sleep(2000);
        password.sendKeys("tutorial");
        Thread.sleep(2000);
        login.click();
        Thread.sleep(2000);
        WebElement roundTrip = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));
        if (roundTrip.isSelected()) {
            System.out.println("PASS - Round Trip selected by default.");
        } else {
            System.out.println("FAIL - Round Trip not selected by default.");
        }
        Thread.sleep(2000);
        WebElement oneWay = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"));
        if (!(oneWay.isSelected())) {
            System.out.println("PASS - One Way selected by default.");
        } else {
            System.out.println("FAIL - One Way not selected by default.");
        }

        oneWay.click();
        Thread.sleep(2000);
        if (!(roundTrip.isSelected())) {
            System.out.println("PASS - Round Trip selected by default.");
        } else {
            System.out.println("FAIL - Round Trip not selected by default.");
        }
        Thread.sleep(2000);
        if (oneWay.isSelected()) {
            System.out.println("PASS - One Way selected by default.");
        } else {
            System.out.println("FAIL - One Way not selected by default.");
        }

        WebElement passengers = driver.findElement(By.name("passCount"));
        Select passengersDropdown = new Select(passengers);
        passengersDropdown.selectByIndex(1);

        WebElement departingFrom = driver.findElement(By.name("fromPort"));
        Select departingFromDropdown = new Select(departingFrom);
        departingFromDropdown.selectByIndex(1);

        WebElement onMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonthDropdown = new Select(onMonth);
        onMonthDropdown.selectByIndex(2);


        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDayDropdown = new Select(onDay);
        onDayDropdown.selectByIndex(9);

        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        Select arrivingInDropdown = new Select(arrivingIn);
        arrivingInDropdown.selectByIndex(3);

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='Business']"));
        serviceClass.click();

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropdown = new Select(airline);
        airlineDropdown.selectByIndex(2);

        WebElement continu = driver.findElement(By.name("findFlights"));
        continu.click();

    }
}
