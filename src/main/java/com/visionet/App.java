package com.visionet;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    private static final String url="http://115.159.43.39:8081";
    private static final  String userName="jtcs";
    private static final  String passWord="1qa2ws";

    public static void main(String[] args) throws InterruptedException, IOException {
        shutdownChrome();
        ChromeDriver driver = getChrome();

        driver.get("http://115.159.43.39:8081");
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys(userName);
        driver.findElement(By.id("psd")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public static FirefoxDriver getFoxFire(){
        System.setProperty("webdriver.gecko.driver","E:\\webDriver\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }
    public static ChromeDriver getChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver getIe(){
        System.setProperty("webdriver.ie.driver", "E:\\webDriver\\IEDriverServer.exe");
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver driver = new InternetExplorerDriver(ieCapabilities);
        return driver;
    }
    //关闭进程
    public static void shutdownFoxFire() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("cmd.exe /c taskkill -f -t -im geckodriver.exe");
    }
    public static void shutdownChrome() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("cmd.exe /c taskkill -f -t -im chromedriver.exe");
    }

    public static void shutdownIE() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("cmd.exe /c taskkill -f -t -im IEDriverServer.exe");
    }
}
