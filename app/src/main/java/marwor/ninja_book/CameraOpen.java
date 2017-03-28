package marwor.ninja_book;
import android.content.Context;
import android.hardware.Camera;

import java.lang.Object;


public class CameraOpen {

    public static Camera getCameraInstance(){
        Camera cam = null;
        try {
            cam = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            //wyswietlic komunikat i wrocic do aktywnosci main
            // Camera is not available (in use or does not exist)

        }
        return cam; // returns null if camera is unavailable
    }
    }



