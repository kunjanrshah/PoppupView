package com.example.popupview;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

	
	private AlertDialog.Builder builder;
	private DownloadImagesTask task;
	private Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    /** Called when the user clicks the Send button */
    public void callPopup(View view) {
        // Do something in response to button
    	showMessage(new String("hello world"));
    }
    
	// Show message dialog 
	private void showMessage(String msg) {
		builder = new AlertDialog.Builder(this);
		//builder.setTitle("Oops!");
		//builder.setMessage(msg);
		// set the confirm event
		LayoutInflater inflater = this.getLayoutInflater();
		
		View builderView = inflater.inflate(R.layout.dialog_signin, null);
		//ImageView image = (ImageView)builderView.findViewById(R.id.happy_card_image);
		
		
		builder.setView(builderView);
		
		builder.setPositiveButton("Oh yeah", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               // User clicked OK button
	           }
	       });
		// set cancel event
		builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               // User cancelled the dialog
	           }
	    });
		
		AlertDialog dialog = builder.create();
		
		dialog.show();
		
		new DownloadImagesTask(builderView).execute("http://profilethai.com/download/original/girls-generation-snsd-gee-other.jpg");
	}

}
