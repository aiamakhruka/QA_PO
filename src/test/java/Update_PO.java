import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Update_PO {

    /////////////////////////////Question?????????????????????????????????
    @Test
    public void update(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();

        driver.findElement(By.linkText("TORxax2014-430")).click();

//        WebElement  before_update = driver.findElement(By.name("up_reason")); ?????

        String before_update = driver.findElement(By.name("edt_reason")).getAttribute("value");
//
        System.out.println(before_update);
//        System.out.println(before_update);
        driver.findElement(By.name("edt_reason")).clear();
        driver.findElement(By.name("edt_reason")).sendKeys("Building apartments");

        driver.findElement(By.name("submit")).click();

        driver.findElement(By.linkText("TORxax2014-430")).click();



        /////////////////////////////Question?????????????????????????????????

        String after_update = driver.findElement(By.name("edt_reason")).getAttribute("value");
        System.out.println(after_update);

        if (before_update.equals(after_update)){
            System.out.println("it wasn't updated");
        }
        else{
            System.out.println("it was updated");

        }



    }
}

