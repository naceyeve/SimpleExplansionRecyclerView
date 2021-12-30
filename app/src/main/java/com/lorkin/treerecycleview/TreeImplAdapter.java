package com.lorkin.treerecycleview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class TreeImplAdapter extends TreeAdapter {
    public TreeImplAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0) {
            view = this.inflater.inflate(R.layout.item_level0, parent, false);
            return new TypeViewHolder(view) {
                @Override
                public void bindHolder(final TreeItem model, final int position) {
                    this.setText(R.id.name_tv, model.getObj());
                    this.getView(R.id.item_ly).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (model.isOpen()) {
                                doClose(position, model);
                            } else {
                                doOpen(position, model);
                            }
                        }
                    });
                    if (model.isOpen()) {
                        this.setImageResource(R.id.arrow_iv, R.drawable.ic_arrow_down_24);
                    } else {
                        this.setImageResource(R.id.arrow_iv, R.drawable.ic_arrow_right_24);
                    }
                }
            };
        } else {
            //普通一级别
            view = this.inflater.inflate(R.layout.item_level3, parent, false);
            return new TypeViewHolder(view) {
                @Override
                public void bindHolder(final TreeItem model, int position) {
                    this.setText(R.id.name_tv, model.getObj());
                    this.getView(R.id.name_tv).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //添加点击事件
                            if (onItemClickListener != null) {
                                onItemClickListener.onItemClick((String)model.getObj());
                            }
                        }
                    });
                }
            };
        }
    }

    @Override
    public int getItemViewType(int position) {
        return this.list.get(position).getLevel();
    }

}
