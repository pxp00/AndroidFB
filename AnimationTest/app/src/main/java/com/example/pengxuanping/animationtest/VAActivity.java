package com.example.pengxuanping.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


/*1.code: a.new & set obj；b.view.start(obj);
 *1.xml: a.load & set obj; b.view.start(obj);*/
/*
 * 编码实现View Animation
 * 	1. Code方式
 *  2. Xml方式
 */
public class VAActivity extends Activity {

    private ImageView iv_animation;
    private TextView tv_animation_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_va);

        iv_animation = findViewById(R.id.iv_animation);
        tv_animation_msg = findViewById(R.id.tv_animation_msg);
    }

    /*1.1 code: scale*/
    public void startCodeScale(View v) {
        tv_animation_msg.setText("Code缩放动画: 宽度从0.5到1.5, 高度从0.0到1.0, 缩放的圆心为顶部中心点,延迟1s开始,持续2s,最终还原");

        //1. new scale  & set
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1.5f, 0, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setStartOffset(1000);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillBefore(true);

        //2. view.startAnima
        iv_animation.startAnimation(scaleAnimation);
    }

    /*1.2 xml: scale*/
    public void startXmlScale(View v) {
        //1. anim load xml & set
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale_test);
        anim.setStartOffset(3000);
        anim.setDuration(2000);
        anim.setFillAfter(true);

        //2. View.startAnimation
        iv_animation.startAnimation(anim);
    }

    /*2.1 code rotate*/
    public void startCodeRotate(View v) {
        tv_animation_msg.setText("Code旋转动画: 以图片中心点为中心, 从负90度到正90度, 持续5s");

        //new & set RotateAnimation
        RotateAnimation rotateAnimation = new RotateAnimation(-90, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setFillAfter(true);

        //start
        iv_animation.startAnimation(rotateAnimation);
    }

    /*2.2 xml rotate */
    public void startXmlRotate(View v) {
        tv_animation_msg.setText("Xml旋转动画: 以左顶点为坐标, 从正90度到负90度, 持续5s");

        //1. load & set anim
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_test);
        anim.setDuration(5000);
        anim.setFillAfter(true);

        //2. start
        iv_animation.startAnimation(anim);


    }

    /* 3.1 code alpha */
    public void startCodeAlpha(View v) {
        tv_animation_msg.setText("Code透明度动画: 从完全透明到完全不透明, 持续2s");

        //1. new & set alphaAnimation (0 to 1.0f)
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1.0f);
        alphaAnimation.setDuration(5000);

        //2. start
        iv_animation.startAnimation(alphaAnimation);

    }

    /* 3.1 xml: alpha  */
    public void startXmlAlpha(View v) {
        tv_animation_msg.setText("Xml透明度动画: 从完全不透明到完全透明, 持续10s");

        //1. load & set animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha_test);
        anim.setDuration(10 * 1000);

        //2. start
        iv_animation.startAnimation(anim);


    }


    /* 4.1 code: translate */
    public void startCodeTranslate(View v) {
        tv_animation_msg.setText("Code移动动画: 向右移动一个自己的宽度, 向下移动一个自己的高度, 持续2s");

        //new & set
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.0f);
        translateAnimation.setDuration(5000);
        translateAnimation.setFillAfter(true);

        //start
        iv_animation.startAnimation(translateAnimation);
    }

    /* 4.2 xml: translate*/
    public void startXmlTranslate(View v) {
        tv_animation_msg.setText("xml移动动画: 从屏幕的右边逐渐回到原来的位置, 持续2s"); //***此效果用于界面切换的动画效果

        //laod xml & set
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_test);
        animation.setDuration(3 * 1000);

        //start
        iv_animation.startAnimation(animation);
    }

    /* 5.1 code: set */
    public void startCodeAnimationSet(View v) {
        tv_animation_msg.setText("Code复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续1s");

        //new & set
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);

        //new & set
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        rotateAnimation.setStartOffset(2000);
        rotateAnimation.setDuration(1000);

        //new
        AnimationSet animationSet = new AnimationSet(true);

        //add
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);

        //start
        iv_animation.startAnimation(animationSet);
    }

    /*5.2 xml: set*/
    public void startXmlAnimationSet(View v) {
        tv_animation_msg.setText("Xml复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续2s");

        // load
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_test);
        // start
        iv_animation.startAnimation(animation);
    }

    /* 6. listener */
    public void testAnimationListener(View v) {
        tv_animation_msg.setText("测试动画监听");
        //tv_animation_msg.setText("Xml旋转动画: 以左顶点为坐标, 从正90度到负90度, 持续5s");
        //1. 定义动画文件
        //2. 加载动画文件得到动画对象

        Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);

        //设置动画重复次数
        animation.setRepeatCount(3);//重复3次

        //设置线性变化 change smoothly
        animation.setInterpolator(new LinearInterpolator());

        //设置动画监听
        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("TAG", "动画开始");
            }


            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("TAG", "动画重复");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("TAG", "动画结束");
            }
        });

        //3. 启动动画
        iv_animation.startAnimation(animation);

    }
}