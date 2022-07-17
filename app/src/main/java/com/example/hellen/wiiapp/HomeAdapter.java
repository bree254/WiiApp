package com.example.hellen.wiiapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeView> {

    List<Integer> imageList;
    List<String> imageDescriptionList;
    Context mContext;


    public HomeAdapter(List<Integer> imageList, List<String> imageDescriptionList) {
        this.imageList = imageList;
        this.imageDescriptionList = imageDescriptionList;
    }

    //before passing anything create a view class
    //finally implement methods

    @NonNull
    @Override
    public HomeView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //pass the layout resource file ie row_home
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home,parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home,parent,false);
        mContext = parent.getContext();

        return  new HomeView(view);//pass the object we created
        //We have adapter ready so lets keep the data ready ie in main activity page

        //OR
        //HomeView holder = new HomeView(view);
       // return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeView holder, final int position) {

        //passing values
        holder.image.setImageResource(imageList.get(position));
        holder.imageDescr.setText(imageDescriptionList.get(position));

        //finally run
        holder.hCV.setOnClickListener(view -> {
            String page = imageDescriptionList.get(position);


            if(page.equals(mContext.getResources().getString(R.string.packages))){
               // Toast.makeText(mContext, "Packages", Toast.LENGTH_SHORT).show();
                Intent sample = new Intent(mContext, PackagesActivity.class);
                sample.putExtra("service",mContext.getResources().getString(R.string.packages).toLowerCase() );
                mContext.startActivity(sample);
            }
            if(page.equals(mContext.getResources().getString(R.string.install))){
               // Toast.makeText(mContext, "Installation", Toast.LENGTH_SHORT).show();
                Intent sample = new Intent(mContext, InstallationActivity.class);
                sample.putExtra("service",mContext.getResources().getString(R.string.install).toLowerCase() );
                mContext.startActivity(sample);
            }
            if(page.equals(mContext.getResources().getString(R.string.my_account))){
                //Toast.makeText(mContext, "My Account", Toast.LENGTH_SHORT).show();
                Intent sample = new Intent(mContext, MyAccountActivity.class);
                sample.putExtra("service",mContext.getResources().getString(R.string.my_account).toLowerCase() );
                mContext.startActivity(sample);
            }
            if(page.equals(mContext.getResources().getString(R.string.customer_support))){
                //Toast.makeText(mContext, "Customer Support", Toast.LENGTH_SHORT).show();
                Intent sample = new Intent(mContext, CustomersupportActivity.class);
                sample.putExtra("service",mContext.getResources().getString(R.string.customer_support).toLowerCase() );
                mContext.startActivity(sample);
            }
            if(page.equals(mContext.getResources().getString(R.string.log))){
               // Toast.makeText(mContext, "logout", Toast.LENGTH_SHORT).show();
                Intent sample = new Intent(mContext, LogoutActivity.class);
                sample.putExtra("service",mContext.getResources().getString(R.string.log).toLowerCase() );
                mContext.startActivity(sample);
            }
        });

    }
    @Override
    public int getItemCount() {
        return imageList.size();
    }

    //before passing anything create a view class
    public class HomeView extends RecyclerView.ViewHolder{
        ImageView image;
        TextView imageDescr;
        CardView hCV;
    //create constructor of that view
        public HomeView(@NonNull View itemView) {
            super(itemView);

            imageDescr = itemView.findViewById(R.id.imageDescription);
            image = itemView.findViewById(R.id.image);
            hCV = itemView.findViewById(R.id.hCV);
        }
    }
}