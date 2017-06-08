package marwor.ninja_book.Camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.qrcode.QRCodeReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import marwor.ninja_book.ShowQueue.LoadingActivity;
import marwor.ninja_book.R;

import static android.content.ContentValues.TAG;

public class CameraActivity extends Activity implements View.OnClickListener {
    private static final int MEDIA_TYPE_IMAGE = 1;
    private Camera mCamera;
    private CameraPreview mPreview;
    private Button takePicture;
    private Bitmap bitmap;
    private QRCodeReader qrCodeReader;
    private BinaryBitmap binaryBitmap;
    private Result result;
    private BinaryBitmapMaker binaryBitmapMaker;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        takePicture=(Button) findViewById(R.id.buttonTakePicture);
        takePicture.setOnClickListener(this);
        binaryBitmapMaker=new BinaryBitmapMaker();
        qrCodeReader=new QRCodeReader();
        // Create an instance of Camera
        mCamera = CameraOpen.getCameraInstance();
        mCamera.setDisplayOrientation(90);

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }
    @Override
    public void onClick(View v){
        String focusMode = mCamera.getParameters().getFocusMode();
        if(focusMode.equals(Camera.Parameters.FOCUS_MODE_AUTO) || focusMode.equals(Camera.Parameters.FOCUS_MODE_MACRO))
        {
            mCamera.autoFocus(new Camera.AutoFocusCallback()
            {
                @Override
                public void onAutoFocus(boolean success, Camera camera)
                {
                    mCamera.takePicture(null,null,null,mPicture);
                }
            });
        }
        else
            mCamera.takePicture(null,null,null,mPicture);
    }




        //mCamera.takePicture(null,null,null,mPicture);




    @Override
    public void onPause(){
        super.onPause();
        mCamera.release();

    }
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type){


        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }



    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null){
                Log.d(TAG, "Error creating media file, check storage permissions: ");
                return;
            }



            try(FileOutputStream fos=new FileOutputStream(pictureFile)) {
                fos.write(data);
                fos.close();

            } catch (FileNotFoundException e) {
                Log.d(TAG, "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d(TAG, "Error accessing file: " + e.getMessage());
            }


            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize=8;
            bitmap=BitmapFactory.decodeFile(pictureFile.getAbsolutePath(),options);

            binaryBitmap=binaryBitmapMaker.MakeBinaryBitmap(bitmap);

            try{
                result=qrCodeReader.decode(binaryBitmap);
                Log.d(TAG,"rezultat"+result.getText());
            }
            catch (NotFoundException|ChecksumException|FormatException e) { e.printStackTrace(); }

            Intent i = new Intent(CameraActivity.this, LoadingActivity.class);
            i.putExtra("qrResult",result.getText());
            startActivity(i);



        }


            };




}
