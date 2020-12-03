package com.example.androidfundamentalscourse1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//wrapper for email_item.xml views (translate the views in Java objects)
// 1:1 relation between each view from item and each field from java class EmailViewHolder
public class EmailViewHolder extends RecyclerView.ViewHolder {
    //tine legatura cu itemul
    //trebuie sa avem cele 3 text view-uri
    private TextView textViewFrom, textViewSubject, textViewBody;

    public EmailViewHolder(@NonNull View itemView) {
        super(itemView);

        //trebuie sa initializam textView urile
        //nu putem face findViewById pentru ca nu suntem intr-o activitate; nu avem un layout asociat
        //avem acest View itemView care e layout ul
        textViewFrom = itemView.findViewById(R.id.textViewFrom);
        textViewSubject = itemView.findViewById(R.id.textViewSubject);
        textViewBody = itemView.findViewById(R.id.textViewBody);
        //am initializat text view-urile
    }

    public TextView getTextViewFrom() {
        return textViewFrom;
    }

    public TextView getTextViewSubject() {
        return textViewSubject;
    }

    public TextView getTextViewBody() {
        return textViewBody;
    }
}
