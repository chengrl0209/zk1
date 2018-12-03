package com.example.zhokao1.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhokao1.R;

public class HeaterView extends LinearLayout {
    private EditText mEditText;
    private TextView mCancel;
    public HeaterView(Context context,AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.heard_view, this);
        mEditText = findViewById(R.id.Search_Edit);
        mCancel = findViewById(R.id.Cancel_Text);
    }
    public String getEditStr() {
        return mEditText.getText().toString();
    }

    public TextView getmCancel() {
        return mCancel;
    }
}
