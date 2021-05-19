package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleBrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        int brokenLinks = 0;

        for (WebElement element : links) {
            String url = element.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty");
                continue;
            }

            URL link = new URL(url);

            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() >= 400) {
                    System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Broken link");
                    brokenLinks++;
                } else {
                    System.out.println(httpURLConnection.getResponseCode() + url + " is" + " Valid Link");
                }
            } catch (Exception e) {

            }

        }
        System.out.println("Number of broken links: " + brokenLinks);
        driver.quit();
    }
}
