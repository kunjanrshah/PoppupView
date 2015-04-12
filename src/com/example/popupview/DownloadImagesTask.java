package com.example.popupview;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

public class DownloadImagesTask extends AsyncTask<String, Void, Bitmap> {
	private View dialogView;
	
	public DownloadImagesTask(View dialogView) {
        this.dialogView = dialogView;
    }

	@Override
	protected Bitmap doInBackground(String... urls) {
		// TODO Auto-generated method stub
		String url = urls[0];
		Bitmap bitmap = null;
    	try {	 
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
		} catch (MalformedURLException e) {
		  e.printStackTrace();
		} catch (IOException e) {
		  e.printStackTrace();
		}
    	return bitmap;
	}
	
    protected void onPostExecute(Bitmap bitmap) {
    	ImageView image = (ImageView)dialogView.findViewById(R.id.happy_card_image);
    	image.setImageBitmap(bitmap);
    	dialogView.findViewById(R.id.loadingPanel).setVisibility(View.GONE);;
    }
}
