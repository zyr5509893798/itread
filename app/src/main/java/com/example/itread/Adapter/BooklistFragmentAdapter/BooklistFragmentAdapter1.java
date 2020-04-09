package com.example.itread.Adapter.BooklistFragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.itread.BookListActivity;
import com.example.itread.R;

import java.util.List;
import java.util.Map;

public class BooklistFragmentAdapter1 extends RecyclerView.Adapter<BooklistFragmentAdapter1.ViewHolder>{

    private List<Map<String, Object>> list;
    private Context context;
    int i=0;




    public BooklistFragmentAdapter1(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;



    }



    @NonNull
    @Override
    public BooklistFragmentAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.item_booklist, parent, false);
            return new BooklistFragmentAdapter1.ViewHolder(view);
        }
        else {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_real_empty, parent, false);
            return new BooklistFragmentAdapter1.ViewHolder(view2);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull BooklistFragmentAdapter1.ViewHolder holder, final int position) {

        if (position<getItemCount()/3){
            String name1 = list.get(3*(position)).get("name").toString();
            String image1 = list.get(3*position).get("image").toString();
            String number1 = list.get(3*position).get("number").toString();
            String num1 = list.get(3*position).get("num").toString();
            i++;

            String name2 = list.get(3*(position)+1).get("name").toString();
            String image2 = list.get(3*position+1).get("image").toString();
            String number2 = list.get(3*position+1).get("number").toString();
            String num2 = list.get(3*position+1).get("num").toString();
            i++;

            String name3 = list.get(3*(position)+2).get("name").toString();
            String image3 = list.get(3*position+2).get("image").toString();
            String number3 = list.get(3*position+2).get("number").toString();
            String num3 = list.get(3*position+2).get("num").toString();
            i++;

            holder.textView1.setText(name1);
            holder.textView2.setText(name2);
            holder.textView3.setText(name3);

            holder.number1.setText(number1);
            holder.number2.setText(number2);
            holder.number3.setText(number3);

            GlideWithPictureUrl(image1,holder.imageView1);
            GlideWithPictureUrl(image2,holder.imageView2);
            GlideWithPictureUrl(image3,holder.imageView3);

            holder.imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookListActivity.class);
                    intent.putExtra("list_id",num1);
                    context.startActivity(intent);
                }
            });
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookListActivity.class);
                    intent.putExtra("list_id",num2);
                    context.startActivity(intent);
                }
            });
            holder.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookListActivity.class);
                    intent.putExtra("list_id",num3);
                    context.startActivity(intent);
                }
            });

        }



    }
    @Override
    public int getItemCount() {
        int size;
        size = list.size()-list.size()%3;
        return size;
    }

    private void IntentToView(ImageView imageView,String string,ViewHolder holder){

    }


    private void GlideWithPictureUrl(String image,ImageView imageView){
        String picture_1 = image.replace("\\","");
        String picture_2 = picture_1.replace("\"","");
        String picture_3 = picture_2.replace("[","");
        String picture_4 = picture_3.replace("]","");


        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(this.context)
                .load(picture_4)
                .apply(options)
                .into(imageView);



    }
    @Override
    public int getItemViewType(int position) {

        if (position<getItemCount()/3){
            return 1;
        }
        else
        {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private ImageView imageView1;
        private ImageView imageView2;
        private ImageView imageView3;
        private TextView number1;
        private TextView number2;
        private TextView number3;
        private RelativeLayout relativeLayout;



        ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);

            imageView1 = itemView.findViewById(R.id.pic1);
            imageView2 = itemView.findViewById(R.id.pic2);
            imageView3 = itemView.findViewById(R.id.pic3);

            number1 = itemView.findViewById(R.id.number1);
            number2 = itemView.findViewById(R.id.number2);
            number3 = itemView.findViewById(R.id.number3);
        }

    }


}
