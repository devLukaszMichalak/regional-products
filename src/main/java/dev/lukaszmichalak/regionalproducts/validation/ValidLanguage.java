package dev.lukaszmichalak.regionalproducts.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LanguageValidator.class)
public @interface ValidLanguage {
  String message() default "Invalid language. Must be 'pl' or 'en'.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
