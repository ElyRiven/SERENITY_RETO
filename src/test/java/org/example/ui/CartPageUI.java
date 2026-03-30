package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPageUI {

    public static final Target CART_DROPDOWN_BUTTON = Target.the("cart dropdown button")
            .locatedBy("//div[@id='cart']//button[@data-toggle='dropdown']");

    public static final Target CART_COUNT = Target.the("cart total count")
            .located(By.id("cart-total"));

    public static final Target VIEW_CART_LINK = Target.the("View Cart link")
            .locatedBy("//a[contains(normalize-space(.),'View Cart')]");

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .locatedBy("//a[contains(normalize-space(.),'Checkout') and contains(@href,'checkout')]");
}
