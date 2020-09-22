package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.LoginUser;
import utils.DBUtil;

public class LoginUserValidator {
    public static List<String> validate(LoginUser l, Boolean mail_address_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String mail_address_error = _validateMail_Address(l.getMail_address(), mail_address_duplicate_check_flag);
        if(!mail_address_error.equals("")) {
            errors.add(mail_address_error);
        }

        String name_error = _validateName(l.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(l.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;
    }

    //メールアドレス
    private static String _validateMail_Address(String mail_address, Boolean mail_address_duplicate_check_flag) {
        //必須入力チェック
        if(mail_address == null || mail_address.equals("")) {
            return "メールアドレスを入力してください。";
        }

        // すでに登録されている社員番号との重複チェック
        if(mail_address_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long loginusers_count = (long)em.createNamedQuery("checkRegisteredMailAddress", Long.class)
                                           .setParameter("mail_address", mail_address)
                                             .getSingleResult();
            em.close();
            if(loginusers_count > 0) {
                return "入力されたメールアドレスはすでに使用しています。";
            }
        }

        return "";
    }
 // ユーザー名の必須入力チェック
    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "ユーザー名を入力してください。";
        }

        return "";
    }

    // パスワードの必須入力チェック
    private static String _validatePassword(String password, Boolean password_check_flag) {
        // パスワードを変更する場合のみ実行
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }

}
