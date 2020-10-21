package carshare;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Stock_table")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long stock;

    @PrePersist
    public void onPrePersist(){
        Added added = new Added();
        BeanUtils.copyProperties(this, added);
        added.publishAfterCommit();


        Reduced reduced = new Reduced();
        BeanUtils.copyProperties(this, reduced);
        reduced.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }




}
