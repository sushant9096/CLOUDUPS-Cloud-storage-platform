import uploader.SwingFileUploadHTTP;

public class UploadAdapter extends Thread {
    @Override
    public void run() {
        new SwingFileUploadHTTP().setVisible(true);
    }
}
