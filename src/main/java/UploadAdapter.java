import uploader.SwingFileUploadHTTP;

public class UploadAdapter extends Thread {
    @Override
    public void run() {
        new SwingFileUploadHTTP(Res.server_url+"upload.php?u="+Res.user_username).setVisible(true);
    }
}
