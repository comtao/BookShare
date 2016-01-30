package com.lt.book.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lt.book.R;

/**
 * 页面头部
 * Created by tao.lai on 2016/1/30 0030.
 */
public class ViewHead  extends RelativeLayout implements View.OnClickListener{

    private static final String TAG = "ViewHead";

    private View view;
    private RelativeLayout rlHead;
    private ImageButton ibtnLeft, ibtnRight;
    private Button btnLeft, btnRight;
    private TextView tvTitle;
    private Context ctx;

    public ViewHead(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ctx = context;
        view = mInflater.inflate(R.layout.view_head, null);
        addView(view);
        initUI();
        init(attrs);
    }

    public ViewHead(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ViewHead(Context context) {
        this(context,null);
    }

    private void initUI() {
        rlHead = (RelativeLayout) findViewById(R.id.rl_head);
        ibtnLeft = (ImageButton) findViewById(R.id.ibtn_left);
        ibtnRight = (ImageButton) findViewById(R.id.ibtn_right);
        btnLeft = (Button) view.findViewById(R.id.btn_left);
        btnRight = (Button) view.findViewById(R.id.btn_right);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        tvTitle.setMaxEms(15);
        tvTitle.setSingleLine(true);
        ibtnLeft.setOnClickListener(this);
        ibtnRight.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    private void init(AttributeSet attrs) {
        TypedArray t = getContext().obtainStyledAttributes(attrs,
                R.styleable.ViewHead);
        int bgColor = t.getColor(R.styleable.ViewHead_head_color, 0X4DFFFFFF);
        String title = t.getString(R.styleable.ViewHead_title_value);
        boolean leftShow = t.getBoolean(R.styleable.ViewHead_left_show_icon,
                true);
        boolean rightShow = t.getBoolean(R.styleable.ViewHead_right_show_icon,
                true);
        Drawable leftRes = t.getDrawable(R.styleable.ViewHead_left_icon);
        Drawable rightRes = t.getDrawable(R.styleable.ViewHead_right_icon);
        String leftTitle = t.getString(R.styleable.ViewHead_left_name);
        String rightTitle = t.getString(R.styleable.ViewHead_right_name);
        rlHead.setBackgroundColor(bgColor);

        tvTitle.setText(title);
        //tvTitle.setTextColor(Color.parseColor("#ff7f7e"));
        if (!leftShow) {
            ibtnLeft.setVisibility(View.GONE);
            btnLeft.setText(leftTitle);
            btnLeft.setVisibility(View.VISIBLE);
        } else {
            ibtnLeft.setImageDrawable(leftRes);
        }
        if (!rightShow) {
            ibtnRight.setVisibility(View.GONE);
            btnRight.setText(rightTitle);
            btnRight.setVisibility(View.VISIBLE);
        } else {
            ibtnRight.setImageDrawable(rightRes);
        }
    }

    public void setRightText(String rightText) {
        btnRight.setText(rightText);
    }

    public void setHeadTitle(String headTitle) {
        tvTitle.setText(headTitle);
    }

    public void setRightIcon(int iconRes) {
        ibtnRight.setImageResource(iconRes);
    }

    public View getRightView() {
        return ibtnRight;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
            case R.id.ibtn_left:
                headViewListener.leftListener();
                break;
            case R.id.btn_right:
            case R.id.ibtn_right:
                headViewListener.rightListener();
                break;
            default:
                break;
        }
    }

    private ViewHeadListener headViewListener;

    public void setViewHeadListener(ViewHeadListener headViewListener) {
        this.headViewListener = headViewListener;
    }

    public interface ViewHeadListener {
        public void leftListener();
        public void rightListener();
    }
}
