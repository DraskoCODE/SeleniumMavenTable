package com.code.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        this.driver.get("http://the-internet.herokuapp.com/");
        this.driver.manage().window().maximize();
    }

    public void selectListItemByText(String itemText) {
        WebElement listRoot = this.driver.findElement(By.xpath("//ul"));
        List<WebElement> elementList = listRoot.findElements(By.xpath(".//a"));

        for(int i = 0; i < elementList.size(); i++) {
            if(elementList.get(i).getText().equals(itemText)) {
                elementList.get(i).click();
                break;
            }
        }

    }

}
