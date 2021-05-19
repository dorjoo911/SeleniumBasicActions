package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVsFindElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // **** findElement() **** : method returns the first matching element on the current page.
        // If the element is not found then it throws NoSuchElementFoundException.

        //Scenario 1
        //findElement() --> single webElement
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchBox.sendKeys("cars");

        //Scenario 2
        //findElement() --> to find multiple webElements but return first result
        WebElement ele = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(ele.getText());

        //Scenario 3
        //findElement() --> find ZERO element returns Exception: NoSuchElementFoundException
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));

        // **** findElements() **** ---> method returns all he matching elements on the current page and it doesn't
        // throw any exception if the element is not found, Instead it will return zero elements.

        // 1. multiple elements --> list of webElements
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("Number of elements captured: " + links.size());
        for (WebElement element : links) {
            System.out.println(element.getText());
        }

        // 2. findElements() can return single element
        List<WebElement> logo = driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        System.out.println(logo.size());

        // 3. findElements() can return ZERO element
        List<WebElement> elements = driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
        System.out.println(elements.size());
    }
}
