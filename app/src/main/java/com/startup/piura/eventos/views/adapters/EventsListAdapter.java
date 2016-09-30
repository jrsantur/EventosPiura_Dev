package com.startup.piura.eventos.views.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.model.events.entities.Event;
import com.model.events.entities.Preferencias;
import com.startup.piura.eventos.R;
import com.startup.piura.eventos.views.RecyclerClickListener;
import java.util.List;
import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by Junior on 30/09/2016.
 */

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.EventViewHolder> {

    private Context mContext;
    private final String NOT_AVAILABLE_URL = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg";
    private final RecyclerClickListener mRecyclerListener;
    private final List<Preferencias> listPreferencias;

    public EventsListAdapter(Context mContext, RecyclerClickListener mRecyclerListener, List<Preferencias> listPreferencias) {
        this.mContext = mContext;
        this.mRecyclerListener = mRecyclerListener;
        this.listPreferencias = listPreferencias;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView  = LayoutInflater.from(mContext).inflate(R.layout.item_preference, parent, false);
        return new EventViewHolder(rootView, mRecyclerListener);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.bindEvent(listPreferencias.get(position));
    }

    @Override
    public int getItemCount() {
        return listPreferencias.size();
    }

    public class EventViewHolder  extends RecyclerView.ViewHolder{

        @Bind(R.id.img_preference)  ImageView imagenPreference ;
        @Bind(R.id.text_preference) TextView textPreference;
        @Bind(R.id.star_seelect) Button star_select;
        @BindColor(R.color.brand_primary)           int mColorPrimary;
        public EventViewHolder(View itemView, final RecyclerClickListener recyclerClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            bindListener(itemView, recyclerClickListener);
        }
        void bindEvent(Preferencias preference){
            textPreference.setText(preference.getTitulo());
            if(preference.getUrlImagen().equals(NOT_AVAILABLE_URL)){
                ColorDrawable colorDrawable = new ColorDrawable(mColorPrimary);
                imagenPreference.setDrawingCacheEnabled(true);
                imagenPreference.setImageDrawable(colorDrawable);
            }else {
                Glide.with(mContext).load(preference.getUrlImagen()).crossFade().into(imagenPreference);
            }
        }

        private void bindListener(View itemView, final RecyclerClickListener recyclerClickListener) {
            itemView.setOnClickListener(v ->
                    recyclerClickListener.onElementClick(getPosition(),  textPreference, imagenPreference ,star_select));
        }
    }
}
