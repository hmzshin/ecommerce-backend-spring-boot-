package com.workintech.ecommerce.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.dto.CardDto;
import com.workintech.ecommerce.dto.ProductImagesRequestBody;
import com.workintech.ecommerce.dto.ProductRequestBody;
import com.workintech.ecommerce.dto.UserRequestBody;
import com.workintech.ecommerce.entity.ProductImages;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.exception.ValidationException;

import org.springframework.http.HttpStatus;

public class EntityValidations {

    public static final String ID_SMALL_THEN_ZERO = " id can not be less then zero.";
    public static final String ID_IS_NULL = " id can not be null.";
    public static final String STRING_IS_NULL = " can not be null.";
    public static final String STRING_IS_EMPTY = " can not be empty.";
    public static final String NAME_LESS_THEN = "Name can not be less then or equal to two characters.";
    public static final String NAME_GREATER_THEN = "Name can not be greater then  20 characters.";
    public static final String PHONE_IS_NOT_VALID = "Phone number is not valid.";
    public static final String EMAIL_IS_NOT_VALID = "Email is not valid.";
    public static final String TAX_IS_NOT_VALID = "Tax no is not valid.";
    public static final String IBAN_IS_NOT_VALID = "IBAN number is not valid.";

    private static ValidationException badRequest(String string) {
        return new ValidationException(string, HttpStatus.BAD_REQUEST);
    }

    private static void checkForString(String string, String field) {

        if (string == null) {
            throw badRequest(field + STRING_IS_NULL);
        }

        if (string.isEmpty()) {
            throw badRequest(field + STRING_IS_EMPTY);
        }

    }

    public static void isIdValid(String field, Long id) {

        if (id == null) {
            throw badRequest(field + ID_IS_NULL);
        }

        if (id < 0) {
            throw badRequest(field + ID_SMALL_THEN_ZERO);
        }

    }

    public static void isNameValid(String name) {

        checkForString(name, "Name");

        if (name.length() <= 2) {
            throw badRequest(NAME_LESS_THEN);
        }

        if (name.length() > 20) {
            throw badRequest(NAME_GREATER_THEN);
        }

    }

    public static void isSurnameValid(String name) {

        checkForString(name, "Surname");

        if (name.length() <= 2) {
            throw badRequest(NAME_LESS_THEN);
        }

        if (name.length() > 20) {
            throw badRequest(NAME_GREATER_THEN);
        }

    }

