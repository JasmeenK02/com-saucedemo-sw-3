package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
   String baseUrl = "https://www.saucedemo.com/";

   @Before
    public void setUp(){
       openBrowser(baseUrl);
   }
  @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
       //Enter “standard_user” username
      sendTextToElement(By.id("user-name"), "standard_user");
      // Enter “secret_sauce” password
      sendTextToElement(By.id("password"), "secret_sauce");
      //Click on ‘LOGIN’ button
      clickOnElement(By.name("login-button"));
      // Verify the text “PRODUCTS”
      String expectedText = "Products";
      String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
      Assert.assertEquals("Text Products doesn't match", expectedText,actualText);
  }
  @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
       //Enter "standard_user" username
      sendTextToElement(By.id("user-name"), "standard_user");
      //Enter “secret_sauce” password
      sendTextToElement(By.id("password"), "secret_sauce");
      //click  on 'LOGIN' button
      clickOnElement(By.name("login-button"));
      //Verify that six products are displayed
      int expectedProducts = 6;
      int actualProducts = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
      Assert.assertEquals("Number of Products displayed don't match", expectedProducts, actualProducts);
  }

  @After
    public void tearDown(){
       closeBrowser();
  }


}
