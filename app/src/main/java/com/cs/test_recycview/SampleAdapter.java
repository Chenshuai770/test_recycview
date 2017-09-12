package com.cs.test_recycview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12/012.
 */

public class SampleAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<String> mEditTextValues;


    public SampleAdapter(Context context, List<String> mEditTextValues) {
        this.context = context;
        this.mEditTextValues = mEditTextValues;

    }
    public interface SaveEditListener{
        void SaveEdit(int pos,String content);

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test,parent,false));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CustomViewHolder viewHolder = ((CustomViewHolder)holder);
        viewHolder.mEditText.setTag(position);
        viewHolder.mEditText.setText(mEditTextValues.get(position));


        Log.d("SampleAdapter", viewHolder.mEditText.getText().toString());
        viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0){
                    mEditTextValues.add("新项目"+"");
                    notifyDataSetChanged();

                }else {
                    mEditTextValues.remove(position);
                    notifyDataSetChanged();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return mEditTextValues.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private EditText mEditText;
        private ImageView mImageView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            mEditText = (EditText)itemView.findViewById(R.id.et_itme);
            mImageView = (ImageView)itemView.findViewById(R.id.iv_item);
            mEditText.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                public void afterTextChanged(Editable editable) {}
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(mEditText.getTag()!=null){
                        mEditTextValues.set((int)mEditText.getTag(),charSequence.toString());

                    }
                }
            });
        }
    }
}