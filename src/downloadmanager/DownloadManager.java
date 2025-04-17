package downloadmanager;

import java.util.*;
import java.util.concurrent.*;

public class DownloadManager {
    private final ExecutorService executor;
    private final List<DownloadTask> tasks;

    public DownloadManager(int maxParallelDownloads){
        this.executor = Executors.newFixedThreadPool(maxParallelDownloads);
        this.tasks = new ArrayList<>();
    }

    public void startAll() {
        for(DownloadTask task: tasks){
            executor.submit(new DownloadWorker(task));
        }
    }

    public void shutdown(){ executor.shutdown(); }

    public List<DownloadTask> getTasks() { return tasks; }

}
