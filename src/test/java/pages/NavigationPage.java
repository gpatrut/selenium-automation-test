package pages;

import utils.ConfigReader;

public class NavigationPage extends BasePage {

    protected String baseUrl = ConfigReader.get("baseUrl");

    public void goToUrl(String url) {
        String path;

        switch (url) {
            case "login":
                path = "customer/account/login/";
                break;
            case "home":
                path = "/";
                break;
            case "create account":
                path = "customer/account/create/";
                break;
            case "bag category":
                path = "gear/bags.html";
                break;
            default:
                throw new IllegalArgumentException("Unknown URL alias: " + url);
        }
        driver.get(baseUrl + path);
    }
}
