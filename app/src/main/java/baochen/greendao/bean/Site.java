package baochen.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Administrator on 2016/10/10.
 */
@Entity
public class Site {
    @Id
    private Long id;
    @NotNull
    private String ownerTag;
    public String getOwnerTag() {
        return this.ownerTag;
    }
    public void setOwnerTag(String ownerTag) {
        this.ownerTag = ownerTag;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 277094653)
    public Site(Long id, @NotNull String ownerTag) {
        this.id = id;
        this.ownerTag = ownerTag;
    }
    @Generated(hash = 1136322986)
    public Site() {
    }
}