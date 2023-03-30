package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


//    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
 static WebDriver driver;

    @BeforeClass
public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    //-Before methodunda http://www.google.com adresine gidin
    @Before

    public void setup1(){
        driver.get("http://www.google.com");
    }




//            -Üç farklı test methodu ile;
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The God Father"+ Keys.ENTER);
      WebElement sonuc1= driver.findElement(By.xpath("//div[@id='result-stats']"));
      String arr[]=sonuc1.getText().split(" ");
        System.out.println("sonuc1 sayisi "+arr[1]);
    }


//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Lord of the Rings"+ Keys.ENTER);
    WebElement sonuc2= driver.findElement(By.xpath("//div[@id='result-stats']"));
        String arr[]=sonuc2.getText().split(" ");
        System.out.println("sonuc2 sayisi "+arr[1]);
    }

//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Kill Bill"+ Keys.ENTER);
        WebElement sonuc3= driver.findElement(By.xpath("//div[@id='result-stats']"));
        String arr[]=sonuc3.getText().split(" ");
        System.out.println("sonuc3 sayisi "+arr[1]);

    }
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
    @After
    public void tearDown(){




    }


//-AfterClass ile kapatın
@AfterClass
    public static void tearDown1(){
        driver.close();
}


}
