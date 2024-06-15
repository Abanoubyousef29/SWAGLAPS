import Pages.*;
import Util.Utility;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TC01_CheckTotalAmount extends TestBase {

    //define test data
    String email = "standard_user";
    String password = "secret_sauce";
    static String firstName =  Utility.generateRandomString(5);
    static String lastName =  Utility.generateRandomString(5);
    static String postalcode =  Utility.generateRandomString(5);

    // check login positive scenario

    @Test(priority = 1, description = "check that total prices equal to price at checkout page")
    public void totalPricessEqualCheckoutAmount_P(){
        new P01_LoginPage(driver).inputEmail(email).inputPassword(password).clickLoginButton();
        new P02_HomePage(driver).addRandomProductsToTheCart().clickOnCartButton();
        new P03_CartPage(driver).clickOnCheckoutButton();
        new P04_InformationPage(driver).inputFirstName(firstName).inputLastName(lastName).inputPostalCode(postalcode).clickOnContinueButton();
        new P05_ShippingInfo(driver).compareItemTotalWithTotalCalculated();

        Assert.assertEquals(P05_ShippingInfo.roundedPriceValue, P02_HomePage.roundedTotalPrice, 0.1f);
    }
}
