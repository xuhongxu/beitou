package com.visionet;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private WebDriver driver = getChrome();

    @Test
    public void baidu_search() {
        MyPage myPage = PageFactory.initElements(driver, MyPage.class);
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();//窗口最大化
        myPage.kw_sendkes("helenMemery");
        myPage.su_click();

    }

    @Test
    public void f2() {
        Assert.assertEquals("b", "b");
    }

    @AfterMethod
    public void close(){
        //driver.close();
    }
    public ChromeDriver getChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

}
