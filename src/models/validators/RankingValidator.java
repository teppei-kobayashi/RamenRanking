package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Ranking;

public class RankingValidator {
    public static List<String> validate(Ranking r) {
        List<String> errors = new ArrayList<String>();

        String product_error = _validateProduct(String.valueOf(r.getProduct()));
        if(!product_error.equals("")) {
            errors.add(product_error);
        }

        String price_error = _validatePrice(String.valueOf(r.getPrice()));
        if(!price_error.equals("")) {
            errors.add(price_error);
        }

        String place_error = _validatePlace(String.valueOf(r.getPlace()));
        if(!place_error.equals("")) {
            errors.add(place_error);
        }

        return errors;
    }

    private static String _validateProduct(String product) {
        if(product == null || product.equals("")) {
            return "味の点数を入力してください。";
            }

        return "";
    }

    private static String _validatePrice(String price) {
        if(price == null || price.equals("")) {
            return "価格の点数を入力してください。";
            }

        return "";
    }

    private static String _validatePlace(String place) {
        if(place == null || place.equals("")) {
            return "アクセスの点数を入力してください。";
            }

        return "";
    }
}