package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {

    WebDriver driver;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CHECKOUT_BUTTON = By.xpath("//a[@class='btn_action checkout_button']");


    public P03_CartPage clickOnCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return this ;
    }
}
