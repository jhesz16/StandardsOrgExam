package Pages;

import static Helpers.GlobalHelpers.clickObj;
import static Helpers.ShadowHelpers.clickShadowObject;

public class HomeLoans {

    public HomeLoans() {

    }

    public void clickRequestACallBack() {
        clickObj("//*[text()='Request a call back']");
    }

    public void clickFirstRadioButton() throws InterruptedException
    {
        clickShadowObject("//div[@id='contact-form-shadow-root']", "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-0 > label\")");
    }
    public void clickNewHomeLoans() throws InterruptedException {
        clickFirstRadioButton();
    }

    public void clickNext() throws InterruptedException {
        clickShadowObject("//div[@id='contact-form-shadow-root']","document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#main-container > div > div.sc-ifAKCX.Col__StyledCol-o7bhp7-0.ibULtI > section > div.sc-bdVaJa.iAQrVS > button > div > span\")");
    }

    public void clickNext2() throws InterruptedException {
        clickShadowObject("//div[@id='contact-form-shadow-root']","document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#main-container > div > div.sc-ifAKCX.Col__StyledCol-o7bhp7-0.ibULtI > section > div.sc-bdVaJa.iAQrVS > button.Buttonstyle__StyledButton-sc-1vu4swu-3.cchfek > div > span\")");
    }


    public void clickBuyingANewProperty() throws InterruptedException {
        clickFirstRadioButton();
    }

}