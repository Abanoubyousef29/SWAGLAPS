package Pages;

import Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.List;

public class P02_HomePage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;
    public static float totalPrice ;
    public static float roundedTotalPrice ;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By PRODUCT_ITEM = By.xpath("//div[@class='inventory_item']");
    private final By PRODUCT_ITEM_PRICE = By.cssSelector(".inventory_item_price");
    private final By PRODUCT_ITEM_ADD_TO_CART = By.cssSelector("button[class='btn_primary btn_inventory']");
    private final By OPEN_CART_BUTTON = By.xpath("//div[@id='shopping_cart_container']");


    public P02_HomePage addRandomProductsToTheCart() {
        totalPrice = 0.01f;

        final int randomNumber = Utility.generateRandomNumberBasedOnMaxNumberList(driver.findElements(PRODUCT_ITEM).size());

        List<Integer> randomNumbers = Utility.generateRandomNumbersFromAList(driver.findElements(PRODUCT_ITEM).size(), randomNumber);

        for (int i = 0; i < randomNumbers.size(); i++) {
            String price = driver.findElements(PRODUCT_ITEM).get(randomNumbers.get(i) - 1).findElement(PRODUCT_ITEM_PRICE).getText();
            price = price.replace("$", "").trim();
            float priceValue = Float.parseFloat(price);
            totalPrice += priceValue;
        }
        for (int i = 0; i < randomNumbers.size(); i++) {
            driver.findElements(PRODUCT_ITEM).get(randomNumbers.get(i) - 1).findElement(PRODUCT_ITEM_ADD_TO_CART).click();
        }

        roundedTotalPrice = Math.round(P02_HomePage.totalPrice * 10) / 10.0f;
        return this;

    }

    public P02_HomePage clickOnCartButton(){
        driver.findElement(OPEN_CART_BUTTON).click();
        return this ;
    }
}
