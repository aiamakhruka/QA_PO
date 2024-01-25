import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log_in {

    @Test
    public void logIn(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();

        String Link = "http://www.ezhrs.com/project1/potdb/POTDB.asp?cmd=main";
                String Link2 =        driver.getCurrentUrl();
        if (Link.equalsIgnoreCase(Link2)){
            System.out.println("Verified succesfully");
        }
        else{
            System.out.println("Verify faild");

        }

    }
}
