package com.cst2335.pan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageButton;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";      // should it be here?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mImageButton = findViewById(R.id.imgBtn);
        EditText emailBoxP = findViewById(R.id.emailBoxP);

        mImageButton.setOnClickListener(click -> dispatchTakePictureIntent());
        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra("EMAIL");
        emailBoxP.setText(email);

        Log.e(ACTIVITY_NAME, "In function: onCreate()");         // like this?
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ACTIVITY_NAME, "In function: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME, "In function: onResume()");
    }

    protected void onPause(String message) {
        super.onPause();
        Log.e(ACTIVITY_NAME, "In function: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function: onDestroy()");
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }
    }


    ActivityResultLauncher<Intent> myPictureTakerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
                    , new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent data = result.getData();
                                Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");
                                mImageButton.setImageBitmap(imgbitmap); // the imageButton
                            } else if (result.getResultCode() == Activity.RESULT_CANCELED) ;
                            // Log.i(TAG, "User refused to capture a picture.");
                        }
                    });
}


