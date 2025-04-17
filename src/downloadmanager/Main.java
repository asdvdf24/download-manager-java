package downloadmanager;

import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception{
        DownloadManager manager = new DownloadManager(2);

        DownloadTask task1 = new DownloadTask(null, "example-picture.png");
        DownloadTask task2 = new DownloadTask(null, "example-file.txt");

        manager.addDownload(task1.getUrl(), task1.getFileName());
        manager.addDownload(task2.getUrl(), task2.getFileName());

        manager.startAll();
        manager.shutdown();
    }
}
