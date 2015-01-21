package yuri.misyac.productmanager.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOCUMENT")
public class Document {

    @Id
    @GeneratedValue
    @Column(name = "DOCUMENT_ID")
    private Integer id;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "operation")
    private String operationType;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "product")
    private Integer productId;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product", insertable = false, updatable = false)
    private Product manyToOneProductId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getManyToOneProductId() {
        return manyToOneProductId;
    }

    public void setManyToOneProductId(Product manyToOneProductId) {
        this.manyToOneProductId = manyToOneProductId;
    }
}
