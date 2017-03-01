package com.hongmingwei.guide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hongmingwei.guide.ui.GuideView;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private GuideView guideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        initListener();
    }


    private void initListener(){
        View view = getLayoutInflater().inflate(R.layout.guide_final, null);
        ImageView open_image= (ImageView) view.findViewById(R.id.open_image);
        open_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        guideView = GuideView.Builder
                .newInstance(this)
                .setTargetView(button)//设置目标
                .setCustomGuideView(view)//设置蒙层上面使用的图片
                .setDirction(GuideView.Direction.TOP)
                .setShape(GuideView.MyShape.RECTANFLE)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        guideView.hide();
                        //显示首页弹窗
                    }
                })
                .build();
        guideView.show();
    }
}
