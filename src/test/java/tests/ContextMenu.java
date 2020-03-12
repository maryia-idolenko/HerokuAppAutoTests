package tests;

import org.testng.annotations.Test;


public class ContextMenu extends BaseTest {

    @Test
    public void contextMenu() {
        contextMenu.openPage();
        contextMenu.rightClick();
        contextMenu.alertShouldExist();
        contextMenu.alertDismiss();
    }
}