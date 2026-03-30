package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.hooks.OpenBrowser;
import org.example.questions.TheSuccessMessage;
import org.example.tasks.AcceptTermsAndContinue;
import org.example.tasks.AddFirstProductToCart;
import org.example.tasks.AddSecondProductToCart;
import org.example.tasks.ConfirmOrder;
import org.example.tasks.ContinueThroughDeliveryMethod;
import org.example.tasks.FillBillingDetails;
import org.example.tasks.NavigateToPhonesPdas;
import org.example.tasks.ProceedToCheckout;
import org.example.tasks.SelectGuestCheckout;
import org.example.tasks.ViewShoppingCart;
import org.example.ui.CheckoutPageUI;
import org.example.utils.Constants;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PurchaseFlowStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void theUserIsOnTheOpenCartHomePage() {
        OnStage.theActorCalled(Constants.ACTOR).wasAbleTo(
                OpenBrowser.inTheUrl(Constants.BASE_URL)
        );
    }

    @When("the user navigates to the {string} section")
    public void theUserNavigatesToTheSection(String section) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToPhonesPdas.section()
        );
    }

    @And("the user adds the first product to the cart")
    public void theUserAddsTheFirstProductToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddFirstProductToCart.now()
        );
    }

    @And("the user adds the second product to the cart")
    public void theUserAddsTheSecondProductToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddSecondProductToCart.now()
        );
    }

    @And("the user views the shopping cart")
    public void theUserViewsTheShoppingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ViewShoppingCart.now()
        );
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @And("the user selects the {string} option and continues")
    public void theUserSelectsTheOptionAndContinues(String option) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectGuestCheckout.option()
        );
    }

    @And("the user fills in the billing details:")
    public void theUserFillsInTheBillingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> details = data.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillBillingDetails.with(
                        details.get("firstName"),
                        details.get("lastName"),
                        details.get("email"),
                        details.get("telephone"),
                        details.get("address"),
                        details.get("city"),
                        details.get("postCode"),
                        details.get("country"),
                        details.get("zone")
                )
        );
    }

    @And("the user continues through the delivery method")
    public void theUserContinuesThroughTheDeliveryMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ContinueThroughDeliveryMethod.now()
        );
    }

    @And("the user accepts the terms and conditions and continues")
    public void theUserAcceptsTheTermsAndConditionsAndContinues() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AcceptTermsAndContinue.now()
        );
    }

    @And("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmOrder.now()
        );
    }

    @Then("the order is placed successfully with the message {string}")
    public void theOrderIsPlacedSuccessfullyWithTheMessage(String expectedMessage) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPageUI.SUCCESS_HEADING, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Ensure.that(TheSuccessMessage.fromThePage()).contains(expectedMessage)
        );
    }
}
