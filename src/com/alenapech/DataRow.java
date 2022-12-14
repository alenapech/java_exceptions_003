package com.alenapech;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataRow {

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private BigInteger phoneNumber;
    private String gender; // we can also implement Enum for Gender

    private static final String NAME_PATTERN   = "^\\D+$";
    private static final String DATE_PATTERN   = "^(([0-2]\\d)|30|31).([0-1][0-2]).(\\d{4})$";
    private static final String PHONE_PATTERN  = "^\\d{11}$";
    private static final String GENDER_PATTERN = "^f|m$";

    private void validate(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) {
        if (!isDataValid(lastName, NAME_PATTERN))
            throw new BusinessException("Last Name is incorrect", 1003);
        if (!isDataValid(firstName, NAME_PATTERN))
            throw new BusinessException("First Name is incorrect", 1004);
        if (!isDataValid(middleName, NAME_PATTERN))
            throw new BusinessException("Middle Name is incorrect", 1005);
        if (!isDataValid(birthDate, DATE_PATTERN))
            throw new BusinessException("Birth Date is incorrect", 1006);
        if (!isDataValid(phoneNumber, PHONE_PATTERN))
            throw new BusinessException("Phone Number is incorrect", 1007);
        if (!isDataValid(gender, GENDER_PATTERN))
            throw new BusinessException("Gender is incorrect", 1008);
    }

    private boolean isDataValid(String value, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public DataRow(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) {
        validate(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = new BigInteger(phoneNumber);
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