    public static void isPhoneValid(String phone) {

        checkForString(phone, "Phone");

        String regex = "^\\+90\\d{10}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {

            throw badRequest(PHONE_IS_NOT_VALID);
        }

    }

    public static void isEmailValid(String email) {

        checkForString(email, "Email");

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {

            throw badRequest(EMAIL_IS_NOT_VALID);
        }

    }

    public static void isTaxNoValid(String taxNo) {

        checkForString(taxNo, "Tax no");

        String regex = "T\\d{4}V\\d{6}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(taxNo);

        if (!matcher.matches()) {

            throw badRequest(TAX_IS_NOT_VALID);
        }

    }

    public static void isIbanValid(String iban) {

        checkForString(iban, "Tax no");

        iban = iban.replaceAll("\\s", "").toUpperCase();

        String regex = "^TR\\d{22}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(iban);

        if (!matcher.matches()) {
            throw badRequest(IBAN_IS_NOT_VALID);
        }

    }

    public static void isCardNoValid(String cardNo) {

        checkForString(cardNo, "Card no");

        String cleanedCardNumber = cardNo.replaceAll("\\s|-", "");

        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(cleanedCardNumber);

        if (!matcher.matches()) {
            throw badRequest("Card no is not valid.");
        }
    }

    public static void isExpireYearValid(Integer year) {
        isNumberValid(year, "Year");
        if (year < 2024) {
            throw badRequest("Expire year is not valid");
        }
    }

    public static void isExpireMonthValid(Integer month) {
        isNumberValid(month, "Month");
        if (month < LocalDate.now().getMonthValue() || month > 12) {
            throw badRequest("Expire month is not volid");
        }
    }

    public static void isCcvValid(Integer ccv) {
        isNumberValid(ccv, "Ccv");
        if (ccv % 1000 != 0 || ccv % 10000 != 0) {
            throw badRequest("Ccv can be 3 or 4 digits but you provide different digits.");
        }
    }


    private static void isNumberValid(Double number, String field) {

        if (number == null) {
            throw badRequest(field + STRING_IS_NULL);
        }

        if (number < 0) {
            throw badRequest(field + " can not less then zero.");
        }

    }

    private static void isNumberValid(Integer number, String field) {

        if (number == null) {
            throw badRequest(field + STRING_IS_NULL);
        }

        if (number < 0) {
            throw badRequest(field + " can not less then zero.");
        }

    }

    private static void isNumberValid(Long number) {

        if (number == null) {
            throw badRequest("Sell count" + STRING_IS_NULL);
        }

        if (number < 0) {
            throw badRequest("Sell count" + " can not less then zero.");
        }

    }

    public static void isUrlValid(String url) {

        checkForString(url, "Url");
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw badRequest(e.getMessage());
        }

    }

    public static void isProductImagesCredentialsValid(ProductImagesRequestBody productImages) {
        if (productImages == null) {
            throw badRequest("ProductImages object can not be empty.");
        }
        isUrlValid(productImages.getUrl());
        isNumberValid(productImages.getIndex(), "Index");
    }

    public static void isProductImagesCredentialsValid(ProductImages productImages) {
        if (productImages == null) {
            throw badRequest("ProductImages object can not be empty.");
        }
        isUrlValid(productImages.getUrl());
        isNumberValid(productImages.getIndex(), "Index");
    }

    public static void isUserCredentialsValid(UserRequestBody user) {
        isNameValid(user.getName());
        isSurnameValid(user.getSurname());
        isEmailValid(user.getEmail());
        Store s = user.getStore();
        if (s != null) {
            isStoreCredentialsValid(s);
        }
    }

    public static void isStoreCredentialsValid(Store store) {
        if (store == null) {
            throw badRequest("Store can not be empty");
        }
        isNameValid(store.getName());
        isTaxNoValid(store.getTaxNo());
        isIbanValid(store.getBankAccount());
        isPhoneValid(store.getPhone());
    }

    public static void isProductCredentialsValid(ProductRequestBody product) {
        if (product == null) {
            throw badRequest("Product" + STRING_IS_EMPTY);
        }

        isNameValid(product.getName());
        checkForString(product.getDescription(), "Description");
        isNumberValid(product.getPrice(), "Price");
        isNumberValid(product.getStock(), "Stock");
        isNumberValid(product.getRating(), "Rating");
        isNumberValid(product.getSellCount());
        isIdValid("Store", product.getStoreId());
        isIdValid("Category", product.getCategoryId());

        if (product.getImages() == null) {
            throw badRequest("Images of a product can not be empty");
        }

        for (ProductImagesRequestBody productImages : product.getImages()) {
            isProductImagesCredentialsValid(productImages);
        }

    }


    public static void isAddressCredentialsValid(AddressDto addressDto) {
        checkForString(addressDto.getTitle(), "Title");
        checkForString(addressDto.getCity(), "City");
        checkForString(addressDto.getDistrict(), "District");
        checkForString(addressDto.getNeighborhood(), "Neighborhood");
        checkForString(addressDto.getAddress(), "Address");
        isNameValid(addressDto.getName());
        isSurnameValid(addressDto.getSurname());
        isPhoneValid(addressDto.getPhone());
        isIdValid("User", addressDto.getUserId());
    }

    public static void isCardCredentialsValid(CardDto cardDto) {

        isNameValid(cardDto.getNameOnCard());
        isCardNoValid(cardDto.getCardNo());
        isExpireMonthValid(cardDto.getExpireMonth());
        isExpireYearValid(cardDto.getExpireYear());
        isCcvValid(cardDto.getCcv());
        isIdValid("User", cardDto.getUserId());

    }

}
