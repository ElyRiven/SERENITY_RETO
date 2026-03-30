package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CheckoutPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectGuestCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.GUEST_CHECKOUT_RADIO, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(CheckoutPageUI.GUEST_CHECKOUT_RADIO),
                Click.on(CheckoutPageUI.STEP_1_CONTINUE_BUTTON)
        );
    }

    public static SelectGuestCheckout option() {
        return instrumented(SelectGuestCheckout.class);
    }
}
