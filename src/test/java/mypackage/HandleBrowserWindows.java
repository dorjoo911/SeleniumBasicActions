package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

//        //getWindowHandle()
//        String windowID = driver.getWindowHandle(); //return ID of the single browser window
//        System.out.println(windowID);              //CDwindow-FA4C623BD16FB6570FC8AB8A82433451
//        // it does return new ID every single run    CDwindow-360A2EC09233633973513E4CA43AA66C

        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        //Open another browser window-child window

        //getWindowHandles()
        Set<String> windowIDs = driver.getWindowHandles();
        //return IDs of multiple browser windows

//        //First method - iterator()
//        Iterator<String> it = windowIDs.iterator();
//        String parentWindowID = it.next();
//        String childWindowID = it.next();
//        System.out.println("Parent window ID: " + parentWindowID);
//        System.out.println("Child window ID: " + childWindowID);

        //Second method - using List/ArrayList
        List<String> windowIDsList = new ArrayList<>(windowIDs); //converting Set --> List
//        String parentWindowID = windowIDsList.get(0); //Parent window ID
//        String childWindowID = windowIDsList.get(1); //Child window ID

//        System.out.println("Parent window ID: " + parentWindowID);
//        System.out.println("Child window ID: " + childWindowID);
//
//        //How to use window ID's for switching
//        driver.switchTo().window(parentWindowID);
//        System.out.println("Parent window title: " + driver.getTitle());
//
//        driver.switchTo().window(childWindowID);
//        System.out.println("Child window title: " + driver.getTitle());

        //Using for each loop, multiple window titles in single shot
//        for (String winID:windowIDsList ) {
//            //System.out.println(winID);
//            String title = driver.switchTo().window(winID).getTitle();
//            System.out.println(title);
//        }

//        driver.close(); //close single browser window driver which pining
//        driver.quit(); //close all the browser windows

        for (String winID : windowIDsList) {
            String title = driver.switchTo().window(winID).getTitle();
            if(title.equals("OrangeHRM") || title.equals("another title") ){
                driver.close(); //close() specified window closed
            }
        }
    }
}
