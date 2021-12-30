package com.lorkin.treerecycleview;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> list;
    private Context context;
    protected LayoutInflater inflater;
    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CommonAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((TypeViewHolder) holder).bindHolder(list.get(position), position);
    }

    public void setDatas(List<T> datas) {
        this.list = datas;
        notifyDataSetChanged();
    }

    public void addData(int position, List<T> treeItems) {
        this.list.addAll(position + 1, treeItems);
    }

    @Override
    public abstract int getItemViewType(int position);

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * -----------------------------------------------------------------------------------------------
     */
    public abstract class TypeViewHolder extends RecyclerView.ViewHolder {

        private View convertView;
        private SparseArray<View> views = new SparseArray<>();

        public TypeViewHolder(View itemView) {
            super(itemView);
            this.convertView = itemView;
        }

        @SuppressWarnings("unchecked")
        public <V extends View> V getView(int viewId) {
            View view = views.get(viewId);
            if (view == null) {
                view = convertView.findViewById(viewId);
                views.put(viewId, view);
            }
            return (V) view;
        }

        public TypeViewHolder setText(int viewId, String text) {
            String str = "";
            if (!TextUtils.isEmpty(text)) {
                str = text.replace("null", "");
            }
            TextView textView = getView(viewId);
            textView.setText(str);
            return this;
        }

        public TypeViewHolder setBackgroundColor(int viewId, int colorId) {
            View view = getView(viewId);
            view.setBackgroundResource(colorId);
            return this;
        }

        public TypeViewHolder setVisible(int viewId, int visible) {
            View view = getView(viewId);
            view.setVisibility(visible);
            return this;
        }

        public TypeViewHolder setImageResource(int viewId, int imgId) {
            ImageView view = getView(viewId);
            view.setImageResource(imgId);
            return this;
        }

        public abstract void bindHolder(T model, int position);
    }

    /**
     * -----------------------------------------------------------------------------------------------
     */
    public interface OnItemClickListener<T> {
        void onItemClick(T t);
    }

}