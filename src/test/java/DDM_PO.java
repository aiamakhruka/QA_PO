import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDM_PO {

    @Test
    public void DDM(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();

        driver.findElement(By.linkText("Create PO")).click();


        Select Po_NO = new Select(driver.findElement(By.name("POopco")));
        for (WebElement option :Po_NO.getOptions()){
            System.out.println(option.getText());
        }

        System.out.println("_________________________________________");

        Select OP_Co = new Select(driver.findElement(By.name("OpCo")));
        for (WebElement option :OP_Co.getOptions()){
            System.out.println(option.getText());
        }

        System.out.println("_________________________________________");

        Select Supplier = new Select(driver.findElement(By.name("Supplier")));
        for (WebElement option :Supplier.getOptions()){
            System.out.println(option.getText());
        }

        System.out.println("_________________________________________");
        Select 	Shipping_Address = new Select(driver.findElement(By.name("shipping")));
        for (WebElement option :Shipping_Address.getOptions()){
            System.out.println(option.getText());
        }
        System.out.println("_________________________________________");

        Select 	Billing_Address = new Select(driver.findElement(By.name("billing")));
        for (WebElement option :Billing_Address.getOptions()){
            System.out.println(option.getText());
        }
    }
}
