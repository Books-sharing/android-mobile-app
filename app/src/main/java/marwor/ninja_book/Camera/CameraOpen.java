package marwor.ninja_book.Camera;
import android.hardware.Camera;


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



