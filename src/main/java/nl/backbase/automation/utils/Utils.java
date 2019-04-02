package nl.backbase.automation.utils;

import net.thucydides.core.pages.PageObject;

public class Utils extends PageObject {

    public void fixedWait(int waitTimeInMiliSeconds) {
        try {
            Thread.sleep(waitTimeInMiliSeconds);
        } catch (Exception e) {

        }
    }

}
