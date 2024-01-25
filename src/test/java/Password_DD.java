import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Password_DD {

    @Test (dataProvider = "pass_negative_cases")
    public void create( String password) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("SUBMIT")).click();
        driver.findElement(By.linkText("here")).click();
        driver.close();

    }

    @DataProvider(name= "pass_negative_cases")
    public Object [] password (){
        Object [] pass = new Object[6];

        pass[0]="1234567";
        pass[1]="@#$%^&*";
        pass[2]="WELCOME";  /// bug test faild
        pass[3]=" welcome";
        pass[4]="";
        pass[5]="hellohi";

        return pass;
    }
}
