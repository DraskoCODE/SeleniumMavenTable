package com.code.herokuapp.tests;

import com.code.herokuapp.pages.MainPage;
import com.code.herokuapp.pages.TablePage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class TableTests extends BaseTest {

    @Test
    public void getTable() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.selectListItemByText("Sortable Data Tables");

        TablePage tablePage = new TablePage(driver);
        List<HashMap<String, String>> tableData = tablePage.getTableData();
        System.out.println("test");
        System.out.println(tablePage.getColumnDataOnRow("First Name", 2));
        System.out.println(tablePage.getColumnDataOnRow("First Name", 1));
        System.out.println(tablePage.getColumnDataOnRow("Email", 1));
    }


}
