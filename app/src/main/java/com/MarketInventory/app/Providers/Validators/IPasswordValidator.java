package com.MarketInventory.app.Providers.Validators;

public interface IPasswordValidator {
    boolean compare(String password, String confirmPassword);
    boolean lenght(String password);
}
