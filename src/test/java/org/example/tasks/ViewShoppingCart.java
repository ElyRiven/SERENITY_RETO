package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.CartPageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewShoppingCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPageUI.CART_DROPDOWN_BUTTON),
                WaitUntil.the(CartPageUI.VIEW_CART_LINK, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(CartPageUI.VIEW_CART_LINK)
        );
    }

    public static ViewShoppingCart now() {
        return instrumented(ViewShoppingCart.class);
    }
}
