package livehouses;

public class AppState {
    private SystemUser loggedUser;
    private boolean userIsLogged;

    public SystemUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(SystemUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isUserIsLogged() {
        return userIsLogged;
    }

    public void setUserIsLogged(boolean userIsLogged) {
        this.userIsLogged = userIsLogged;
    }
}
