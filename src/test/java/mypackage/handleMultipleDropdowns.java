package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class handleMultipleDropdowns {
    static  WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates");

        //Approach 1
//        Select employees = new Select(driver.findElement(By.id("candidateSearch_jobTitle")));
//        employees.selectByValue("22");
//        Select vacancy = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_jobVacancy\"]")));
//        vacancy.selectByValue("5");
//        Select manager = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_hiringManager\"]")));
//        manager.selectByVisibleText("Kevin Mathews");

        //Approach 2
        WebElement employees = driver.findElement(By.id("candidateSearch_jobTitle"));
        selectOptionFromDropDown(employees, "22");
        WebElement vacancy = driver.findElement(By.id("candidateSearch_jobVacancy"));
        selectOptionFromDropDown(vacancy, "5");
        WebElement manager = driver.findElement(By.id("candidateSearch_hiringManager"));
        selectOptionFromDropDown(manager, "Kevin Mathews");
    }

    public static void selectOptionFromDropDown(WebElement ele, String value){
        Select drp=new Select(ele);
        List<WebElement> alloptions =drp.getOptions();
        for (WebElement option:alloptions) {
            if( option.getText().equals(value)){
                option.click();
                System.out.println("Is Kevin Mathews option selected? " + option.isSelected());
                break;
            }
        }
    }


}
