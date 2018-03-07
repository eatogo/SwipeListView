package com.yuqirong.swipelistview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqirong.swipelistview.R;
import com.yuqirong.swipelistview.view.SwipeListLayout;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends Activity {

    private List<Foodlist> foodlist;
    private Set<SwipeListLayout> sets = new HashSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Foodlist> foodlist = getFoodList();
        ListView lv_main = (ListView) findViewById(R.id.lv_main);
        lv_main.setAdapter(new ListAdapter(this,foodlist));
        lv_main.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    //当listview开始滑动时，若有item的状态为Open，则Close，然后移除
                    case SCROLL_STATE_TOUCH_SCROLL:
                        if (sets.size() > 0) {
                            for (SwipeListLayout s : sets) {
                                s.setStatus(SwipeListLayout.Status.Close, true);
                                sets.remove(s);
                            }
                        }
                        break;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private  List<Foodlist> getFoodList() {
        List<Foodlist> foodlist = new ArrayList<>();
        foodlist.add(new Foodlist(1, R.drawable.a1_1, "旺角迷你石頭火鍋","霜降牛肉",200));
        foodlist.add(new Foodlist(2, R.drawable.a1_2, "旺角迷你石頭火鍋","美國牛小排",300));
        foodlist.add(new Foodlist(3, R.drawable.a1_3, "旺角迷你石頭火鍋","沙文牛肉",260));
        return foodlist;
    }





    class MyOnSlipStatusListener implements SwipeListLayout.OnSwipeStatusListener {

        private SwipeListLayout slipListLayout;

        public MyOnSlipStatusListener(SwipeListLayout slipListLayout) {
            this.slipListLayout = slipListLayout;
        }

        @Override
        public void onStatusChanged(SwipeListLayout.Status status) {
            if (status == SwipeListLayout.Status.Open) {
                //若有其他的item的状态为Open，则Close，然后移除
                if (sets.size() > 0) {
                    for (SwipeListLayout s : sets) {
                        s.setStatus(SwipeListLayout.Status.Close, true);
                        sets.remove(s);
                    }
                }
                sets.add(slipListLayout);
            } else {
                if (sets.contains(slipListLayout))
                    sets.remove(slipListLayout);
            }
        }

        @Override
        public void onStartCloseAnimation() {

        }

        @Override
        public void onStartOpenAnimation() {

        }

    }

    class ListAdapter extends BaseAdapter {
        Context context;
        List<Foodlist> foodlist;

        ListAdapter(Context context, List<Foodlist> foodlist) {
            this.context = context;
            this.foodlist = foodlist;
        }

        @Override
        public int getCount() {
            return foodlist.size();
        }

        @Override
        public Object getItem(int arg0) {
            return foodlist.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(final int arg0, View view, ViewGroup arg2) {
            if (view == null) {
                view = LayoutInflater.from(MainActivity.this).inflate(
                        R.layout.slip_list_item, null);
            }
            final Foodlist food = foodlist.get(arg0);
            final ImageView ivImage = (ImageView) view
                    .findViewById(R.id.ivFood);
            ivImage.setImageResource(food.getImage());

            final TextView tvId = (TextView) view
                    .findViewById(R.id.tvId);
            tvId.setText(String.valueOf(food.getName()));

            final TextView tvName = (TextView) view
                    .findViewById(R.id.tvName);
            tvName.setText(food.getName2());

            final TextView tvPrice = (TextView) view
                    .findViewById(R.id.tvPrice);
            tvPrice.setText(Integer.toString(food.getPrice()));

//            return view;

//            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
//            tv_name.setText(Foodlist.get(arg0));

            final SwipeListLayout sll_main = (SwipeListLayout) view
                    .findViewById(R.id.sll_main);
            TextView tv_delete = (TextView) view.findViewById(R.id.tv_delete);
            sll_main.setOnSwipeStatusListener(new MyOnSlipStatusListener(
                    sll_main));
            tv_delete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
//                    sll_main.setStatus(SwipeListLayout.Status.Close, true);
//                    Foodlist.remove(arg0);
//                    notifyDataSetChanged();
//                    Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent();;
//                    Bundle bundle = new Bundle();
//                    bundle.putString("name",tvId.getText().toString());
//                    bundle.putString("name2",tvName.getText().toString());
//                    bundle.putString("price",tvPrice.getText().toString());
//                    intent.putExtras(bundle);
//                    intent.setClass(MainActivity.this, Like2.class);
//                    startActivity(intent);
//
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("foodlist", (Serializable) foodlist);
//                    Intent intent = new Intent(MainActivity.this,Like2.class);
//                    intent.putExtras(bundle);
//                    startActivity(intent);

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    ArrayList list = new ArrayList();//这个arraylist是可以直接在bundle里传的，所以我们可以借用一下它的功能
                    list.add(foodlist);//这个list2才是你真正想要传过去的list。我们把它放在arraylis中，借助它传过去
                    bundle.putParcelableArrayList("foodlist", foodlist);
                    intent.putExtras(bundle);
                    intent.setClass(MainActivity.this,Like2.class);
                    startActivity(intent);


                }
            });
            return view;
        }

    }

}