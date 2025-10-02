package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission(){
        return new User(PropertyReader.getProperty("valid.username"),
                        PropertyReader.getProperty("valid.password"));
    }

    public static User withLockedUserPermission(){
        return new User(PropertyReader.getProperty("locked.username"),
                        PropertyReader.getProperty("valid.password"));
        }

    public static User withInvalidUserPermission(){
        return new User(PropertyReader.getProperty("invalid.username"),
                PropertyReader.getProperty("valid.password"));
    }

    public static User withUserEmptyPasswordPermission(){
        return new User(PropertyReader.getProperty("valid.username"),
                PropertyReader.getProperty("empty_password.password"));
    }
}