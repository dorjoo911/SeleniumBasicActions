package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.echoecho.com/htmlforms11.htm");
        WebElement drpFoodEle = driver.findElement(By.name("dropdownmenu"));
        Select drpFood = new Select(drpFoodEle);

//        drpFood.selectByVisibleText("Cheese");
//        drpFood.selectByIndex(2);
//        //drpFood.selectByValue(1);

        //Selecting option from dropdown without using methods

        List<WebElement> alloptions =drpFood.getOptions();
        for (WebElement option:alloptions) {
           if( option.getText().equals("Milk")){
               option.click();
               System.out.println("Is Milk option selected? " + option.isSelected());
               break;
           }
        }

    }
}
