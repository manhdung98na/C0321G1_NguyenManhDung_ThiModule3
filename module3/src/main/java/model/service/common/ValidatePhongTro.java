package model.service.common;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidatePhongTro {
    public static String validateName(String name) {
        name = name.trim();
        if (name.length() < 5){
            return "Min Length must be 5!";
        }
        if (name.length() > 50){
            return "Max Length must be 50";
        }
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex, name) ? null : "Invalid name! Need to upper case EACH FIRST CHARACTER";
    }

    public static String validatePhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        String regex = "^0[0-9]{9}$";
        return Pattern.matches(regex, phoneNumber) ? null : "Invalid phone number! Phone must have 10 digital character!";
    }

    public static String validateDate(String date) {
        String[] dates = date.split("-");
        String currentDate = LocalDate.now().toString();
        String[] currentDateArr = currentDate.split("-");
        if (Integer.parseInt(dates[0]) > Integer.parseInt(currentDateArr[0])) {
            return "Rent date must be a day in the past!";
        }
        if (Integer.parseInt(dates[0]) == Integer.parseInt(currentDateArr[0])) {
            if (Integer.parseInt(dates[1]) > Integer.parseInt(currentDateArr[1])) {
                return "Rent date must be a day in the past!";
            }
            if (Integer.parseInt(dates[1]) == Integer.parseInt(currentDateArr[1])) {
                if (Integer.parseInt(dates[2]) > Integer.parseInt(currentDateArr[2])) {
                    return "Rent date must be a day in the past!";
                }
            }
        }
        return null;
    }

    public static String validateNote(String note){
        if (note.length() > 200) {
            return "Note has max length is 200 characters!";
        }
        return null;
    }
}
