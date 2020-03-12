package tests;

import org.testng.annotations.Test;

public class Frames extends BaseTest {

    @Test
    public void iframe() {
        iframe.openPageIframes();
        iframe.clickIframe();
        iframe.textIframeShouldExist();
    }
}