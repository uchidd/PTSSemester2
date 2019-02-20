package id.uchidd.ptssemester2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //UPDATE TERBARU

    @BindView(R.id.btnToast)
    Button btnToast;
    @BindView(R.id.btnSnackbar)
    Button btnSnackbar;
    @BindView(R.id.btnAlertDialog)
    Button btnAlertDialog;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.etInput1)
    EditText etInput1;
    @BindView(R.id.etInput2)
    EditText etInput2;
    @BindView(R.id.btnPutExtra)
    Button btnPutExtra;
    @BindView(R.id.btnPutExtras)
    Button btnPutExtras;
    @BindView(R.id.etInputLink)
    EditText etInputLink;
    @BindView(R.id.btnWebView)
    Button btnWebView;
    @BindView(R.id.btnRecyclerView)
    Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, etInput1.getText().toString() + "\n" + etInput2.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        btnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, etInput1.getText().toString() + "\n" + etInput2.getText().toString(), Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Snackbar")
                        .setMessage(etInput1.getText().toString() + "\n" + etInput2.getText().toString())
                        .setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });

        btnPutExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentPutExtra(etInput1.getText().toString());
            }
        });

        btnPutExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentPutExtras(etInput1.getText().toString(), etInput2.getText().toString());
            }
        });

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView(etInputLink.getText().toString());
            }
        });

        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

    }

    public void goToSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    public void IntentPutExtra(String data1PutExtra) {

        Intent putExtra = new Intent(MainActivity.this, SecondActivity.class);
        putExtra.putExtra("INPUT PERTAMA", data1PutExtra);
        startActivity(putExtra);
        return;

    }

    public void IntentPutExtras(String data1PutExtras, String data2PutExtras) {

        Bundle data = new Bundle();
        data.putString("INPUT PERTAMA", data1PutExtras);
        data.putString("INPUT KEDUA", data2PutExtras);

        Intent putExtras = new Intent(MainActivity.this, SecondActivity.class);
        putExtras.putExtras(data);
        startActivity(putExtras);
        return;

    }

    public void webView(String dataLink) {

        Intent putExtraWebView = new Intent(MainActivity.this, WebViewActivity.class);
        putExtraWebView.putExtra("LINK WEB", dataLink);
        startActivity(putExtraWebView);
        return;

    }

}
