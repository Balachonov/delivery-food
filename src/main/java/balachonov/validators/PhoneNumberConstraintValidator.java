package balachonov.validators;

import balachonov.validators.anotations.Phone;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import static balachonov.util.Constants.CODE_BELARUS;
import static com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE;

public class PhoneNumberConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @SneakyThrows
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber blrPhoneNumber = phoneUtil.parse(phone, CODE_BELARUS);
        return phoneUtil.isValidNumberForRegion(blrPhoneNumber, CODE_BELARUS)
                && phoneUtil.isPossibleNumberForType(blrPhoneNumber, FIXED_LINE_OR_MOBILE);
    }
}