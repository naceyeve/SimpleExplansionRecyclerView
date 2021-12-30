package com.lorkin.treerecycleview;


import java.util.ArrayList;
import java.util.List;

/**
 * 【类功能】
 *
 * @author pengli
 * @version 2021/12/30
 */

class ItemData {

    private List<TreeItem> data;

    public List<TreeItem> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }
}
