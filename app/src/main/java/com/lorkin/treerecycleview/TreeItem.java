package com.lorkin.treerecycleview;

import java.util.ArrayList;
import java.util.List;

public class TreeItem {
    //层级
    private int level;
    //状态，打开或者关闭
    private boolean isOpen;
    //当前行的数据
    private String obj;
    //当前行的子数据
    private List<TreeItem> child;

    public TreeItem(String obj) {
        this.level = 0;
        this.isOpen = false;
        this.obj = obj;
    }

    public TreeItem(boolean isOpen, String obj) {
        this.isOpen = isOpen;
        this.obj = obj;
    }

    public TreeItem(int level, boolean isOpen, String obj) {
        this.level = level;
        this.isOpen = isOpen;
        this.obj = obj;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public List<TreeItem> getChild() {
        if (child == null){
            return new ArrayList<>();
        }
        return child;
    }

    public void addChilds(List<TreeItem> child) {
        if (child == null){
            return;
        }
        this.child = child;
    }
}
