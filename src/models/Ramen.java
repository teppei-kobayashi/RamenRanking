package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "ramens")
@NamedQueries({
    @NamedQuery(
            name = "getAllRamens",
            query = "SELECT r FROM Ramen AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getRamensCount",
            query = "SELECT COUNT(r) FROM Ramen AS r"
            ),
})
@Entity
public class Ramen {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "type", nullable = false)
        private String type;

        @Lob
        @Column(name = "content", nullable = false)
        private String content;

        @Column(name = "product", nullable = false)
        private String product;

        @Column(name = "price", nullable = false)
        private Integer price;

        @Column(name = "place", nullable = false)
        private String place;

        @Column(name = "promotion", nullable = false)
        private String promotion;

        @Column(name = "created_at", nullable = false)
        private Timestamp created_at;

        @Column(name = "updated_at", nullable = false)
        private Timestamp updated_at;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getPromotion() {
            return promotion;
        }

        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }

        public Timestamp getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Timestamp created_at) {
            this.created_at = created_at;
        }

        public Timestamp getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Timestamp updated_at) {
            this.updated_at = updated_at;
        }
    }


