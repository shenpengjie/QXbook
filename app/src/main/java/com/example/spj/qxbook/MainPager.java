package com.example.spj.qxbook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018/5/6.
 */

public class MainPager extends Activity  implements ViewPager.OnPageChangeListener {
    private  ViewPager vp;
    private LinearLayout ll_point;
    private TextView tv_desc;
    private int[] imgresId;
    private ArrayList<ImageView> imgs;
    private String[] contentDescs;
    private int lastPosition;
    private boolean isRunning = false;
    private List<Book> bookList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);
        initViews();
        initData();
        initAdapter();
        new Thread(){
        public void run() {
            isRunning=true;
            while (isRunning){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        vp.setCurrentItem(vp.getCurrentItem()+1);
                    }
                });
            }
        }
        }.start();

        initFruits();
        BookAdapter adapter=new BookAdapter(MainPager.this,R.layout.book_item,bookList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits(){
        Book Chinese=new Book("Book",R.mipmap.ic_launcher);
        bookList.add(Chinese);
        Book Math=new Book("Math",R.mipmap.ic_launcher);
        bookList.add(Math);
        Book History=new Book("History",R.mipmap.ic_launcher);
        bookList.add(History);
        Book English=new Book("English",R.mipmap.ic_launcher);
        bookList.add(English);
        Book Mayuan=new Book("Mayuan",R.mipmap.ic_launcher);
        bookList.add(Mayuan);

    }
    public void initViews(){
        ll_point = (LinearLayout) findViewById(R.id.ll_point);
        vp = (ViewPager) findViewById(R.id.vp);
        System.out.println(vp);
        vp.addOnPageChangeListener(this);
        //显示图片描述信息的控件
        tv_desc = (TextView) findViewById(R.id.tv_desc);
    }
    public void initData(){
        imgresId=new int[]{R.mipmap.id1,R.mipmap.id2,R.mipmap.id3};
        contentDescs=new String[]{
                "少儿不宜1",
                "少儿不宜2",
                "少儿不宜3"
        };
        imgs=new ArrayList<>();
        ImageView img;
        View pointView;
        for (int i=0;i<imgresId.length;i++){
            img=new ImageView(this);
            img.setBackgroundResource(imgresId[i]);
            imgs.add(img);
            pointView = new View(this);
            pointView.setBackgroundResource(R.drawable.point_selector);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
            if (i != 0){

                layoutParams.leftMargin = 10;
            }
            pointView.setEnabled(false);
            ll_point.addView(pointView, layoutParams);
        }
    }
    private void initAdapter() {
        ll_point.getChildAt(0).setEnabled(true);
        tv_desc.setText(contentDescs[0]);
        lastPosition = 0;
        vp.setAdapter(new MyPagerAdapter());
        vp.setCurrentItem(5000000);
    }
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }
        public Object instantiateItem(ViewGroup container, int position) {

            int newPosition = position % 3;
            ImageView imageView = imgs.get(newPosition);
            //把图片添加到container中
            container.addView(imageView);
            //把图片返回给框架，用来缓存
            return imageView;
        }
        public void destroyItem(ViewGroup container, int position, Object object) {
            //object:刚才创建的对象，即要销毁的对象
            container.removeView((View) object);
        }
    }
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //新的页面被选中
    @Override
    public void onPageSelected(int position) {
        //当前的位置可能很大，为了防止下标越界，对要显示的图片的总数进行取余
        int newPosition = position % 3;
        //设置描述信息
        tv_desc.setText(contentDescs[newPosition]);
        ll_point.getChildAt(lastPosition).setEnabled(false);
        ll_point.getChildAt(newPosition).setEnabled(true);
        lastPosition = newPosition;
    }

    //页面滑动状态发生改变
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
