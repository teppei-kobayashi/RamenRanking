package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Ramen;

public class RamenValidator {
    public static List<String> validate(Ramen r) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(r.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }

        return errors;
    }

    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "ラーメン名を入力してください。";
            }

        return "";
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }

}
