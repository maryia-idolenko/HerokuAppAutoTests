package tests;

import org.testng.annotations.Test;

public class FileUploader extends BaseTest {

    @Test
    public void fileUploader() {
        fileUploader.openPageFileUploader();
        fileUploader.fileUpload();
        fileUploader.fileName();
    }
}