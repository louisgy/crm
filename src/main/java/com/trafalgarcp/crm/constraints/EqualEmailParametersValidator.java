package com.trafalgarcp.crm.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;


@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class EqualEmailParametersValidator implements ConstraintValidator<EqualEmailParameters, Object[]> {

    @Override
    public void initialize(EqualEmailParameters constraintAnnotation) {}

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    	
    	System.out.println("first email : "+value[4]+"---------------+++++++++++++++++++++++++++++++++");
    	System.out.println("first email : "+value[5]+"---------------+++++++++++++++++++++++++++++++++");

       if (!(value[4] instanceof String) || !(value[5] instanceof String)) {
            throw new IllegalArgumentException("Illegal method signature. Two String parameters expected.");
        }

        return value[4].equals(value[5]);
    
    }
}
