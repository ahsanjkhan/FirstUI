package com.example.firstui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.Placeholder;

public class NumberAdapter extends ArrayAdapter<Number> {

    Context myContext;
    int myResourceId;
    Number[] myNumbers;

    public NumberAdapter(Context context, int resource, Number[]data){
        super(context,resource,data);
        this.myContext=context;
        this.myResourceId=resource;
        this.myNumbers =data;
    }

    @Override
    public Number getItem(int position){
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowToReturn = convertView;
        PlaceHolder myPlaceHolder = null;

        if (rowToReturn==null){
            LayoutInflater inflater = LayoutInflater.from(myContext);
            rowToReturn = inflater.inflate(myResourceId,parent,false);
            myPlaceHolder = new PlaceHolder();
            myPlaceHolder.titleView = rowToReturn.findViewById(R.id.myTitle);
            myPlaceHolder.descView = rowToReturn.findViewById(R.id.myDesc);
            myPlaceHolder.imageView = (ImageView)(rowToReturn.findViewById(R.id.myImage));
            rowToReturn.setTag(myPlaceHolder);
        }
        else{
            myPlaceHolder = (PlaceHolder)(rowToReturn.getTag());
        }

        Number num = myNumbers[position];
        myPlaceHolder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        myPlaceHolder.imageView.setTag(rowPosition);

        myPlaceHolder.titleView.setText(num.myName);
        myPlaceHolder.descView.setText(Integer.toString(num.myNum));
        int resId = myContext.getResources().getIdentifier(num.myName.toLowerCase(),"drawable",myContext.getPackageName());
        myPlaceHolder.imageView.setImageResource(resId);

        return rowToReturn;
    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer viewPosition = (Integer)(v.getTag());
            Number n = myNumbers[viewPosition];
            Toast.makeText(v.getContext(),("IMAGE: " + n.myName.toLowerCase() + ".png"),Toast.LENGTH_LONG).show();
        }
    };
    /*public View getView(int position, View convertView, ViewGroup parent){
        View rowToReturn = convertView;
        LayoutInflater inflater = LayoutInflater.from(myContext);
        rowToReturn = inflater.inflate(myResourceId,parent,false);

        Number num = myNumbers[position];
        ((TextView)(rowToReturn.findViewById(R.id.myTitle))).setText(num.myName);
        ((TextView)(rowToReturn.findViewById(R.id.myDesc))).setText(Integer.toString(num.myNum));

        int resId = myContext.getResources().getIdentifier(num.myName.toLowerCase(),"drawable",myContext.getPackageName());
        ((ImageView)(rowToReturn.findViewById(R.id.myImage))).setImageResource(resId);

        return rowToReturn;
    }*/

    private static class PlaceHolder {
        TextView titleView;
        TextView descView;
        ImageView imageView;
    }
}
