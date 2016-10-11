package baochen.greendao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import baochen.greendao.bean.UserBean;

/**
 * Created by Administrator on 2016/9/30.
 */
public class UserAdapter extends BaseAdapter {
    private List<UserBean> mUserList;
    private Context mContext;

    public UserAdapter(Context mContext, List<UserBean> mUserList) {
        this.mUserList = mUserList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mUserList == null ? 0 : mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_user, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_id = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        UserBean user = mUserList.get(position);
        viewHolder.tv_id.setText(String.valueOf(user.getId()));
        viewHolder.tv_name.setText(user.getName());

        return convertView;
    }

    class ViewHolder {
        TextView tv_id;
        TextView tv_name;
    }
}
