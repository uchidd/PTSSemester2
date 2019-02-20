package id.uchidd.ptssemester2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import id.uchidd.ptssemester2.adapter.AdapterListRecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    private ArrayList<String> textRecyclerView;
    private ArrayList<Integer> imageRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
    }

    private void initItemView() {
        final RecyclerView rvListData = (RecyclerView) findViewById(R.id.listRecyclerView);
        rvListData.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvListData.setLayoutManager(layoutManager);

        textRecyclerView = new ArrayList<>();
        textRecyclerView.add("Text Pertama");
        textRecyclerView.add("Text Kedua");
        textRecyclerView.add("Text Ketiga");

        imageRecyclerView = new ArrayList<>();
        imageRecyclerView.add(R.mipmap.test);
        imageRecyclerView.add(R.mipmap.test1);
        imageRecyclerView.add(R.mipmap.test2);

        RecyclerView.Adapter adapter = new AdapterListRecyclerView(textRecyclerView, imageRecyclerView);
        rvListData.setAdapter(adapter);

        rvListData.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });


            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvListData.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvListData.getChildAdapterPosition(child);

                    String text;
                    Integer image;

                    text = textRecyclerView.get(position);
                    image = imageRecyclerView.get(position);

                    prosesPutExtras(text, image);

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    public void prosesPutExtras(String pushText, Integer pushImage) {

        Bundle bundle = new Bundle();
        bundle.putString("TEXT RECYCLER VIEW", pushText);
        bundle.putInt("IMAGE RECYCLER VIEW", pushImage);

        Intent sendPutExtras = new Intent(RecyclerViewActivity.this, ShowRecyclerViewActivity.class);
        sendPutExtras.putExtras(bundle);
        startActivity(sendPutExtras);
        return;
    }

}
