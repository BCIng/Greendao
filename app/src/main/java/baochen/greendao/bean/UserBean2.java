package baochen.greendao.bean;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by baochen on 2016/10/11.
 * 一对一关联
 */
public class UserBean2 {
    @Id
    private Long id;

    private long customerId;

    @ToOne(joinProperty = "customerId")
    private Customer customer;
    private String aaa;
}
