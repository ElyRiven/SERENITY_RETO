package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CheckoutPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AcceptTermsAndContinue implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.TERMS_CHECKBOX, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(CheckoutPageUI.TERMS_CHECKBOX),
                Click.on(CheckoutPageUI.STEP_5_CONTINUE_BUTTON)
        );
    }

    public static AcceptTermsAndContinue now() {
        return instrumented(AcceptTermsAndContinue.class);
    }
}
