package models;

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


        @Column(name = "price", nullable = false)
        private Integer price;

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


        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }


    }


