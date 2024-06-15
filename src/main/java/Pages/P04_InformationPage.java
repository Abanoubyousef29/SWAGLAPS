package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_InformationPage {

    WebDriver driver;

    public P04_InformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By FIRST_NAME_TEXT = By.xpath("//input[@id='first-name']");
    private final By LAST_NAME_TEXT = By.xpath("//input[@id='last-name']");
    private final By POSTAL_CODE_TEXT = By.xpath("//input[@id='postal-code']");
    private final By CONTINUE_BUTTON = By.xpath("//input[@class='btn_primary cart_button']");


    public P04_InformationPage inputFirstName (String firstName){
        driver.findElement(FIRST_NAME_TEXT).sendKeys(firstName);
        return this ;
    }

    public P04_InformationPage inputLastName (String lastName){
        driver.findElement(LAST_NAME_TEXT).sendKeys(lastName);
        return this ;
    }

    public P04_InformationPage inputPostalCode (String postalcode){
        driver.findElement(POSTAL_CODE_TEXT).sendKeys(postalcode);
        return this ;
    }

    public P04_InformationPage clickOnContinueButton (){
        driver.findElement(CONTINUE_BUTTON).click();
        return this ;
    }
}
