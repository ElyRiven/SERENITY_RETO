package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CartPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProceedToCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPageUI.CHECKOUT_BUTTON, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(CartPageUI.CHECKOUT_BUTTON)
        );
    }

    public static ProceedToCheckout now() {
        return instrumented(ProceedToCheckout.class);
    }
}
