import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


public class username_PO_DD {
    @Test(dataProvider="user_negative_cases")
    public void username_DD(String user){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();
        driver.findElement(By.linkText("here")).click();

        driver.close();
    }


    @DataProvider(name="user_negative_cases")
    public Object [] username (){
        Object [] user = new Object[6];

        user[0]="12345.12345";
        user[1]="@#$%^&*@#!#";
        user[2]="ADMIN.ADMIN";  // bug test faild
        user[3]="adminadmin";
        user[4]="";
        user[5]=" admin.admin";

        return user;
    }



}
