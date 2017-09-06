package com.tmholter.pediatrics.xhjdemo.common.view.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * 只能有两个自Viwe
 * 第一个为 下拉刷新的view
 * 第二个为 NestedScollView
 */
public class PullScrollView extends RelativeLayout {

	public PullScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}
	
	public PullScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	public PullScrollView(Context context) {
		super(context);
		init(context);
	}
	
	private Scroller mScroller ;
	private int mTouchSlop ;
	private void init(Context context){
		
		 ViewConfiguration configuration = ViewConfiguration.get(getContext());
	     mTouchSlop = configuration.getScaledTouchSlop();
	     
		mScroller = new Scroller(context, new DecelerateInterpolator());
	}

	
//	private ViewGroup bottomView ;
	private View bottomView ;
	private NestedScrollView contentView ;
	
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		getTopPosition();
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if (getChildCount() > 2) {
			throw new RuntimeException("can have only two child view");
		}
//		bottomView = (ViewGroup) getChildAt(0);
//		contentView = (ScrollView) getChildAt(1);
		bottomView = getChildAt(0);
		contentView = (NestedScrollView) getChildAt(1);
	}
	
	private int startY ; 
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		if (getScrollY() < 0 ) {
			return true ;
		}
		
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startY = (int) ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			int moveY = (int) ev.getY();
			int delayY = moveY - startY ;
//			Log.i("Test", delayY + " =  " + mTouchSlop) ;
			if (getTopPosition() && delayY > mTouchSlop) {
				ev.setAction(MotionEvent.ACTION_DOWN);
				return true ;
			}
			break ;
		case MotionEvent.ACTION_UP:
			
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startY = (int) event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			int delayY = (int) (event.getY() - startY) ;
			if (getTopPosition() && getScrollY() <= 0 ) {
				pullMove((int) (-delayY * 0.8));
			}
			startY = (int) event.getY();
			return true ;
		case MotionEvent.ACTION_UP:
			int scrollY = getScrollY();
			if (state == PullState.ON_REFRESH && scrollY < 0 && Math.abs(scrollY) > bottomHeight) {
				restView(-getScrollY() - bottomHeight);
				return true ;
			}else if (state == PullState.ON_REFRESH && scrollY < 0 && Math.abs(scrollY) < bottomHeight) {
				return true ;
			}
			if (scrollY < 0  &&  Math.abs(scrollY) < bottomHeight ) {
				returnView();
			}else if (scrollY < 0 && Math.abs(scrollY) > bottomHeight  && state != PullState.ON_REFRESH) {
				if (onreListener != null) {
					state = PullState.ON_REFRESH ;
					onreListener.refresh();
				}
				restView(-getScrollY() - bottomHeight);
			}
			break;
		}
		return true ;
	}
	
	
	private PullState state = PullState.REST ; 
	
	@Override
	public void computeScroll() {
		super.computeScroll();
		if (mScroller.computeScrollOffset()) {
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			postInvalidate();
		}
	}
	
	
	private void returnView(){
		restView(-getScrollY());
	}
	
	
	private void restView(int dy){
		mScroller.startScroll(0, getScrollY(), 0, dy , 340);
		postInvalidate();
	}
	
	
	
	private void pullMove(int delay){
		if (getScrollY() <= 0 && (getScrollY() + delay) <= 0 ) {
			scrollBy(0, delay);
		}else {
			scrollTo(0, 0);
		}
	}
	
	
	private boolean getTopPosition(){
		if (contentView.getScrollY() <= 0 ) {
			return true ;
		}
		return false ;
	}
	
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		bottomHeight = getBottomViewHeight() ; 
//		Log.i("Test", l + "ceshi" + " t="+t + " r"+r + " b=" + b + " height= "   + bottomHeight);
		bottomView.layout(l, - bottomHeight, r, t);
		contentView.layout(l, 0, r, b);
	}
	
	
	
	private int bottomHeight = 0 ;
	
	private int getBottomViewHeight(){
		return bottomView.getMeasuredHeight();
	}




    enum PullState{
		REST , ON_REFRESH 
	}
	
	
	public void stopRefresh(){
		state = PullState.REST; 
		returnView();
	}

	/**
	 * 刚进入 页面的时候 自动刷新
	 */
    public void autoRefresh() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mScroller.startScroll(0, 0, 0, -bottomHeight , 100);
                postInvalidate();
            }
        },100);

    }
	
	private onRefreshListener onreListener ; 
	
	public void setOnRefreshListener (onRefreshListener onreListener) {
		this.onreListener = onreListener ;
	}
	
	
	public interface onRefreshListener{
		 void refresh();
	}

}
