package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {

    public static final Target PHONES_PDAS_LINK = Target.the("Phones & PDAs navigation link")
            .locatedBy("//a[contains(normalize-space(.),'Phones') and contains(normalize-space(.),'PDAs')]");
}
