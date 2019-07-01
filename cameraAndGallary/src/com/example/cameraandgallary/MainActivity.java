package com.example.cameraandgallary;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity 
{
	Button b1,b2;
	ImageView iv1;
	private static int LOAD_IMAGE_RESULTS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        iv1=(ImageView)findViewById(R.id.imageView10);
        b1.setOnClickListener(new a());
        b2.setOnClickListener(new b());
       
     }
    class a implements android.view.View.OnClickListener
    {

		@Override
		public void onClick(View arg0)
		{
			Intent i=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i,LOAD_IMAGE_RESULTS);

		}
    	
    }
    class b implements android.view.View.OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			Intent i1=new Intent(MainActivity.this,cmaerac.class);
			startActivity(i1);
		}
    	
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent i1) 
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, i1);
		if(requestCode==LOAD_IMAGE_RESULTS && resultCode==RESULT_OK && i1!=null)
		{
			Uri pickedImage=i1.getData();
			String []filePath={MediaStore.Images.Media.DATA};
			
			Cursor cursor=getContentResolver().query(pickedImage, filePath, null, null, null);
			cursor.moveToFirst();
		
			String imagePath=cursor.getString(cursor.getColumnIndex(filePath[0]));
			iv1.setImageBitmap(BitmapFactory.decodeFile(imagePath));

			cursor.close();
	
		}
	}

    
    
    

}
