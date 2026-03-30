package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPageUI {

    // Step 1 - Checkout Options
    public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio button")
            .locatedBy("//input[@type='radio'][@value='guest']");

    public static final Target STEP_1_CONTINUE_BUTTON = Target.the("step 1 continue button")
            .located(By.id("button-account"));

    // Step 2 - Billing Details
    public static final Target FIRST_NAME_INPUT = Target.the("first name input")
            .located(By.id("input-payment-firstname"));

    public static final Target LAST_NAME_INPUT = Target.the("last name input")
            .located(By.id("input-payment-lastname"));

    public static final Target EMAIL_INPUT = Target.the("email input")
            .located(By.id("input-payment-email"));

    public static final Target TELEPHONE_INPUT = Target.the("telephone input")
            .located(By.id("input-payment-telephone"));

    public static final Target ADDRESS_INPUT = Target.the("address 1 input")
            .located(By.id("input-payment-address-1"));

    public static final Target CITY_INPUT = Target.the("city input")
            .located(By.id("input-payment-city"));

    public static final Target POST_CODE_INPUT = Target.the("post code input")
            .located(By.id("input-payment-postcode"));

    public static final Target COUNTRY_SELECT = Target.the("country select")
            .located(By.id("input-payment-country"));

    public static final Target ZONE_SELECT = Target.the("zone/state select")
            .located(By.id("input-payment-zone"));

    public static Target zoneOption(String zoneName) {
        return Target.the(zoneName + " zone option")
                .locatedBy("//select[@id='input-payment-zone']/option[normalize-space(.)='" + zoneName + "']");
    }

    public static final Target STEP_2_CONTINUE_BUTTON = Target.the("step 2 continue button")
            .located(By.id("button-guest"));

    // Step 4 - Delivery Method
    public static final Target STEP_4_CONTINUE_BUTTON = Target.the("step 4 continue button")
            .located(By.id("button-shipping-method"));

    // Step 5 - Payment Method / Terms
    public static final Target TERMS_CHECKBOX = Target.the("terms and conditions checkbox")
            .locatedBy("//input[@type='checkbox'][@name='agree']");

    public static final Target STEP_5_CONTINUE_BUTTON = Target.the("step 5 continue button")
            .located(By.id("button-payment-method"));

    // Step 6 - Confirm Order
    public static final Target CONFIRM_ORDER_BUTTON = Target.the("confirm order button")
            .locatedBy("//input[@type='button'][@value='Confirm Order']");

    // Success page
    public static final Target SUCCESS_HEADING = Target.the("order success heading")
            .locatedBy("//h1[contains(text(),'Your order has been placed')]");
}
