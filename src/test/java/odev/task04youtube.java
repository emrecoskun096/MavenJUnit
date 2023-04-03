package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class task04youtube {
//    1)https://www.youtube.com adresine gidin
//    2)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//=> Sayfa başlığının “YouTube” oldugunu test edin
//=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
//○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//            ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void test02() {
        WebElement logo = driver.findElement(By.id("logo-icon"));
        assertTrue(logo.isDisplayed());
    }

    @Test
    public void test03() {
        WebElement searchbox = driver.findElement(By.xpath("//input[@name='search_query']"));
        assertTrue(searchbox.isEnabled());

    }
    //  ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        String expectedTitle="youtube";
        assertFalse(actualTitle.contains(expectedTitle));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
