package nl.backbase.automation.shared;

import cucumber.api.java.Before;
import nl.backbase.automation.utils.DataFactory;

public class SharedStepDefinitions {

    @Before
    public void initiateDataFile() {
        DataFactory.parseDataFile();
    }


}
