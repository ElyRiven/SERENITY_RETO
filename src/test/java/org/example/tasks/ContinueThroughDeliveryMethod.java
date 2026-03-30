package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CheckoutPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContinueThroughDeliveryMethod implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.STEP_4_CONTINUE_BUTTON, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(CheckoutPageUI.STEP_4_CONTINUE_BUTTON)
        );
    }

    public static ContinueThroughDeliveryMethod now() {
        return instrumented(ContinueThroughDeliveryMethod.class);
    }
}
