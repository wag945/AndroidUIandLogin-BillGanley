package com.example.bill.androiduiandlogin_billganley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class UserAdapter extends ArrayAdapter {

    public UserAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // It recover the view to the inflate

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_item, parent, false);
        }

        // Get the object located at this position in the list
        UserProfile userProfile = (UserProfile) getItem(position);

        // Find the TextView in the xml layout wit the ID
        TextView textViewFirstname = (TextView) listItemView.findViewById(R.id.text_view_firstname);

        // Get the user firstname from the current UserProfile object and
        // set this text on the firstname TextView
        textViewFirstname.setText(userProfile.getFirstname());

        TextView textViewSurname = (TextView) listItemView.findViewById(R.id.text_view_surname);

        // Get the surname from the current UserProfile object and
        // set this text on the surname TextView
        textViewSurname.setText(userProfile.getSurname());

        // Find the TextView in the xml layout with the ID version_number
        TextView textViewUsername = (TextView) listItemView.findViewById(R.id.text_view_username);

        // Get the username from the current UserProfile object and
        // set this text on the number TextView
        textViewUsername.setText(userProfile.getUsername());


        // TODO You can also customize the ImageView.

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
