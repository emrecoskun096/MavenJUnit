package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class first {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

//        Username kutusuna “standard_user” yazdirin
        WebElement usurname = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));
        usurname.sendKeys("standard_user");


//        Password kutusuna “secret_sauce” yazdirin

        WebElement password = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.sendKeys("secret_sauce");


//        Login tusuna basin
        driver.findElement(By.cssSelector("input[type='submit']")).click();

//        Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        System.out.println(urun.getText());
        urun.click();


//        Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//        Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

//        Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetKontrol=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
    if (sepetKontrol.equals(urun.getText())){
        System.out.println("test pass");
    }else System.out.println("test failed");

//        Sayfayi kapatin

driver.close();
//


    }
}
