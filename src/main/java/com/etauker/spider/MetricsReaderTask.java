package com.etauker.spider;

import com.etauker.spider.model.Metrics;
import com.etauker.spider.service.MetricsService;

public class MetricsReaderTask implements Runnable {

    @Override
    public void run() {
        Metrics metrics = MetricsService.getMetrics();
        System.out.println(metrics.toReadableString());
    }

}
