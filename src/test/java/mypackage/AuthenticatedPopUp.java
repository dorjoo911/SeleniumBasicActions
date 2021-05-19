package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("http://the-internet.herokuapp.com/basic_auth"); //Normally open page with POPUP

        //Syntax
        // http://admin:admin@the-internet.herokuapp.com/basic_auth
        // http://user:password@the-internet.herokuapp.com/basic_auth
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth"); //Open page with user & password.



    }
}
