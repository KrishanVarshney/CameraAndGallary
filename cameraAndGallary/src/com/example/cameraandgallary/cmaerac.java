package com.example.cameraandgallary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class cmaerac extends Activity 
{
	Button b1;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		iv=(ImageView)findViewById(R.id.imageView10);
		
		b1=(Button) findViewById(R.id.button1);
		b1.setOnClickListener(new A());
	}
	class A implements OnClickListener
	{
		public void onClick(View arg0) 
		{
			Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

			startActivityForResult(intent, 0);
		}
		
	}
	@Override
protected void onActivityResult(int requestCode, int resultCode, Intent vgt) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, vgt);
		Bitmap bm=(Bitmap) vgt.getExtras().get("data"); //Use only data
		iv.setImageBitmap(bm); 
	}
}
