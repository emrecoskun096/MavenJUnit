package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class task04dropdown {
    // -Amazon sayfasına gidelim
//-Arama Kutusundaki Dropdown menuyu yazdıralım
//-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
// başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
// Not: Select Class'ı kullanalım
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    @Test
    public void dropMenu() {
        WebElement selectDrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select dropDown = new Select(selectDrop);
        List<WebElement> dropList = dropDown.getOptions();

        dropList.forEach(t -> System.out.println(t.getText()));

    }

    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    @Test
    public void selectIndex() throws InterruptedException {

        for (int i = 1; i <= 5; i++) {
            WebElement selectDrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select dropElement = new Select(selectDrop);
            dropElement.selectByIndex(i);
            Thread.sleep(2000);
            driver.findElement(By.id("nav-search-submit-button")).click();
            System.out.println("sayfa basligi " + driver.getTitle());
            driver.navigate().back();

        }


    }


}
