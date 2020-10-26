package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "rankings")
@NamedQueries({
    @NamedQuery(
            name = "getAllRankings",
            query = "SELECT a FROM Ranking As a ORDER BY a.id DESC"
            ),
    @NamedQuery(
            name = "getRankingsCount",
            query = "SELECT COUNT(a) FROM Ranking AS a"
            ),
    @NamedQuery(
            name = "getRankingsRamen",
            query = "SELECT a FROM Ranking AS a WHERE a.loginuser = :login_status AND a.ramen = :ramen_id"
            ),
    @NamedQuery(
            name = "getRankings",
            query = "SELECT a  FROM Ranking AS a "
            )
})

public class Ranking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "loginuser_id")
    private LoginUser loginuser;

    @ManyToOne
    @JoinColumn(name = "ramen_id")
    private Ramen ramen;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "point_flag", nullable = false)
    private Integer point_flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoginUser getLoginUser() {
        return loginuser;
    }

    public void setLoginUser(LoginUser loginuser) {
        this.loginuser = loginuser;
    }

    public Ramen getRamenId() {
        return ramen;
    }

    public void setRamenId(Ramen ramen) {
        this.ramen = ramen;
    }


    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }


    public Integer getPoint_flag() {
        return point_flag;
    }

    public void setPoint_flag(Integer point_flag) {
        this.point_flag = point_flag;
    }


}