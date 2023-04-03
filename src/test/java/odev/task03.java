package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class task03 {
//
//    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//-Before methodunda http://www.google.com adresine gidin
//            -Üç farklı test methodu ile;
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
//-AfterClass ile kapatın

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() {
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void tearDown() {
        String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı = "+sonuc[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}