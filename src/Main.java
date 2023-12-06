import UI.LoginView;
import UI.ViewFactory;


public class Main {
    public static void main(String[] args) {
        LoginView loginView = ViewFactory.getInstance().getLoginView();
        loginView.setVisible(true);
    }
}
