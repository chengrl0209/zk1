package com.example.zhokao1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zhokao1.sqlite.MyDao;
import com.example.zhokao1.weight.FootView;
import com.example.zhokao1.weight.HeaterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = {"考拉三周年人气热榜","电动牙刷","尤佳妮","豆豆鞋","沐浴露","日东红茶","榴莲","电动牙刷","尤佳妮","雅诗兰黛","豆豆鞋"};
    private String[] date = {"基础护肤","面部清洁","面膜","兰蔻","雅诗兰黛","资生堂","眼部护理","悦诗风吟","美容护肤"};
    private FootView MyFloat_Layout;
    private FootView mHistoryLayout;
    private FootView aa;
    private HeaterView mHeadView;
    private MyDao mDao;
    private ArrayList<String> mList = new ArrayList<>();
    private ArrayList<String> mLista = new ArrayList<>();
    private ArrayList<String> mHistory = new ArrayList<>();
    private TextView mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDao = new MyDao(this);
        mHistory = mDao.selectName();
        initData();
        initDate();
        initViews();
        if (!mHistory.isEmpty()) {
            mHistoryLayout.setData(mHistory);
        }
    }

    private void initDate() {
        for (int i = 0; i < date.length; i++) {
            mLista.add(date[i]);
        }
    }


    private void initData() {
        for (int i = 0; i < data.length; i++) {
            mList.add(data[i]);
        }
    }

    private void initViews() {
        mDelete = findViewById(R.id.Delete_Text);
        mDelete.setOnClickListener(this);

        MyFloat_Layout = findViewById(R.id.MyFloat_Layout);
        MyFloat_Layout.setData(mList);

        MyFloat_Layout = findViewById(R.id.MyFloat_Layouta);
        MyFloat_Layout.setData(mLista);


        mHistoryLayout = findViewById(R.id.MyFloat_Layout_History);
        mHeadView = findViewById(R.id.header_View);
        mHeadView.getmCancel().setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Cancel_Text:
                String name = mHeadView.getEditStr().trim();
                mDao.insertSqlite(mHeadView.getEditStr().trim());
                //自己封装了一个方法删除子控件
                mHistoryLayout.removeChildView();
                mHistory.add(name);
                mHistoryLayout.setData(mHistory);
                break;
            case R.id.Delete_Text:
                mDao.delete();
                mHistory.clear();
                mHistoryLayout.removeChildView();
                break;
        }
    }
}
