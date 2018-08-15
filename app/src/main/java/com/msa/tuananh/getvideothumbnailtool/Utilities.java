package com.msa.tuananh.getvideothumbnailtool;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

/*
    17:10 - 15/08/2018
    Tuan Anh dep trai
    hihi
 */

public class Utilities {

    //Get all files name in raw folder
    public static ArrayList<Video> listRaw() {
        ArrayList<Video> list = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for (int count = 0; count < fields.length; count++) {
            try {
                Log.d("rawsach", "listRaw: " + fields[count].getName());
                list.add(new Video(fields[count].getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //Save screenshot to sdcard
    public static void saveImage(String name, Activity activity, View view) {
        FileOutputStream outStream = null;
        Bitmap bitmap = screenShot(view);
        try {
            File f = new File("/sdcard/Pictures/SimpleVideoThumbnail/");
            f.mkdirs();

            String fileName = String.format("%s.PNG", name);
            File outFile = new File(f, fileName);

            outStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();

            Toast.makeText(activity, "File saved into: " + outFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, "Loi " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

}
