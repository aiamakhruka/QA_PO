import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Po {

    @Test
    public void  create(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();

        driver.findElement(By.linkText("Create PO")).click();

        Select Po_NO = new Select(driver.findElement(By.name("POopco")));
        Po_NO.selectByVisibleText("TORxax");

        driver.findElement(By.name("Orderedby")).sendKeys("Aia777");
        String PO_name =    driver.findElement(By.name("Orderedby")).getAttribute("value");


        Select OP_Co = new Select(driver.findElement(By.name("OpCo")));
        OP_Co.selectByIndex(2);

        driver.findElement(By.name("up_reason")).sendKeys("Building hospitals");

        driver.findElement(By.name("firstinput")).sendKeys("01/01/2025");

        Select Supplier = new Select(driver.findElement(By.name("Supplier")));
        Supplier.selectByIndex(3);

        Select 	Shipping_Address = new Select(driver.findElement(By.name("shipping")));
        Shipping_Address.selectByIndex(1);

        Select 	Billing_Address = new Select(driver.findElement(By.name("billing")));
        Billing_Address.selectByIndex(0);

        driver.findElement(By.name("Item1")).sendKeys("bandage");
        driver.findElement(By.name("PartNo1")).sendKeys("35y57");
        driver.findElement(By.name("ModelNo1")).sendKeys("sh5hdr");
        driver.findElement(By.name("Quantity1")).sendKeys("56");
        driver.findElement(By.name("Uprice1")).sendKeys("2388");

        driver.findElement(By.name("submit")).click();

        WebElement new_class = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[2]/td/div/table/tbody[1]/tr/td/table[5]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody[2]/tr[1]/td[3]"));

        String New_class_string = new_class.getText();

        if (New_class_string.equalsIgnoreCase(PO_name)){
            System.out.println("PO was created");
        }
        else{
            System.out.println("PO faild being created");

        }
    }
}
