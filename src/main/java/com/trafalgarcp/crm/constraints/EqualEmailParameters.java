package com.trafalgarcp.crm.constraints;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EqualEmailParametersValidator.class})
public @interface EqualEmailParameters {

    String message() default "{com.readlearncode.model.constraints.EqualEmailParameters.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
