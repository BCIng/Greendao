package baochen.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by baochen on 2016/10/11.注解示例
 */
@Entity
public class UserBean1 {
    @Id
    private Long id;
    @NotNull
    private String name;
    @Transient
    private String age;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1993087290)
    public UserBean1(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1050851894)
    public UserBean1() {
    }

}
