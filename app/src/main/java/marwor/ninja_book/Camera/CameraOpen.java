package marwor.ninja_book.Camera;
import android.hardware.Camera;


public class CameraOpen {

    public static Camera getCameraInstance(){
        Camera cam = null;
        try {
            cam = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){



        }
        return cam; // returns null if camera is unavailable
    }
    }



