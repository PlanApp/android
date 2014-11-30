package com.example.planapp.app.adater;
 
import com.example.planapp.R;
import com.example.planapp.app.AppController;
import com.example.planapp.Lugar;

 
import java.util.List;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
 
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Lugar> movieItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
    public CustomListAdapter(Activity activity, List<Lugar> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
 
    @Override
    public int getCount() {
        return movieItems.size();
    }
 
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
 
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);
 
        // getting movie data for the row
        Lugar m = movieItems.get(position);
 
        // thumbnail image
        thumbNail.setImageUrl(m.getImagen(), imageLoader);
         
        // title
        title.setText(m.getNombre());
         
        // rating
        rating.setText("Rating: " + String.valueOf(m.getNombre()));
         
        // genre
        genre.setText("Descrip: " + String.valueOf(m.getNombre()));
        /*
        String genreStr = "";
        for (String str : m.getGen) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);
        */ 
        
        // release year
        year.setText(String.valueOf(m.getID()));
 
        return convertView;
    }
 
}