package com.coolweather.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.android.gson.Weather;

import java.util.List;

public class CardWeatherAdapter extends RecyclerView.Adapter<CardWeatherAdapter.ViewHolder> {
    private List<Weather> cardList;
    private Context mContext;
    public CardWeatherAdapter(List<Weather> weatherList) {
        cardList = weatherList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nowTemperature;
        TextView apiText;
        TextView titleCity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            nowTemperature = (TextView) itemView.findViewById(R.id.card_now_temperature);
            apiText = (TextView) itemView.findViewById(R.id.card_aqi_text);
            titleCity = (TextView) itemView.findViewById(R.id.card_title_city);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather weather = cardList.get(position);
        holder.nowTemperature.setText(weather.now.temperature);
        holder.apiText.setText(weather.aqi.city.aqi);
        holder.titleCity.setText(weather.basic.cityName);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }



}
