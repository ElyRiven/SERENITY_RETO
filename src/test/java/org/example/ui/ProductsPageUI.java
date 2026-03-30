package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPageUI {

    public static final Target FIRST_ADD_TO_CART_BUTTON = Target.the("first Add to Cart button")
            .locatedBy("(//button[.//i and .//span[text()='Add to Cart']])[1]");

    public static final Target SECOND_ADD_TO_CART_BUTTON = Target.the("second Add to Cart button")
            .locatedBy("(//button[.//i and .//span[text()='Add to Cart']])[2]");

    public static final Target SUCCESS_NOTIFICATION = Target.the("cart success notification")
            .locatedBy("//div[contains(@class,'alert-success')]");

    public static final Target NOTIFICATION_CLOSE_BUTTON = Target.the("notification close button")
            .locatedBy("//div[contains(@class,'alert-success')]//button[@data-dismiss='alert']");
}
