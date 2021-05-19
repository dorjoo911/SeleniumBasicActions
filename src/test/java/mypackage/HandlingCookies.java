package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlingCookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // How to capture cookies from browser?
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies: " + cookies.size());

        // How to print cookies from browser?
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        // How to add cookies to the browser?
        Cookie cookieObj = new Cookie("MyCookie123", "123456abc");
        driver.manage().addCookie(cookieObj);

        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after add my cookie: " + cookies.size());

        // How to delete specific cookie from the browser?
//        driver.manage().deleteCookie(cookieObj); //delete by variable name
        driver.manage().deleteCookieNamed("MyCookie123"); // delete by cookie name
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after delete my cookie: " + cookies.size());

        // How to delete all of the cookies from the browser?
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after delete all my cookie: " + cookies.size());

        driver.close();

    }
}
