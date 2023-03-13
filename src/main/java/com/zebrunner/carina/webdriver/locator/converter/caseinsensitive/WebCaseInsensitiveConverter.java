package com.zebrunner.carina.webdriver.locator.converter.caseinsensitive;

import com.zebrunner.carina.webdriver.locator.LocatorType;

class WebCaseInsensitiveConverter extends AbstractPlatformDependsConverter implements IPlatformDependsConverter {

    @Override
    public String idToXpath(String by) {
        LocatorType type = LocatorType.APPIUM_BY_ID.is(by) ? LocatorType.APPIUM_BY_ID : LocatorType.BY_ID;
        return locatorToXpath(by, type,
                value -> createXpathFromAnotherTypeOfLocator(".", "*", "@id", "'", value));
    }

    @Override
    public String nameToXpath(String by) {
        LocatorType type = LocatorType.APPIUM_BY_NAME.is(by) ? LocatorType.APPIUM_BY_NAME : LocatorType.BY_NAME;
        return locatorToXpath(by, type, value -> createXpathFromAnotherTypeOfLocator(".", "*", "@name", "'", value));
    }

    @Override
    public String linkTextToXpath(String by) {
        return locatorToXpath(by, LocatorType.BY_LINKTEXT,
                value -> createXpathFromAnotherTypeOfLocator(".", "a", "text()", "'", value));
    }

    @Override
    public String xpathIdCaseInsensitive(String by) {
        return caseInsensitiveXpathByAttribute(by, "@id");
    }

    @Override
    public String xpathNameCaseInsensitive(String by) {
        return caseInsensitiveXpathByAttribute(by, "@name");
    }

    @Override
    public String xpathTextCaseInsensitive(String by) {
        return caseInsensitiveXpathByAttribute(by, "text\\(\\)");
    }

    @Override
    public String xpathClassCaseInsensitive(String by) {
        return caseInsensitiveXpathByAttribute(by, "@class");
    }

}
