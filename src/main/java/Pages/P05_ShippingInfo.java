package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P05_ShippingInfo {

    WebDriver driver;

    public static float roundedPriceValue ;

    public P05_ShippingInfo(WebDriver driver) {
        this.driver = driver;
    }

    private final By ITEM_TOTAL_LABEL = By.xpath("//div[@class='summary_subtotal_label']");

    public P05_ShippingInfo compareItemTotalWithTotalCalculated(){
        String price = driver.findElement(ITEM_TOTAL_LABEL).getText();
        price = price.replace("Item total: $", "").trim();
        float priceValue = Float.parseFloat(price);

        roundedPriceValue = Math.round(priceValue * 10) / 10.0f;

        return this ;
    }
}
