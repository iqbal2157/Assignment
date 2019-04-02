package nl.backbase.automation.deleteComputer;

import cucumber.api.java.en.When;
import nl.backbase.automation.pages.deleteComputer.DeleteComputer;

public class DeleteComputerStepDefinitions {
    private DeleteComputer deleteComputer;

    @When("^click on Delete_This_Computer_Button$")
    public void click_on_delete_button(){
        deleteComputer.clickOnDelete();
    }

}
