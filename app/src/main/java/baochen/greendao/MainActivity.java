package baochen.greendao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import baochen.greendao.bean.UserBean;
import baochen.greendao.dao.gen.UserBeanDao;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText mNameET, mNewNameET;
    private Button mAddBtn, mDeleteBtn, mUpdateBtn;
    private ListView mUserLV;

    private UserAdapter mUserAdapter;
    private List<UserBean> mUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化
        initData();//查询数据
    }

    private void initView() {
        mNameET = (EditText) findViewById(R.id.et_name);
        mAddBtn = (Button) findViewById(R.id.btn_add);
        mDeleteBtn = (Button) findViewById(R.id.btn_delete);
        mUpdateBtn = (Button) findViewById(R.id.btn_update);
        mUserLV = (ListView) findViewById(R.id.lv_user);
        mNewNameET = (EditText) findViewById(R.id.et_newName);
        mAddBtn.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
        mUpdateBtn.setOnClickListener(this);
    }

    private void initData() {
        mUserList = GreenDaoManager.getInstance().getSession().getUserBeanDao().queryBuilder().build().list();
        mUserAdapter = new UserAdapter(this, mUserList);
        mUserLV.setAdapter(mUserAdapter);
    }

    /**
     * 根据名字更新某条数据的名字
     *
     * @param prevName 原名字
     * @param newName  新名字
     */
    private void updateUser(String prevName, String newName) {
        UserBeanDao userBeanDao = GreenDaoManager.getInstance().getSession().getUserBeanDao();
        //更新单个
//        UserBean findUser = GreenDaoManager.getInstance().getSession().getUserBeanDao().queryBuilder()
//                .where(UserBeanDao.Properties.Name.eq(prevName)).build().unique();
//        if (findUser != null) {
//            findUser.setName(newName);
//            GreenDaoManager.getInstance().getSession().getUserBeanDao().update(findUser);
//            Toast.makeText(MyApplication.getContext(), "修改成功", Toast.LENGTH_SHORT).show();
//
//        } else {
//            Toast.makeText(MyApplication.getContext(), "用户不存在", Toast.LENGTH_SHORT).show();
//        }
//批量更新
        List<UserBean> userList = userBeanDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(prevName)).build().list();
        Log.e("userList", userList + "");
        if (userList.isEmpty()) {
            Toast.makeText(MyApplication.getContext(), "用户不存在", Toast.LENGTH_SHORT).show();
        } else {
            for (UserBean user : userList) {
                user.setName(newName);
                userBeanDao.update(user);
                Log.e("修改", "修改成功");
            }
            Toast.makeText(MyApplication.getContext(), "更新成功", Toast.LENGTH_SHORT).show();
        }

        mNewNameET.setText("");
        mNameET.setText("");
        mUserList.clear();
        mUserList.addAll(userBeanDao.queryBuilder().build().list());
        mUserAdapter.notifyDataSetChanged();
    }

    /**
     * 根据名字删除某用户
     *
     * @param name
     */
    private void deleteUser(String name) {
        UserBeanDao userBeanDao = GreenDaoManager.getInstance().getSession().getUserBeanDao();
        //删除
//        UserBean findUser = userBeanDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(name)).build().unique();
//        if (findUser != null) {
//            userBeanDao.deleteByKey(findUser.getId());
//            Toast.makeText(this,"删除成功",Toast.LENGTH_LONG).show();
//        }
        //根据某一个条件批量删除
        List<UserBean> userList = userBeanDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(name)).build().list();
        for (UserBean user : userList) {
            userBeanDao.delete(user);
            Toast.makeText(this, "删除成功", Toast.LENGTH_LONG).show();
        }

        mNameET.setText("");
        mUserList.clear();
        mUserList.addAll(userBeanDao.queryBuilder().build().list());
        mUserAdapter.notifyDataSetChanged();
    }

    /**
     * 本地数据里添加一个User
     *
     * @param id   id
     * @param name 名字
     */
    private void insertUser(Long id, String name) {
        UserBeanDao userDao = GreenDaoManager.getInstance().getSession().getUserBeanDao();
        UserBean user = new UserBean(id, name);
        userDao.insert(user);
        mNameET.setText("");
        mUserList.clear();
        mUserList.addAll(userDao.queryBuilder().build().list());
        mUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.btn_add:
                insertUser(null, mNameET.getText().toString().trim());
                break;
            case R.id.btn_delete:
                deleteUser(mNameET.getText().toString().trim());
                break;
            case R.id.btn_update:
                updateUser(mNameET.getText().toString().trim(), mNewNameET.getText().toString().trim());
                break;
            default:
                break;
        }
    }
}

