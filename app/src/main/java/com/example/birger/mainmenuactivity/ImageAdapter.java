package com.example.birger.mainmenuactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//Class to show gallery in Grid View layout.
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<String> personList;
    private static final String TAG = "LOGG: ";

    public ImageAdapter() {
    }

    public ImageAdapter (Context c, ArrayList<String> personList) {
        mContext = c;
        this.personList = personList;
    }

    public int getCount() {
        return personList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    //Create new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        Bitmap bmp;

        //If not recycled...
        if (convertView == null) {
            
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        String navn = personList.get(position);

        //Get data from file/internally
        try {
            FileInputStream is = mContext.openFileInput(navn);
            bmp = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bmp);
            is.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Finner ikke filen");
        } catch (IOException e) {
            Log.e(TAG, "IO Feil");
        }
        return imageView;
    }
}