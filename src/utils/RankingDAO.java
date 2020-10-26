package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.RankingAvg;

public class RankingDAO {
    // データベース接続と結果取得のための変数
    private PreparedStatement pstmt;
    private ResultSet rs;

    public List<RankingAvg> getRankingAvgs() {
            // メソッドの結果として返すリスト
            List<RankingAvg> results = new ArrayList<RankingAvg>();

            try {
                    // 1,2. ドライバを読み込み、DBに接続
                    Connection con = DatabaseManager.getConnection();

                    // 3. DBとやりとりする窓口（Statementオブジェクト）の作成
                    String sql = "select r.name as name, avg(l.point) as point " + "from rankings l " + "join ramens r on l.ramen_id = r.id "
                            + "group by ramen_id order by avg(point) desc ;";
                    pstmt = con.prepareStatement(sql);

                    // 4, 5. Select文の実行と結果を格納／代入
                    rs = pstmt.executeQuery();

                    // 6. 結果を表示する
                    while (rs.next()) {
                            // 1件ずつCountryオブジェクトを生成して結果を詰める
                            RankingAvg rankingavg = new RankingAvg();
                            rankingavg.setRamen_name(rs.getString("name"));
                            rankingavg.setPoint(rs.getDouble("point"));

                            // リストに追加
                            results.add(rankingavg);
                    }
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            } catch (SQLException e) {
                    e.printStackTrace();
            } finally{
                    if( rs != null ){
                            try {
                                    rs.close();
                            } catch (SQLException e) {
                                    e.printStackTrace();
                            }
                    }
                    if( pstmt != null ){
                            try {
                                    pstmt.close();
                            } catch (SQLException e) {
                                    e.printStackTrace();
                            }
                    }
                    DatabaseManager.close();
            }
            return results;
    }

}
