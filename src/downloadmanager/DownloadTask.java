package downloadmanager;

import java.net.URL;

public class DownloadTask {
    private URL url;
    private String fileName;
    private DownloadStatus status;
    private int progress; // 0-100 percent

    public DownloadTask(URL url, String fileName){
        this.url = url;
        this.fileName = fileName;
        this.status = DownloadStatus.PENDING;
        this.progress = 0;
    }

    public URL getUrl(){ return url; }

    public String getFileName(){ return fileName; }

    public DownloadStatus getStatus() { return status; }

    public void setStatus(DownloadStatus status){ this.status = status; }

    public int getProgress(){ return progress; }

    public void setProgress(int progress){ this.progress = progress; }

    @Override
    public String toString(){
        return "DownloadTask{" + "url=" + url
        + ", fileName=" + fileName + '\''
        + ", status=" + status
        + ", progress=" + progress + "%"
        + "}";
    }
}
