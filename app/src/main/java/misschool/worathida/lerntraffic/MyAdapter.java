package misschool.worathida.lerntraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WORATHIDA on 03/04/59.
 */

//หลังจากสร้าง คอนสตรัคเจอของตัวแปรให้มาทำการ  extends BaseAdapter  เพื่อ สร้าง เมธอด ของมัน  ใส่ BaseAdapter กด alt+enter
public class MyAdapter extends BaseAdapter {
    //ประกาศ ตัวแปร
    // การทำคอนเท็กคือการ ต่อท่อ ส่งไปยังอีกที่ ตรงนี้จะโยนข้อมูลและรูปภาพ ไปหา listview
    // สร้างตัวแปรเป็น ชนิด context


    private Context context;
    private String[] titleStrings, detailStrings;

    //กำหนด ตัวแปรแบบรูปภาพ
    private int[] iconInts;

    //เมื่อสร้างตัวแปรเสร็จ  กด alt+insert เพื่อสร้าง constuctor  แล้วเลือกตัวแปรทุกตัว

    public MyAdapter(Context context, String[] titleStrings, String[] detailStrings, int[] iconInts) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.iconInts = iconInts;
    }


    //หลังจากทำการ extend จะได้ เมธอด ข้างล่างนี้
    @Override
    public int getCount() {
        return iconInts.length;  //นับจำนวนของรูปภาพ
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //ตรงint เปลี่ยนจาก position  -> i
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // การเปิด service สร้าง layoutInflater
        //LayoutInflater layoutInflater = ]context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  กด alt + enter แลืก cast to
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //สำหรับ text view string 2  ตัว
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView2);
        titleTextView.setText(titleStrings[i]);

        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);
        detailTextView.setText(detailStrings[i]);

        //สำหรับ รูปภาพ
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        iconImageView.setBackgroundResource(iconInts[i]);

        return view1;

    }
} //Main Class
