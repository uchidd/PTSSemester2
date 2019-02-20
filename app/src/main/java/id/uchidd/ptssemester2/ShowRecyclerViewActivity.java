package id.uchidd.ptssemester2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.ivShow)
    ImageView ivShow;
    @BindView(R.id.tvShow)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recycler_view);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        String getText = bundle.getString("TEXT RECYCLER VIEW");
        Integer getImage = bundle.getInt("IMAGE RECYCLER VIEW");

        Picasso.get().load(getImage).into(ivShow);
        tvShow.setText(getText);

    }
}
