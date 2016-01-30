package com.lt.book.ui.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/**
 * Created by tao.lai on 2016/1/30 0030.
 */
public class ViewScanResultPointCallback implements ResultPointCallback {
    private final ViewScan viewfinderView;

    public ViewScanResultPointCallback(ViewScan viewfinderView) {
        this.viewfinderView = viewfinderView;
    }

    @Override
    public void foundPossibleResultPoint(ResultPoint point) {
        viewfinderView.addPossibleResultPoint(point);
    }
}
