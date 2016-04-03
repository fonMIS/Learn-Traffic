package misschool.worathida.lerntraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    //การประกาศตัวแปร
    // การประกาศ แบบ public คลาสอื่น สามารถนำไปใช้งานได้   Privat ใช้เฉพาะคลาสนั้นๆ

    private ListView trafficListView;
    private Button aboutmeButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // การผูกความสัมพันธ์ขอตัวแปร  กับ widget
        //trafficListView = (ListView) findViewById(R.id.listView);
        //1. tra +enter   =  2.  findv + enter  3.  R+ enter  4. id+enter  5.l+enter  6. alt+enter   7. shift+ctrl+entet


        trafficListView = (ListView) findViewById(R.id.listView);
        aboutmeButton = (Button) findViewById(R.id.button);

        //การเก็บเหตุการณ์ จากการคลิกปุ่ม
        aboutmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //การใส่เสียง ลงปุ่ม
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                // medip+enter ,space, ctrl+space =,medip.crec ,ใส่ getbase ในcreatet  เลือกที่อยู่ ของเสียง R คือทั้งหมด ตามด้วยโฟลเดอร์ และชื่อของเสียง
                mediaPlayer.start();

                //ต้องการเปิดหน้าเว็บ https://youtu.be/PGfPNuFMNfg (web view)
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/sodafon")); //ให้ทำการเปิด เบราเซอร์
                startActivity(intent);


            }  // ทำงานเมื่อคลิกที่ปุ่ม
        });



        //การกำหนดค่า ให้ ตัวแปร อาร์เรย์
        // type1
        final int[] iconInts = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
                R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08,
                R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
                R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
                R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17,
                R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};
        //type 2
        final String[] titleStr = new String[20];
        titleStr[0] = "ป้ายที่ 1";
        titleStr[1] = "ป้ายที่ 2";
        titleStr[2] = "ป้ายที่ 3";
        titleStr[3] = "ป้ายที่ 4";
        titleStr[4] = "ป้ายที่ 5";
        titleStr[5] = "ป้ายที่ 6";
        titleStr[6] = "ป้ายที่ 7";
        titleStr[7] = "ป้ายที่ 8";
        titleStr[8] = "ป้ายที่ 9";
        titleStr[9] = "ป้ายที่ 10";
        titleStr[10] = "ป้ายที่ 11";
        titleStr[11] = "ป้ายที่ 12";
        titleStr[12] = "ป้ายที่ 13";
        titleStr[13] = "ป้ายที่ 14";
        titleStr[14] = "ป้ายที่ 15";
        titleStr[15] = "ป้ายที่ 16";
        titleStr[16] = "ป้ายที่ 17";
        titleStr[17] = "ป้ายที่ 18";
        titleStr[18] = "ป้ายที่ 19";
        titleStr[19] = "ป้ายที่ 20";

        //type3
        String[] detailstr = getResources().getStringArray(R.array.detail);


        //สร้าง list view
        MyAdapter myAdapter = new MyAdapter(this, titleStr, detailstr,iconInts);
        trafficListView.setAdapter((myAdapter));

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, ShowDetail.class);
                intent.putExtra("Title", titleStr[i]);
                intent.putExtra("Icon", iconInts[i]);
                intent.putExtra("Index", i);
                startActivity(intent);


            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }   //Main Method


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://misschool.worathida.lerntraffic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://misschool.worathida.lerntraffic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}   //Main Class
