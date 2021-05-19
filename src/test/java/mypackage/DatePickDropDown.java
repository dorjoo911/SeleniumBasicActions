package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");

        driver.findElement(By.xpath("//input[@id='dob']")).click(); //opens date picker

        // Month & Year selection
        Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        month_drp.selectByVisibleText("Oct");

        Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        year_drp.selectByVisibleText("1990");

        // Date selection
        String date = "15";                 //to save multi elements in allDates
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement ele : allDates) { //using for.each through ele from allDates
            String dt = ele.getText();    //then giving to dt value from ele
            if (dt.equals(date)) {         // is dt equals() as expected date's value of 15 ?
                ele.click();               // if yes click(); if not repeat it until match and stop the loop
                break;
            }
        }
    }
}
