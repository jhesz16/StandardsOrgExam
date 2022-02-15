package Pages;

import Pages.Forms.Callback;
import Helpers.GlobalHelpers;
import org.openqa.selenium.By;

import static Helpers.GlobalHelpers.*;

public class CallBackForm {

    public Callback callback;
    public CallBackForm() {
        callback = new Callback();
    }

    public void switchToLastTab()
    {
        GlobalHelpers.switchToLastTab();
    }
    public void areYouAnExistingCustomer(String yesNo) {
        switchToLastTab();
        getObj("//*[@class='ToggleButton__StyledText-sc-1sk4h07-2 dicaKa']").findElement(By.xpath("//*[text()='"+yesNo+"']")).click();
    }

    public void fillForm(String firstName,String lastName,String state,String phone,String email)
    {
        callback.setFirstName(firstName);
        callback.setLastName(lastName);
        callback.selectState(state);
        callback.setPhoneNumber(phone);
        callback.setEmail(email);
    }

    public void clickSubmit()
    {
        clickObj("//*[text()='Submit']");
    }

    public boolean validateThankYouHeader()
    {
        return validateObj("//*[@id='page-outcome-rowthankyoupageheader-columns3-thankyoupageheadercontent2']/h1");
    }

}