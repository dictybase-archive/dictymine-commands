package org.dictybase.validation;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class ValidateParameters implements IParameterValidator {
    public void validate(String name, String value)
            throws ParameterException {
        if (name == null || name.trim().length() == 0) {
            throw new ParameterException("Parameter " + name + " is empty");
        }
    }
}
