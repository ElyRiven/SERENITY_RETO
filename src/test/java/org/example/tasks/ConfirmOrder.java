package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CheckoutPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.CONFIRM_ORDER_BUTTON, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(CheckoutPageUI.CONFIRM_ORDER_BUTTON)
        );
    }

    public static ConfirmOrder now() {
        return instrumented(ConfirmOrder.class);
    }
}
