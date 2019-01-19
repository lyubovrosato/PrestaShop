package com.prestashop.tests.smoke_tests;

import com.prestashop.basics.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class productInfo extends TestBase {
       /*
    1.Go to http://automationpractice.com/index.php

    8.Verify confirmation message “Product successfully added to your shopping cart”
    9.that default quantity is 1
    10.Verify that default size is S
    11.Verify that same name and price displayed as on the home page
     */


    @Test(priority = 1)
    public void price() throws InterruptedException {
        // 2.Click on any product
        String product = driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/h5/a")).getText();
        //get price
        String price = driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/div[1]/span")).getText();
        //(Blouse under popular) and select
        driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/h5/a")).click();
        //3.Verify that same name and price displayed as on the home pageProduct information-details:(verifying product name & price on the next page)
        String product2 = driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/h1")).getText();
        String price2 = driver.findElement(By.xpath("//*[@id='our_price_display']")).getText();

        System.out.println(product + " " + price + " / " + product2 + " " + price2);

        Assert.assertTrue(product.equals(product2));
        Assert.assertTrue(price.equals(price2));

        // 4.that default quantity is 1
        String quantity = driver.findElement(By.xpath("//*[@id='quantity_wanted']")).getAttribute("value");
        System.out.println(quantity);
        Assert.assertEquals(quantity, "1");

        //5.Verify that default size is S
        String size = driver.findElement(By.xpath("//*[@id='group_1']/option[1]")).getText();
        System.out.println(size);
        Assert.assertEquals(size, "S");
        //6.Verify that size options are S, M, L Product information–Add to cart:
        List<String> list = new ArrayList<String>();
        list.add(driver.findElement(By.xpath("//*[@id='group_1']/option[1]")).getText());
        list.add(driver.findElement(By.xpath("//*[@id='group_1']/option[2]")).getText());
        list.add(driver.findElement(By.xpath("//*[@id='group_1']/option[3]")).getText());
        System.out.println(list);
        Assert.assertEquals(list.get(0), "S");
        Assert.assertEquals(list.get(1), "M");
        Assert.assertEquals(list.get(2), "L");

        //7.Click on "Add to cart"
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();

        // 8.Verify confirmation message “Product successfully added to your shopping cart”
        String msg = driver.findElement(By.xpath("//i[@class = 'icon-ok']//parent::h2")).getAttribute("innerText").trim();
        System.out.println(msg);
        Assert.assertEquals(msg, "Product successfully added to your shopping cart");

           //9. Verify that default quantity is 1
        Thread.sleep(3000);
        String cartQuantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
        System.out.println(cartQuantity);
        Assert.assertEquals(cartQuantity, "1");

        // 10.Verify that default size is S
        String cartSize = driver.findElement(By.xpath("//span[@id ='layer_cart_product_attributes']")).getText().trim();
        System.out.println(cartSize);
        char cartSize1 = cartSize.charAt(cartSize.length() - 1);
        System.out.println(cartSize1);
        Assert.assertEquals(cartSize1, 'S');

        // 11.Verify that same name and price displayed as on the home page
        String nameFinal = driver.findElement(By.xpath("//span[@id = 'layer_cart_product_title']")).getText().trim();
        String priceFinal = driver.findElement(By.xpath("//span[@id = 'layer_cart_product_price']")).getText().trim();
        System.out.println(nameFinal + " / " + priceFinal);

        Assert.assertTrue(product.equals(nameFinal));
        Assert.assertTrue(price.equals(priceFinal));

    }
}