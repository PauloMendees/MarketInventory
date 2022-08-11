package com.MarketInventory.app.Providers.Validators;

public class PasswordValidator implements IPasswordValidator {

    @Override
    public boolean compare(String password, String confirmPassword) {
        return password == confirmPassword;
    }

    @Override
    public boolean lenght(String password) {
        return password.length() > 8;
    }
    
}
