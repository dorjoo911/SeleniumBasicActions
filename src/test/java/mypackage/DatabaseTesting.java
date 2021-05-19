package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

public class DatabaseTesting {
    public static void main(String[] args) {

        // Data
        String cust_firstName = "John";
        String cust_lastName = "Carter";
        String cust_telPhone = "8887774455";
        String cust_email = "Dorjoooooo@gmail.com";
        String cust_password = "abc123";

        // User registration
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        driver.findElement(By.name("firstname")).sendKeys(cust_firstName);
        driver.findElement(By.name("lastname")).sendKeys(cust_lastName);
        driver.findElement(By.name("email")).sendKeys(cust_email);
        driver.findElement(By.name("telephone")).sendKeys(cust_telPhone);
        driver.findElement(By.name("password")).sendKeys(cust_password);
        driver.findElement(By.name("confirm")).sendKeys(cust_password);
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        try {
            String confmsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
            if (confmsg.equals("Your Account Has Been Created!")) {
                System.out.println("Registration successful from the UI/Application");
            } else {
                System.out.println("Registration NOT successful from the UI/Application");
            }
        } catch (Exception e) {
            System.out.println("Some problem in the application");
        }

        // Database validation         // Need URL, user & pass
//        Connection con = DriverManager.getConnection("", "root", "");
//
//        Statement stmt = con.createStatement();
//
//        String query = "select firstname, lastname, email, telephone from oc_customer";
//
//        ResultSet rs = stmt.executeQuery(query);
//
//        boolean status = false;
//
//        while (rs.next()) {
//            String firstName = rs.getString("fistname");
//            String lastName = rs.getString("lastname");
//            String eMail = rs.getString("email");
//            String telePhone = rs.getString("telephone");
//
//            if (cust_firstName.equals(firstName)
//                    && cust_lastName.equals(lastName)
//                    && cust_email.equals(eMail)
//                    && cust_telPhone.equals(telePhone)) {
//                System.out.println("Record found in the table || Test Passed");
//                status = true;
//                break;
//            }
//        }
//        if (status == false){
//            System.out.println("Record Not Found || Test Failed");
//        }

    }
}
