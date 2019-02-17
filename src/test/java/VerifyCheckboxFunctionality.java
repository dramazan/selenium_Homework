import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCheckboxFunctionality {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        1. Open browser
        2. Go to http://the-internet.herokuapp.com/checkboxes
        3. Verify the first checkbox is not selected
        4. Verify the second checkbox is selected
        5. Click on the first checkbox
        6. Verify the first checkbox is selected
        7. Verify the second checkbox is selected
        8. Click on the second checkbox
        9. Verify the first checkbox is selected
        10. Verify the second checkbox is not selected
        */

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        //WebElement checkBox1 = driver.findElement(B)

    }
}
