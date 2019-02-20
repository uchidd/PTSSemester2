package id.uchidd.ptssemester2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tvOutput1)
    TextView tvOutput1;
    @BindView(R.id.tvOutput2)
    TextView tvOutput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();

        String getData1 = getData.getString("INPUT PERTAMA");
        String getData2 = getData.getString("INPUT KEDUA");

        tvOutput1.setText(getData1);
        tvOutput2.setText(getData2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
        finish();
    }
}
