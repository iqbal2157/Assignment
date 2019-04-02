package nl.backbase.automation.updateComputer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.updateComputer.UpdateComputer;

public class UpdateComputerStepDefinitions {

    @Steps
    private DataMapper dataMapper;

    private UpdateComputer updateComputer;

    @When("^user enter the computer details to edit$")
    public void enter_new_computer_details_to_update(){
        String name = dataMapper.getUpdateComputerValueof("name");
        String introducedDate = dataMapper.getUpdateComputerValueof("introducedDate");
        String discontinueDate = dataMapper.getUpdateComputerValueof("discontinuedDate");
        String company = dataMapper.getUpdateComputerValueof("company");

        updateComputer.enterName(name);
        updateComputer.enterIntroducedDate(introducedDate);
        updateComputer.enterDiscontinuedDate(discontinueDate);
        updateComputer.selectCompany(company);
    }

    @And("^click on Update_This_Computer_Button$")
    public void click_on_update_button(){
        updateComputer.clickOnSave();
    }

}
