package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.HomePageUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToPhonesPdas implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePageUI.PHONES_PDAS_LINK, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(HomePageUI.PHONES_PDAS_LINK)
        );
    }

    public static NavigateToPhonesPdas section() {
        return instrumented(NavigateToPhonesPdas.class);
    }
}
