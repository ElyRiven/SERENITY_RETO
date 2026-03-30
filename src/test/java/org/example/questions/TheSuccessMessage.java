package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.example.ui.CheckoutPageUI;

public class TheSuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPageUI.SUCCESS_HEADING.resolveFor(actor).getText();
    }

    public static TheSuccessMessage fromThePage() {
        return new TheSuccessMessage();
    }
}
