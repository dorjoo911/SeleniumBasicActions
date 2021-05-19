package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");
        //*** get() is used to navigate particular URL(website) and wait till page load driver.
//        driver.get("https://amazon.com/");
        driver.navigate().to("https://amazon.com/");
        //*** navigate().to() is used to navigate to particular URL and doesn't wait to page load.
        //*** It maintains browser history or cookies to navigate back, forward or refresh.

        driver.navigate().back(); // back to www.snapdeal.com
        driver.navigate().forward(); // take to the www.amazon.com
        driver.navigate().refresh(); // refresh or reload page

    }
}
