package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CheckoutPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillBillingDetails implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String address;
    private final String city;
    private final String postCode;
    private final String country;
    private final String zone;

    public FillBillingDetails(String firstName, String lastName, String email, String telephone,
                               String address, String city, String postCode, String country, String zone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.zone = zone;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.FIRST_NAME_INPUT, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Enter.theValue(firstName).into(CheckoutPageUI.FIRST_NAME_INPUT),
                Enter.theValue(lastName).into(CheckoutPageUI.LAST_NAME_INPUT),
                Enter.theValue(email).into(CheckoutPageUI.EMAIL_INPUT),
                Enter.theValue(telephone).into(CheckoutPageUI.TELEPHONE_INPUT),
                Enter.theValue(address).into(CheckoutPageUI.ADDRESS_INPUT),
                Enter.theValue(city).into(CheckoutPageUI.CITY_INPUT),
                Enter.theValue(postCode).into(CheckoutPageUI.POST_CODE_INPUT),
                SelectFromOptions.byVisibleText(country).from(CheckoutPageUI.COUNTRY_SELECT),
                WaitUntil.the(CheckoutPageUI.zoneOption(zone), isEnabled())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                SelectFromOptions.byVisibleText(zone).from(CheckoutPageUI.ZONE_SELECT),
                Click.on(CheckoutPageUI.STEP_2_CONTINUE_BUTTON)
        );
    }

    public static FillBillingDetails with(String firstName, String lastName, String email,
                                           String telephone, String address, String city,
                                           String postCode, String country, String zone) {
        return instrumented(FillBillingDetails.class, firstName, lastName, email, telephone,
                address, city, postCode, country, zone);
    }
}
