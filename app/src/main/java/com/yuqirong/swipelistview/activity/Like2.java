package com.yuqirong.swipelistview.activity;


import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuqirong.swipelistview.R;

import java.util.ArrayList;
import java.util.List;

public class Like2 extends Activity {
    private EditText inputText;
    private TextView tvId,tvName,tvPrice;
    private ImageView ivFood;
    private List<Foodlist> foodlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.like2);
        inputText = (EditText)findViewById(R.id.inputText);
        ivFood= findViewById(R.id.ivFood);
        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);

//        Bundle bundle =getIntent().getExtras();
//        String id = bundle.getString("name");
//        tvId.setText(id);
//        String name = bundle.getString("name2");
//        tvName.setText(name);
//        String price = bundle.getString("price");
//        tvPrice.setText(price);

//        foodlist =  (List<Foodlist>) getIntent().getSerializableExtra("person");
//        String id= foodlist.get(0).getId()+"";
//        String name= foodlist.get(1).getName()+"" ;
//        String price= foodlist.get(2).getPrice()+"" ;
//        Uri uri = getIntent().getParcelableExtra("MyImage");
//        ivFood.setImageURI(uri);
//        tvId.setText(id);
//        tvName.setText(name);
//        tvPrice.setText(price);

        Bundle bundle =getIntent().getExtras();
        ArrayList list = bundle.getParcelableArrayList("foodlist");
        foodlist= (List<foodlist>) foodlist.get(0);




}


}

