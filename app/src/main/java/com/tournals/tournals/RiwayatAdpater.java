package com.tournals.tournals;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RiwayatAdpater extends RecyclerView.Adapter<RiwayatAdpater.RiwayatViewHolder> {
    private ArrayList<Rencana> listRencana;
    private Context context;
    MainActivity activity;

    public RiwayatAdpater(Context context, ArrayList<Rencana> listRencana){
        this.listRencana=listRencana;
        this.context = context;
    }
    @NonNull
    @Override
    public RiwayatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rencana, parent, false);
        return new RiwayatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RiwayatViewHolder holder, final int position) {
        holder.tvRencana.setText(listRencana.get(position).getRencana());
        holder.tvPerjalanan.setText(listRencana.get(position).getPerjalanan());
        holder.tvTanggalMulai.setText(listRencana.get(position).getTanggalMulai());
        holder.tvTanggalSelesai.setText(listRencana.get(position).getTanggalSelesai());
        holder.rlRencana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listRencana.get(position).getRencana(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SubRencanaActivity.class);
                intent.putExtra("NamaRencana",listRencana.get(position).getRencana());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listRencana != null) ? listRencana.size() : 0;
    }

    public class RiwayatViewHolder extends RecyclerView.ViewHolder{
        private TextView tvRencana,tvPerjalanan,tvTanggalMulai, tvTanggalSelesai;
        private RelativeLayout rlRencana;
        public RiwayatViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRencana = (TextView) itemView.findViewById(R.id.tvNamaRencana);
            tvPerjalanan = (TextView) itemView.findViewById(R.id.tvPerjalanan);
            tvTanggalMulai = (TextView) itemView.findViewById(R.id.tvTanggalMulai);
            tvTanggalSelesai = (TextView) itemView.findViewById(R.id.tvTanggalSelesai);
            rlRencana = (RelativeLayout) itemView.findViewById(R.id.rlRencana);
        }
    }
}