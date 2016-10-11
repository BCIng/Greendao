package baochen.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by baochen on 2016/10/11.
 *
 */
@Entity
public class Customer {
    @Id
    private Long id;
    @NotNull
    private String customer;
    public String getCustomer() {
        return this.customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 726688893)
    public Customer(Long id, @NotNull String customer) {
        this.id = id;
        this.customer = customer;
    }
    @Generated(hash = 60841032)
    public Customer() {
    }
}
