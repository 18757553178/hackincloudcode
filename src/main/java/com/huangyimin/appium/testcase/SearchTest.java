package com.huangyimin.appium.testcase;

import com.huangyimin.appium.page.App;
import com.huangyimin.appium.page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SearchTest {
    public static SearchPage searchPage;

    @BeforeClass
    public void beforeClass() {
        App.start();
    }

    @BeforeMethod
    public void beforeMethod() {
        searchPage = App.toSearch();

    }


    @DataProvider(name = "data")
    public static Object[][] data(){
        return new Object[][] { {  "alibaba", 100f }, { "xiaomi", 8f}, {  "jd", 33f}};
    }

    @Test(dataProvider = "data")
    public void search(String stock,Float price) {
        Assert.assertEquals(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price));

    }


    @AfterMethod
    public void afterMethod() {
        searchPage.cancel();

    }
}
