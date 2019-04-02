package nl.backbase.automation.addComputer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import nl.backbase.automation.data_mappers.DataMapper;
import nl.backbase.automation.pages.addComputer.AddComputer;
import nl.backbase.automation.pages.homePage.HomePage;

public class AddComputerStepDefinitions {

    @Steps
    private DataMapper dataMapper;

    private HomePage homePage;
    private AddComputer addComputer;

    @When("^user enter the computer details to add$")
    public void enter_new_computer_details(){
        String name = dataMapper.getCreateComputerValueof("name");
        String introducedDate = dataMapper.getCreateComputerValueof("introducedDate");
        String discontinueDate = dataMapper.getCreateComputerValueof("discontinuedDate");
        String company = dataMapper.getCreateComputerValueof("company");

        addComputer.enterName(name);
        addComputer.enterIntroducedDate(introducedDate);
        addComputer.enterDiscontinuedDate(discontinueDate);
        addComputer.selectCompany(company);
    }

    @And("^click on Add_Computer_Button$")
    public void click_on_add_button(){
        addComputer.clickOnCreate();
    }
}
