package marwor.ninja_book;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;




public class BinaryBitmapMaker {
       public BinaryBitmap MakeBinaryBitmap(Bitmap bitmap){



        int[] intArray = new int[(bitmap.getWidth()) * bitmap.getHeight()];
        bitmap.getPixels(intArray, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        LuminanceSource source=new RGBLuminanceSource(bitmap.getWidth(),bitmap.getHeight(),intArray);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

        return binaryBitmap;

    }
}
