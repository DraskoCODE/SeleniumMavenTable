package com.code.herokuapp.pages;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TablePage {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        this.driver.get("http://the-internet.herokuapp.com/tables");
        this.driver.manage().window().maximize();
    }

    public WebElement getTable() {
        return this.driver.findElement(By.xpath("//table[@id='table1']"));
    }

    public List<HashMap<String, String>> getTableData() {
        List<HashMap<String, String>> toReturn = new ArrayList<>();

        WebElement webElementTbl = this.getTable();

        List<String> headerColumnsName = new ArrayList<>();
        List<WebElement> headerItems = webElementTbl.findElements(By.xpath(".//th"));
        for(int i = 0; i < headerItems.size(); i++) {
            WebElement span = headerItems.get(i).findElement(By.xpath(".//span"));
            headerColumnsName.add(span.getText());
        }

        WebElement tbody = webElementTbl.findElement(By.xpath(".//tbody"));
        List<WebElement> webElementListRow = tbody.findElements(By.xpath(".//tr"));
        for(int j = 0; j < webElementListRow.size(); j++) {
            HashMap<String, String> mapRow = new HashMap<>();
            List<WebElement> webElementListCell = webElementListRow.get(j).findElements(By.xpath(".//td"));
            for(int k = 0; k < webElementListCell.size(); k++) {
                mapRow.put(headerColumnsName.get(k), webElementListCell.get(k).getText());
            }
            toReturn.add(mapRow);
        }

        return toReturn;
    }

    public String getColumnDataOnRow(String column, int rowNum) {
        List<HashMap<String, String>> tableData = this.getTableData();

        HashMap<String, String> row = tableData.get(rowNum);
        return row.get(column);
    }


}
