package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
        // getLocation() gives you that element's x & y locations, getSize() gives you that element's height & width
        System.out.println("Location of the min slider: " + min_slider.getLocation()); // Location of the min slider: (59, 250)
        System.out.println("Height & width of the element: " + min_slider.getSize()); // Height & width of the element: (22, 21)

        Actions act = new Actions(driver);
        //Sliding action--> dragAndDropBy(element, how many pixel move to + x, how many pixel move through y).perform();
        act.dragAndDropBy(min_slider, 100, 250).perform();
        System.out.println("Location of the min slider: " + min_slider.getLocation()); // Location of the min slider: (163, 250)
        System.out.println("Height & width of the element: " + min_slider.getSize()); // Height & width of the element: (21, 21)

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        System.out.println("Location of the min slider: " + max_slider.getLocation()); // Location of the min slider: (753, 250)
        System.out.println("Height & width of the element: " + max_slider.getSize()); // Height & width of the element: (22, 21)
        // dragAndDropBy(element, how many pixel move - x , how many pixel move through y).perform
        act.dragAndDropBy(max_slider, -100, 0).perform();
        System.out.println("Location of the min slider: " + max_slider.getLocation()); // Location of the min slider: (649, 250)
        System.out.println("Height & width of the element: " + max_slider.getSize()); // Height & width of the element: (21, 21)
    }
}
