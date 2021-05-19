package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

public class DownloadPDFIle {
    public static void main(String[] args) {
        String location = System.getProperty("user.dir")+"\\src\\test\\Downloads\\";

        //Chrome
//        HashMap prefrences= new HashMap();
//        prefrences.put("plugins.always_open_pdf_externally", true); // add this line for pdf download
//        prefrences.put("download.default_directory", location);
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefrences);
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(options);

        //Edge
//        HashMap prefrences= new HashMap();
//        prefrences.put("plugins.always_open_pdf_externally", true); // add this line for pdf download
//        prefrences.put("download.default_directory", location);
//
//        EdgeOptions options = new EdgeOptions();
//        options.setExperimentalOption("prefs", prefrences);
//
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver(options);

        //Firefox
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("pdfjs.disabled", true); // for pdf  change MIME type here
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // MIME type
        profile.setPreference("browser.download.folderList", 2); // 0-desktop, 1-download 2-download specific location
        profile.setPreference("browser.download.dir", location);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
