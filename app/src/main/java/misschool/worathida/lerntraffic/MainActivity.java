package misschool.worathida.lerntraffic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //การประกาศตัวแปร
    // การประกาศ แบบ public คลาสอื่น สามารถนำไปใช้งานได้   Privat ใช้เฉพาะคลาสนั้นๆ

    private ListView trafficListView;
    private Button aboutmeButton;


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

            } // ทำงานเมื่อคลิกที่ปุ่ม
        });

    }   //Main Method

}   //Main Class
