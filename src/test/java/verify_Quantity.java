import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class verify_Quantity {

    @Test
    public void quantity(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.ezhrs.com/project1/potdb/login.asp");
        driver.findElement(By.name("username")).sendKeys("admin.admin");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("SUBMIT")).click();

        driver.findElement(By.linkText("Create PO")).click();

        Select Po_NO = new Select(driver.findElement(By.name("POopco")));
        Po_NO.selectByIndex(2);

        driver.findElement(By.name("Orderedby")).sendKeys("Aia888");
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

        ///////////item 1/////////////
        driver.findElement(By.name("Item1")).sendKeys("bandage");
        driver.findElement(By.name("PartNo1")).sendKeys("35y57");
        driver.findElement(By.name("ModelNo1")).sendKeys("sh5hdr");
        driver.findElement(By.name("Quantity1")).sendKeys("22");
        driver.findElement(By.name("Uprice1")).sendKeys("10");
        ///////////item 2/////////////
        driver.findElement(By.name("Item2")).sendKeys("bandage2");
        driver.findElement(By.name("PartNo2")).sendKeys("35y57");
        driver.findElement(By.name("ModelNo2")).sendKeys("sh5hdr");
        driver.findElement(By.name("Quantity2")).sendKeys("1");
        driver.findElement(By.name("Uprice2")).sendKeys("30");
        ///////////item 3/////////////
        driver.findElement(By.name("Item3")).sendKeys("bandage3");
        driver.findElement(By.name("PartNo3")).sendKeys("35y57");
        driver.findElement(By.name("ModelNo3")).sendKeys("sh5hdr");
        driver.findElement(By.name("Quantity3")).sendKeys("60");
        driver.findElement(By.name("Uprice3")).sendKeys("1");
        ///////////item 4/////////////
        driver.findElement(By.name("Item4")).sendKeys("bandage4");
        driver.findElement(By.name("PartNo4")).sendKeys("35y57");
        driver.findElement(By.name("ModelNo4")).sendKeys("sh5hdr");
        driver.findElement(By.name("Quantity4")).sendKeys("5");
        driver.findElement(By.name("Uprice4")).sendKeys("30");

//        ///////////item 5/////////////
//        driver.findElement(By.name("Item5")).sendKeys("bandage5");
//        driver.findElement(By.name("PartNo5")).sendKeys("35y57");
//        driver.findElement(By.name("ModelNo5")).sendKeys("sh5hdr");
//        driver.findElement(By.name("Quantity5")).sendKeys("2");
//        driver.findElement(By.name("Uprice5")).sendKeys("10");


        /////storing the price values of all items /////////
        int price1=Integer.parseInt(driver.findElement(By.name("Uprice1")).getAttribute("value"));
        int price2=Integer.parseInt(driver.findElement(By.name("Uprice2")).getAttribute("value"));
        int price3=Integer.parseInt(driver.findElement(By.name("Uprice3")).getAttribute("value"));
        int price4=Integer.parseInt(driver.findElement(By.name("Uprice4")).getAttribute("value"));
        int price5=Integer.parseInt(driver.findElement(By.name("Uprice5")).getAttribute("value"));

        /////storing the quantity values of all items /////////
        int quantity1= Integer.parseInt(driver.findElement(By.name("Quantity1")).getAttribute("value"));
        int quantity2=Integer.parseInt(driver.findElement(By.name("Quantity2")).getAttribute("value"));
        int quantity3=Integer.parseInt(driver.findElement(By.name("Quantity3")).getAttribute("value"));
        int quantity4=Integer.parseInt(driver.findElement(By.name("Quantity4")).getAttribute("value"));
        int quantity5=Integer.parseInt(driver.findElement(By.name("Quantity5")).getAttribute("value"));


        driver.findElement(By.name("submit")).click();

        //////////////////////////////////////////////////////question////////////////////////
        driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[2]/td/div/table/tbody[1]/tr/td/table[5]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody[2]/tr[1]/td[2]/div/table/tbody/tr/td[2]/a[3]")).click();

//        driver.findElement(By.xpath("TORxax2014-434")).click();
        //////////////////////////////////////////////////////question////////////////////////

        String  total_before_tax= driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody[1]/tr[2]/td/div/table[3]/tbody/tr/td/form/table/tbody[1]/tr/td/table/tbody/tr[4]/td/table/tbody/tr[3]/td/table/tbody/tr[11]/td[7]/b/font")).getText();
        int total_before_tax_int = Integer.parseInt(total_before_tax.substring(3,6));
    int  total = (quantity1*price1)+(quantity2*price2)+(quantity3*price3)+(quantity4*price4)+(quantity5*price5);

        System.out.println(total_before_tax_int);

        if (total == (total_before_tax_int)){
            System.out.println("the calculation is correct");
        }
        else{
            System.out.println("The calculation is wrong");

        }

        driver.close();
    }
}
