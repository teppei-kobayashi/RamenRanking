package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Ranking;

public class RankingValidator {
    public static List<String> validate(Ranking l) {
        List<String> errors = new ArrayList<String>();

        String point_error = _validatePoint(String.valueOf(l.getPoint()));
        if(!point_error.equals("")) {
            errors.add(point_error);
        }

        return errors;
    }

    private static String _validatePoint(String point) {
        if(point == null || point.equals("")) {
            return "点数を入力してください。";
            }

        return "";
    }
}