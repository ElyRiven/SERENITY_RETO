package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.ProductsPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddFirstProductToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPageUI.FIRST_ADD_TO_CART_BUTTON),
                WaitUntil.the(ProductsPageUI.SUCCESS_NOTIFICATION, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(ProductsPageUI.NOTIFICATION_CLOSE_BUTTON)
        );
    }

    public static AddFirstProductToCart now() {
        return instrumented(AddFirstProductToCart.class);
    }
}
