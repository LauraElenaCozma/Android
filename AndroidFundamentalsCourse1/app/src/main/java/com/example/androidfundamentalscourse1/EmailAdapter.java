package com.example.androidfundamentalscourse1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder> {

    private List<Email> emails;
    private Context context;

    public EmailAdapter(Context context, List<Email> emails) {
        this.emails = emails;
        this.context = context;
    }

    //creates the items and add them to the recyclerView, just the layout
    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutInflater stie sa le adauge la rand
        //parent: initial un element, dupa primele 2 elemente etc.
        //false: vrem sa il atasam la recycler view + posibilii itemi adaugati
        View itemView = LayoutInflater.from(context).inflate(R.layout.email_item, parent, false);
        // <=> View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(itemView);
    }

    //take the elements from the list and every element from the list
    //is associated to an item view
    //bind(display) the content from the list of emails for each item
    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        //position: unde a ajuns cu bindingul
        Email currentEmail = emails.get(position);
        holder.getTextViewFrom().setText(currentEmail.getFromName());
        holder.getTextViewSubject().setText(currentEmail.getTitle()); // = subject
        holder.getTextViewBody().setText(currentEmail.getShortBody());
    }

    //we tell to the recycler view how many items to display
    @Override
    public int getItemCount() {
        return emails.size();
    }
}
