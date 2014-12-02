package com.example.planapp;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
import com.example.planapp.ImageLoader;
 
public class LazyAdapter extends BaseAdapter {
     
    private Activity activity;
    private String[] lugar1;
    private String[] lugar2;
    private String[] lugar3;
    private String[] data;//IMAGEN
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
     
    public LazyAdapter(Activity a, String[] lugar_1,String[] lugar_2, String[] lugar_3, String[] img) {
        activity = a;
        lugar1=lugar_1;
        lugar2=lugar_2;
        lugar3=lugar_3;
        data=img;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }
 
    public int getCount() {
        return data.length;
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
     
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.row_listview_item, null);
 
        TextView titulo=(TextView)vi.findViewById(R.id.TextTitle);
        TextView sub_titulo=(TextView)vi.findViewById(R.id.TextSubTitle);
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        titulo.setText(position+" - Panorama          ");
        sub_titulo.setText("Actividades :"+lugar1[position]+", "+lugar2[position]+", "+lugar3[position]);
        imageLoader.DisplayImage(data[position], image);
        return vi;
    }
}