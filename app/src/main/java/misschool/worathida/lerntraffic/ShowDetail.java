package misschool.worathida.lerntraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetail extends AppCompatActivity {

    //ประกาศตัวแปร
    private TextView titleTextView, detailTextView;
    // ImageView trafficImageView; เหมือนกับ
    private ImageView trafficImageView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        titleTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView2);



        //รับค่า มาแสดง
        String strTitle=getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        int imgInt = getIntent().getIntExtra("Icon", R.drawable.traffic_01);
        trafficImageView.setImageResource(imgInt);

        int intIndex = getIntent().getIntExtra("Index", 0);

       String[] strdetail = getResources().getStringArray(R.array.detail22);
        detailTextView.setText(strdetail[intIndex]);





    }//main method
}// main class
