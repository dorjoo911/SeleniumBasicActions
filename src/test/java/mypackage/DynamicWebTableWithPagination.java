package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicWebTableWithPagination {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php");

        // Login page
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.clear();
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        // Sales ---> Orders
        driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"collapse26\"]/li[1]/a")).click();

        // The Table
        // 1. Total number of pages
        String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[2]/div/div[2]")).getText();
        System.out.println(text); //Showing 1 to 20 of 8835 (442 Pages)
//        text.indexOf("(") -----> Showing 1 to 20 of 8835 (442 Pages) Starting indexOf substring
//        text.indexOf("Pages") --> ending indexOf substring

        int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("Total number of pages: " + total_pages);

        // 2. Find How many rows exists in each pages
        for (int p = 1; p <= 5; p++) { //total_pages --> for testing i change it 5
            //Active page turns span tag
            WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("Active page: " + active_page.getText());
            active_page.click();

            // Total number of rows: findElements(By.xpath("//")).size();
            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
            System.out.println("Number of rows: " + rows);

            // 3. Read all the rows from each page
            for (int r = 1; r <= rows; r++) {
                String orderId = driver.findElement
                        (By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
                        .getText();
                String customerName = driver.findElement
                        (By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
                        .getText();
                String status = driver.findElement
                        (By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
                        .getText();
                if (status.equals("Pending")) { // Print only Pending status customer
                    System.out.println(orderId + "            " + customerName + "             " + status);
                }
            }

            // Change next pagination make it active and turn into span tag
            String pageno = Integer.toString(p + 1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageno + "']")).click();
        }

        driver.quit();

    }
}
