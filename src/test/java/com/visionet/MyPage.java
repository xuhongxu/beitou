package com.visionet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPage extends BasePage {
    public MyPage(WebDriver driver) {
        super(driver);
    }
    //关键词输入框
    @FindBy(id="kw")
    private WebElement kw_Element;

    //“搜索”按钮
    @FindBy(id="su")
    private WebElement su_Element;

    //输入关键词
    public void kw_sendkes(String s){
        this.sendkeys(kw_Element, s);
    }

    //点击“搜索”按钮
    public void su_click() {
        this.click(su_Element);
    }

}
