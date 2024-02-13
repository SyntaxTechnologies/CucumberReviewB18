package utils;

import pages.LoginPage;
import  pages.DashBoardPage;

public class PageInitializer {
    public static LoginPage login;
    public static DashBoardPage dashboardPage;



    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashBoardPage();

    }
}
