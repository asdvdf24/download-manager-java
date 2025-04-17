package downloadmanager;

import java.io.*;
import java.net.HttpURLConnection;

public class DownloadWorker implements Runnable{
    private final DownloadTask task;

    public DownloadWorker(DownloadTask task){ this.task = task; }

    @Override
    public void run(){
        task.setStatus(DownloadStatus.IN_PROGRESS);
        try(var inputStream = task.getUrl().openStream();
            var outputStream = new FileOutputStream(task.getFileName())){

            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytes = 0;

            while((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;

                task.setProgress((int) (totalBytes/1000));
            }

            task.setStatus(DownloadStatus.COMPLETED);
        }
        catch(IOException e){
            task.setStatus(DownloadStatus.FAILED);
            e.printStackTrace();
        }
            
    }
    
}
