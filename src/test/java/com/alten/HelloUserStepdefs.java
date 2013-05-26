package com.alten;

import static org.junit.Assert.assertEquals;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import org.jemmy.control.Wrap;
import org.jemmy.fx.AppExecutor;
import org.jemmy.fx.Root;
import org.jemmy.fx.SceneDock;
import org.jemmy.fx.control.LabeledDock;
import org.jemmy.fx.control.TextInputControlDock;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloUserStepdefs {

    private SceneDock scene;
    private TextInputControlDock firstnameInput;
    private TextInputControlDock lastnameInput;
    private LabeledDock submitBtn;
    private LabeledDock messageLabel;

    @Given("^the application is running$")
    public void the_application_is_running() {
	scene = new SceneDock();
	firstnameInput = new TextInputControlDock(scene.asParent(),
		"firstNameField");
	lastnameInput = new TextInputControlDock(scene.asParent(),
		"lastNameField");
	messageLabel = new LabeledDock(scene.asParent(), Label.class,
		"messageLabel");
	submitBtn = new LabeledDock(scene.asParent(), Button.class);	
    }

    @When("^I enter \"([^\"]*)\" as first name$")
    public void I_enter_as_first_name(String firstName) {
	firstnameInput.type(firstName);
    }

    @When("^I enter \"([^\"]*)\" as last name$")
    public void I_enter_as_last_name(String lastName) {
	lastnameInput.type(lastName);
    }

    @And("^I press the submit button$")
    public void I_press_the_submit_button() {
	submitBtn.mouse().click();
    }

    @Then("^it should see the greeting with \"([^\"]*)\"$")
    public void it_should_see_the_greeting_with(String greetingMessage) {
	assertEquals(greetingMessage, messageLabel.getText());
    }

    @When("^I leave the first name and last name fieds empty$")
    public void I_leave_the_first_name_and_last_name_fieds_empty() {
	resetFields();
    }

    @Then("^it should see the greeting for the uknown person$")
    public void it_should_see_the_greeting_for_the_uknown_person() {
	assertEquals(MainApp.UKNOWN_PERSON_GREETING, messageLabel.getText());
    }


    @After
    public void resetFields() {
	clearTextInput(firstnameInput);
	clearTextInput(lastnameInput);
	clearLabelText(messageLabel);
    }

    private void clearTextInput(final TextInputControlDock textField) {
	textField.asSelectionText().clear();
    }

    private void clearLabelText(final LabeledDock label) {
	if (!label.getText().isEmpty()) {
	    label.clear();
	}
    }

}
