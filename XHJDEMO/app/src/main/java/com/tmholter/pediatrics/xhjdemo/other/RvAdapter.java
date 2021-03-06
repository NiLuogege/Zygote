package com.tmholter.pediatrics.xhjdemo.other;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tmholter.pediatrics.xhjdemo.R;
import com.tmholter.pediatrics.xhjdemo.common.view.view.banner.CarouselFigureView;
import com.tmholter.pediatrics.xhjdemo.common.view.view.banner.DepthPageTransformer;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${LuoChen} on 2017/9/1 13:13.
 * email:luochen0519@foxmail.com
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int Type_header = 0;
    private static final int Type_1 = 1;
    private static final int Type_2 = 2;
    private static final int Type_3 = 3;
    private static final int Type_4 = 4;
    private static final int Type_5 = 5;
    private static final int Type_6 = 6;
    private Activity context;
    private final LayoutInflater mInflater;

    public RvAdapter(Activity context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    private int count = 0;

    @Override
    public int getItemCount() {
        count = 4;
        return count;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == Type_header) {
            View headerView = mInflater.inflate(R.layout.headerview, parent, false);
            return new HeaderViewHolder(headerView);
        } else if (viewType == Type_1) {
            View headerView = mInflater.inflate(R.layout.item_type_1, parent, false);
            return new Type_1ViewHolder(headerView);
        } else if (viewType == Type_2) {
            View headerView = mInflater.inflate(R.layout.item_type_2, parent, false);
            return new Type_2ViewHolder(headerView);
        } else if (viewType == Type_3) {
            View headerView = View.inflate(context, R.layout.item_type_3, null);
            return new Type_3ViewHolder(headerView);
        }

//else if (viewType == Type_4) {
//            View headerView = View.inflate(context, R.layout.headerview, null);
//            return new HeaderViewHolder(headerView);
//        } else if (viewType == Type_5) {
//            View headerView = View.inflate(context, R.layout.headerview, null);
//            return new HeaderViewHolder(headerView);
//        } else if (viewType == Type_6) {
//            View headerView = View.inflate(context, R.layout.headerview, null);
//            return new HeaderViewHolder(headerView);
//        }
        View headerView = View.inflate(context, R.layout.headerview, null);
        return new HeaderViewHolder(headerView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof Type_1ViewHolder) {

        }


    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return Type_header;
        } else if (position == 1) {
            return Type_1;
        } else if (position == 2) {
            return Type_2;
        } else if (position == 3) {
            return Type_3;
        } else if (position == 4) {
            return Type_4;
        } else if (position == 5) {
            return Type_5;
        } else if (position == 6) {
            return Type_6;
        }

        return super.getItemViewType(position);
    }


    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.btn)
        Button btn;

        @Bind(R.id.vp)
        ViewPager vp;

        @Bind(R.id.rl)
        RelativeLayout rl;

        @Bind(R.id.cfv)
        CarouselFigureView cfv;

        @Bind(R.id.tv_animation)
        ImageView iv;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(context);
            vp.setAdapter(myPagerAdapter);
            vp.setCurrentItem(2);
            vp.setPageMargin(100);
            vp.setClipChildren(false);
            rl.setClipChildren(false);
            vp.setOffscreenPageLimit(3);
            vp.setScaleX(0.8f);
            vp.setScaleY(0.8f);

            ArrayList<String> imagesRes = new ArrayList();
            imagesRes.add("http://pic.sc.chinaz.com/files/pic/pic9/201604/apic20400.jpg");
            imagesRes.add("http://pics.sc.chinaz.com/files/pic/pic9/201602/apic19022.jpg");
            imagesRes.add("http://pics.sc.chinaz.com/files/pic/pic9/201603/fpic430.jpg");
            imagesRes.add("http://pics.sc.chinaz.com/files/pic/pic9/201605/apic20631.jpg");

            cfv.setURL(imagesRes);
            cfv.setViewPagerSwitchStyle(new DepthPageTransformer());//这是切换模式
            cfv.setViewPagerSwitchSpeed(200);//设置切换速率


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createAnimation(iv).start();
                }
            });
        }
    }

    public class Type_1ViewHolder extends RecyclerView.ViewHolder {

        public Type_1ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class Type_2ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.rv_1)
        RecyclerView rv_1;

        public Type_2ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_1.setLayoutManager(linearLayoutManager);
            rv_1.addItemDecoration(new SpacesItemDecoration(30));
            Rv_1Adapter rv_1Adapter = new Rv_1Adapter(context);
            rv_1.setAdapter(rv_1Adapter);
        }
    }

    public class Type_3ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id_stickynavlayout_indicator)
        SimpleViewPagerIndicator mIndicator;
        @Bind(R.id.id_stickynavlayout_viewpager)
        NoScrollViewPager mNoScrollViewPager;

        private String[] mTitles = new String[]{"简介", "评价", "相关"};

        public Type_3ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mIndicator.setTitles(mTitles);
            mNoScrollViewPager.setOnPageChangeListener(mOnPageChangeListener);

            mNoScrollViewPager.setAdapter(new Vp_3Adaper(context));

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mNoScrollViewPager.getLayoutParams();
            layoutParams.height = 3000;
            mNoScrollViewPager.setLayoutParams(layoutParams);
        }


        private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private double radio;
    private boolean isOn = true;//记录view的状态,第一次进去是可见的,记为true,不可见记为false

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Animator createAnimation(final View v) {

        Animator animator;
        if (radio == 0L) {
            radio = Math.sqrt(Math.pow(v.getWidth(), 2) + Math.pow(v.getHeight(), 2));
        }
        if (isOn) {
            animator = ViewAnimationUtils.createCircularReveal(
                    v,// 操作的视图
                    0,// 动画开始的中心点X
                    0,// 动画开始的中心点Y
                    (float) radio,// 动画开始半径
                    0);// 动画结束半径
        } else {
            animator = ViewAnimationUtils.createCircularReveal(
                    v,// 操作的视图
                    0,// 动画开始的中心点X
                    0,// 动画开始的中心点Y
                    0,// 动画开始半径
                    (float) radio);// 动画结束半径
        }
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!isOn) {
                    v.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isOn) {
                    v.setVisibility(View.INVISIBLE);
                }
                isOn = !isOn;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(500);
        return animator;
    }
}
