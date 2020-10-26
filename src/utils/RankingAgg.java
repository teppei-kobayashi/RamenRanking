package utils;

import java.util.List;

import models.RankingAvg;

public class RankingAgg {
    public static void main(String[] args) {
        // Countryクラスにアクセスするため、CountryDAOをインスタンス化
        RankingDAO dao = new RankingDAO();

        // 入力された値を引数に指定し、検索処理を実行し、Listオブジェクトを取得
        List<RankingAvg> list = dao.getRankingAvgs();

        // 取得したListオブジェクトを順番に取り出し、出力
        for(RankingAvg item : list){
                System.out.println(item.getRamen_name());
                System.out.println(item.getPoint());
        }
}


}
