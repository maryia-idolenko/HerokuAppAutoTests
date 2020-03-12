package tests;

import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {

    @Test
    public void dynamicControls() {
        dynamicControls.openPageCheckbox();
        dynamicControls.clickRemoveButton();
        dynamicControls.messageShouldExist();
        dynamicControls.checkboxShouldNotExist();
        dynamicControls.inputField();
        dynamicControls.clickEnableButton();
        dynamicControls.messageEnabledShouldExist();
        dynamicControls.inputFieldEnabled();
    }
}