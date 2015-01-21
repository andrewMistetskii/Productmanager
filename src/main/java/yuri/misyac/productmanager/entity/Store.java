package yuri.misyac.productmanager.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "STORE")
public class Store {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(
            name = "gen",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "product"))
    @Column(name = "PRODUCT_ID")
    private Integer product_id;

    @Column(name = "COUNT")
    private Integer count;

    @OneToOne(mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Product product;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
