package com.house.mebikeops.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.house.mebikeops.R;

/**
 * Created by house on 2017/7/27.
 */

public class SquareLinearLayout extends LinearLayout {

    private float widthPro = 0;
    private float heightPro = 0;

    public SquareLinearLayout(Context context) {
        this(context, null);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
        if (null != array) {
            widthPro = array.getFloat(R.styleable.SquareLayout_widthPro, 0);
            heightPro = array.getFloat(R.styleable.SquareLayout_heightPro, 0);
            array.recycle();
        }

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // For simple implementation, or internal size is always 0.
        // We depend on the container to specify the layout size of
        // our view. We can't really know what it is since we will be
        // adding and removing different arbitrary views and do not
        // want the layout to change as this happens.
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        // Children are just made to fill our space.
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();
        //高度和宽度一样


        if (widthPro > 0) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
            // 如果设置了此参数，按比例设置
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) ((float) childWidthSize / widthPro * heightPro), MeasureSpec.EXACTLY);
        } else {
            // 否则，设置宽高相等
            // 父容器传过来的宽度方向上的模式
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            // 父容器传过来的高度方向上的模式
            int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            if (widthMode == MeasureSpec.EXACTLY) {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
                heightMeasureSpec = widthMeasureSpec;
            } else {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);
                widthMeasureSpec = heightMeasureSpec;
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
