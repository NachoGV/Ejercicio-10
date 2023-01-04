package com.ej10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Ej10SuiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void SignInUsuarioIncorrecto() {
    // Test name: 1. Sign In - Usuario Incorrecto
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 626x641 | 
    driver.manage().window().setSize(new Dimension(626, 641));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | nacho
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("nacho");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | assertText | css=*[data-test="error"] | Epic sadface: Username and password do not match any user in this service
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText(), "Epic sadface: Username and password do not match any user in this service");
  }
  @Test
  public void SignInCorrecto() {
    // Test name: 2. Sign In - Correcto
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x666 | 
    driver.manage().window().setSize(new Dimension(1185, 666));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | assertText | css=.title | PRODUCTS
    assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "PRODUCTS");
  }
  @Test
  public void AboutPage() {
    // Test name: 3. About Page
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x666 | 
    driver.manage().window().setSize(new Dimension(1185, 666));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | id=react-burger-menu-btn | 
    driver.findElement(By.id("react-burger-menu-btn")).click();
    // 8 | click | id=about_sidebar_link | 
    driver.findElement(By.id("about_sidebar_link")).click();
    // 9 | mouseOver | css=.nav-image > .nav-image-link | 
    {
      WebElement element = driver.findElement(By.cssSelector(".nav-image > .nav-image-link"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 10 | mouseOut | css=.nav-image > .nav-image-link | 
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 11 | executeScript | return window.location.href | about-url
    vars.put("about-url", js.executeScript("return window.location.href"));
    // 12 | assert | about-url | https://saucelabs.com/
    assertEquals(vars.get("about-url").toString(), "https://saucelabs.com/");
  }
  @Test
  public void ShoppingCartAdd1Item() {
    // Test name: 4. Shopping Cart - Add 1 Item
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 10 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 12 | click | css=*[data-test="remove-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
  }
  @Test
  public void ShoppingCartAdd2Items() {
    // Test name: 5. Shopping Cart - Add 2 Items
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=*[data-test="back-to-products"] | 
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    // 10 | click | css=#item_1_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_1_title_link > .inventory_item_name")).click();
    // 11 | click | css=*[data-test="add-to-cart-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    // 12 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 13 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 14 | assertElementPresent | css=.cart_item_label | #item_1_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 16 | click | css=*[data-test="remove-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
    // 17 | click | css=*[data-test="remove-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
  }
  @Test
  public void ShoppingCartRemoveItem() {
    // Test name: 6. Shopping Cart - Remove Item
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 10 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 12 | click | css=*[data-test="remove-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
  }
  @Test
  public void CheckoutPageStepOne() {
    // Test name: 7. Checkout Page - Step One
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=*[data-test="back-to-products"] | 
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    // 10 | click | css=#item_1_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_1_title_link > .inventory_item_name")).click();
    // 11 | click | css=*[data-test="add-to-cart-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    // 12 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 13 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 14 | assertElementPresent | css=.cart_item_label | #item_1_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 15 | click | css=*[data-test="checkout"] | 
    driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
    // 16 | assertText | css=.title | CHECKOUT: YOUR INFORMATION
    assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "CHECKOUT: YOUR INFORMATION");
    // 18 | open | https://www.saucedemo.com/cart.html | 
    driver.get("https://www.saucedemo.com/cart.html");
    // 19 | click | css=*[data-test="remove-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
    // 20 | click | css=*[data-test="remove-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
  }
  @Test
  public void CheckoutPageCheckPrice() {
    // Test name: 8. Checkout Page - Check Price
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=*[data-test="back-to-products"] | 
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    // 10 | click | css=#item_1_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_1_title_link > .inventory_item_name")).click();
    // 11 | click | css=*[data-test="add-to-cart-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    // 12 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 13 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 14 | assertElementPresent | css=.cart_item_label | #item_1_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 15 | click | css=*[data-test="checkout"] | 
    driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
    // 16 | assertText | css=.title | CHECKOUT: YOUR INFORMATION
    assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "CHECKOUT: YOUR INFORMATION");
    // 17 | click | css=*[data-test="firstName"] | 
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
    // 18 | type | css=*[data-test="firstName"] | Ignacio
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Ignacio");
    // 19 | type | css=*[data-test="lastName"] | Gomez Valverde
    driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Gomez Valverde");
    // 20 | type | css=*[data-test="postalCode"] | 28224
    driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("28224");
    // 21 | click | css=*[data-test="continue"] | 
    driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
    // 22 | storeText | css=.cart_item:nth-child(3) .inventory_item_price | p1
    vars.put("p1", driver.findElement(By.cssSelector(".cart_item:nth-child(3) .inventory_item_price")).getText());
    // 23 | storeText | css=.cart_item:nth-child(4) .inventory_item_price | p2
    vars.put("p2", driver.findElement(By.cssSelector(".cart_item:nth-child(4) .inventory_item_price")).getText());
    // 24 | executeScript | return parseFloat(${p1}.replace('$', '')) + parseFloat(${p2}.replace('$', '')); | 45.98
    vars.put("45.98", js.executeScript("return parseFloat(arguments[0].replace(\'$\', \'\')) + parseFloat(arguments[1].replace(\'$\', \'\'));", vars.get("p1"),vars.get("p2")));
    // 26 | open | https://www.saucedemo.com/cart.html | 
    driver.get("https://www.saucedemo.com/cart.html");
    // 27 | click | css=*[data-test="remove-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
    // 28 | click | css=*[data-test="remove-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
  }
  @Test
  public void CheckoutPageFinishOrder() {
    // Test name: 9. Checkout Page - Finish Order
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | setWindowSize | 1185x672 | 
    driver.manage().window().setSize(new Dimension(1185, 672));
    // 3 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 4 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 5 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 6 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 7 | click | css=#item_4_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_4_title_link > .inventory_item_name")).click();
    // 8 | click | css=*[data-test="add-to-cart-sauce-labs-backpack"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    // 9 | click | css=*[data-test="back-to-products"] | 
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    // 10 | click | css=#item_1_title_link > .inventory_item_name | 
    driver.findElement(By.cssSelector("#item_1_title_link > .inventory_item_name")).click();
    // 11 | click | css=*[data-test="add-to-cart-sauce-labs-bolt-t-shirt"] | 
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    // 12 | click | css=.shopping_cart_badge | 
    driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
    // 13 | assertElementPresent | css=.cart_item_label | #item_4_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 14 | assertElementPresent | css=.cart_item_label | #item_1_title_link
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item_label"));
      assert(elements.size() > 0);
    }
    // 15 | click | css=*[data-test="checkout"] | 
    driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
    // 16 | assertText | css=.title | CHECKOUT: YOUR INFORMATION
    assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "CHECKOUT: YOUR INFORMATION");
    // 17 | click | css=*[data-test="firstName"] | 
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
    // 18 | type | css=*[data-test="firstName"] | Ignacio
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Ignacio");
    // 19 | type | css=*[data-test="lastName"] | Gomez Valverde
    driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Gomez Valverde");
    // 20 | type | css=*[data-test="postalCode"] | 28224
    driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("28224");
    // 21 | click | css=*[data-test="continue"] | 
    driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
    // 22 | storeText | css=.cart_item:nth-child(3) .inventory_item_price | p1
    vars.put("p1", driver.findElement(By.cssSelector(".cart_item:nth-child(3) .inventory_item_price")).getText());
    // 23 | storeText | css=.cart_item:nth-child(4) .inventory_item_price | p2
    vars.put("p2", driver.findElement(By.cssSelector(".cart_item:nth-child(4) .inventory_item_price")).getText());
    // 24 | executeScript | return parseFloat(${p1}.replace('$', '')) + parseFloat(${p2}.replace('$', '')); | p
    vars.put("p", js.executeScript("return parseFloat(arguments[0].replace(\'$\', \'\')) + parseFloat(arguments[1].replace(\'$\', \'\'));", vars.get("p1"),vars.get("p2")));
    // 25 | assert | p | 45.98
    assertEquals(vars.get("p").toString(), "45.98");
    // 26 | click | css=*[data-test="finish"] | 
    driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    // 27 | click | css=*[data-test="back-to-products"] | 
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    // 28 | click | css=.shopping_cart_link | 
    driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    // 29 | assertElementNotPresent | css=.cart_item | 
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".cart_item"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void MainPageOrderbyPrice() {
    // Test name: 10. Main Page - Order by Price
    // Step # | name | target | value
    // 1 | open | https://www.saucedemo.com/ | 
    driver.get("https://www.saucedemo.com/");
    // 2 | click | css=*[data-test="username"] | 
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    // 3 | type | css=*[data-test="username"] | standard_user
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    // 4 | type | css=*[data-test="password"] | secret_sauce
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    // 5 | click | css=*[data-test="login-button"] | 
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // 6 | select | css=*[data-test="product_sort_container"] | Price (low to high)
    {
      WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"product_sort_container\"]"));
      dropdown.findElement(By.xpath("//option[. = 'Price (low to high)']")).click();
    }
    /*
    // 7 | storeText | css=.inventory_item:nth-child(1) .inventory_item_price | p1
    vars.put("p1", driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price")).getText());
    // 8 | storeText | css=.inventory_item:nth-child(2) .inventory_item_price | p2
    vars.put("p2", driver.findElement(By.cssSelector(".inventory_item:nth-child(2) .inventory_item_price")).getText());
    // 9 | storeText | css=.inventory_item:nth-child(3) .inventory_item_price | p3
    vars.put("p3", driver.findElement(By.cssSelector(".inventory_item:nth-child(3) .inventory_item_price")).getText());
    // 10 | storeText | css=.inventory_item:nth-child(4) .inventory_item_price | p4
    vars.put("p4", driver.findElement(By.cssSelector(".inventory_item:nth-child(4) .inventory_item_price")).getText());
    // 11 | storeText | css=.inventory_item:nth-child(5) .inventory_item_price | p5
    vars.put("p5", driver.findElement(By.cssSelector(".inventory_item:nth-child(5) .inventory_item_price")).getText());
    // 12 | storeText | css=.inventory_item:nth-child(6) .inventory_item_price | p6
    vars.put("p6", driver.findElement(By.cssSelector(".inventory_item:nth-child(6) .inventory_item_price")).getText());
    // 13 | executeScript | return (parseFloat(${p1}.replace('$', '')) <= parseFloat(${p2}.replace('$', ''))) && 	 (parseFloat(${p2}.replace('$', '')) <= parseFloat(${p3}.replace('$', ''))) && 	 (parseFloat(${p3}.replace('$', '')) <= parseFloat(${p4}.replace('$', ''))) &&  	 (parseFloat(${p4}.replace('$', '')) <= parseFloat(${p5}.replace('$', ''))) &&  	 (parseFloat(${p5}.replace('$', '')) <= parseFloat(${p6}.replace('$', ''))); | p
    vars.put("p", js.executeScript("return (parseFloat(arguments[0].replace(\'$\', \'\')) <= parseFloat(arguments[1].replace(\'$\', \'\'))) && 	 (parseFloat(arguments[1].replace(\'$\', \'\')) <= parseFloat(arguments[2].replace(\'$\', \'\'))) && 	 (parseFloat(arguments[2].replace(\'$\', \'\')) <= parseFloat(arguments[3].replace(\'$\', \'\'))) &&  	 (parseFloat(arguments[3].replace(\'$\', \'\')) <= parseFloat(arguments[4].replace(\'$\', \'\'))) &&  	 (parseFloat(arguments[4].replace(\'$\', \'\')) <= parseFloat(arguments[5].replace(\'$\', \'\')));", vars.get("p1"),vars.get("p2"),vars.get("p3"),vars.get("p4"),vars.get("p5"),vars.get("p6")));
    // 14 | assert | p | true
    assertEquals(vars.get("p").toString(), "true");
    */
  
    // list of prices
    List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));

    // check if prices are sorted
    for (int i = 0; i < prices.size() - 1; i++) {
      String price1 = prices.get(i).getText().replace("$", "");
      String price2 = prices.get(i + 1).getText().replace("$", "");
      assertTrue(Float.parseFloat(price1) <= Float.parseFloat(price2));
    }
  }
}
