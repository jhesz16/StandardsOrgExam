package Pages;

import io.qameta.allure.Step;

import static Helpers.GlobalHelpers.clickObj;

public class Home {

    public Home() {

    }

    @Step("Navigate to")
    public void navigateTo(String value) {
        clickObj("//*[text()='View all home loans']");
    }


}