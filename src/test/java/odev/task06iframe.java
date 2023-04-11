package odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class task06iframe extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz


    @Test
    public void test01(){
// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ ");



// ikinci emojiye tıklayın
      driver.switchTo().frame(1);
      driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

// İkinci emoji öğelerini yazdırınız
driver.findElement(By.xpath("//div[@id='nature']"));




// Parent iframe e geri donun
        driver.switchTo().parentFrame();


// Formu doldurun,(Formu istediğiniz metinlerle doldurun)



// Apply button a basiniz



    }
}
