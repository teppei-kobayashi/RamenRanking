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

@Table(name = "rankings")
@NamedQueries({
    @NamedQuery(
            name = "getAllRankings",
            query = "SELECT r FROM Ranking AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getRankingsCount",
            query = "SELECT COUNT(r) FROM Ranking AS r"
            ),
})
@Entity
public class Ranking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "loginuser_id", nullable = false)
    private LoginUser loginuser;

    @ManyToOne
    @JoinColumn(name = "ramen_id", nullable = false)
    private Ramen ramen;

    @Column(name = "product", nullable = false)
    private Integer product;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "place", nullable = false)
    private Integer place;


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


    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }


}