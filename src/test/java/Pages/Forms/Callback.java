package Pages.Forms;

import Helpers.GlobalHelpers;

import static Pages.Forms.Callback.Locators.*;

public class Callback {



    public void setFirstName(String val)
    {
        GlobalHelpers.setValObj(FIRST_NAME,val);
    }

    public void setLastName(String val)
    {
        GlobalHelpers.setValObj(LAST_NAME,val);
    }
    public void setPhoneNumber(String val)
    {
        GlobalHelpers.setValObj(PHONE_NUMBER,val);
    }
    public void setEmail(String val)
    {
        GlobalHelpers.setValObj(EMAIL,val);
    }
    public void selectState(String val)
    {
        GlobalHelpers.selectValObj(STATE,val);
    }


    static class Locators{
        static final String FIRST_NAME =  "//*[@id='field-page-Page1-aboutYou-firstName']";
        static final String LAST_NAME =  "//*[@id='field-page-Page1-aboutYou-lastName']";
        static final String STATE =  "//div[@class='css-1hwfws3 react-select__value-container']";
        static final String PHONE_NUMBER =  "//*[@id='field-page-Page1-aboutYou-phoneNumber']";
        static final String EMAIL =  "//*[@id='field-page-Page1-aboutYou-email']";

    }

}
