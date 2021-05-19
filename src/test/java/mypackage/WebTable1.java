package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. How many rows in table
2. How many columns in a table
3. Retrieve the specific row/column data
4. Retrieve all the data from the table
5. Print Release Date, VersionNo of Java Language of Selenium
 */

public class WebTable1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");

        // How many rows in table
        int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
        System.out.println("Total number of rows in a table: " + rows);

        // How many columns in a table
        int colm = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();
        System.out.println("Total number of columns in a table: " + colm);

        // Retrieve the specific row/column data
        String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
        System.out.println("The value is: " + value);

        // Retrieve all the data from the table
//        System.out.println("Data form the table .......... ");
//        for (int r=1; r<=rows; r++){     // r=1 ... so ... 2 3 4 5
//            for (int c=1; c<=colm; c++){ // c=1 2 3 4 5 6 it will repeat when 'r' changes
//                String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
//                System.out.print(data + "    ");
//            }
//            System.out.println();
//        }

        // Print Release Date, VersionNo of Java Language of Selenium
        for (int r=1; r<=rows; r++){
            String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
            if(language.equals("Java")){
                String versionNum = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[2]")).getText();
                String releaseDate = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[3]")).getText();
                System.out.println(language + "  " + versionNum +"  " + releaseDate);
            }
        }

        driver.quit();
    }
}
