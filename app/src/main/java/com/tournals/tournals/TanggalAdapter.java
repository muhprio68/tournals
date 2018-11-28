package com.tournals.tournals;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TanggalAdapter extends RecyclerView.Adapter<TanggalAdapter.TanggalViewHolder>{
    private ArrayList<Rencana> listRencana;
    private Context context;
    MainActivity activity;
    EditText edtPilihTanggal;
    public AlertDialog dialog;

    public TanggalAdapter(Context context, ArrayList<Rencana> listRencana, EditText edtPilihTanggal){
        this.context=context;
        this.listRencana=listRencana;
        this.edtPilihTanggal = edtPilihTanggal;
    }

    @NonNull
    @Override
    public TanggalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tanggal, parent, false);
        return new TanggalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TanggalAdapter.TanggalViewHolder holder, final int position) {
        holder.tvPilihTanggal.setText(listRencana.get(position).getTanggalMulai());
        holder.rlPilihTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, listRencana.get(position).getRencana(), Toast.LENGTH_SHORT).show();
                edtPilihTanggal.setText(listRencana.get(position).getTanggalMulai());
                dialog.cancel();
//                holder.edtPilihTanggal.setText(listRencana.get(position).getTanggalMulai());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listRencana != null) ? listRencana.size() : 0;
    }
    public class TanggalViewHolder extends RecyclerView.ViewHolder{
        private TextView tvPilihTanggal;
        private  EditText edtPilihTanggal;
        private RelativeLayout rlPilihTanggal;
        public TanggalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPilihTanggal = (TextView) itemView.findViewById(R.id.tvPilihTanggal);
            edtPilihTanggal = (EditText) itemView.findViewById(R.id.edtPilihTanggal);
            rlPilihTanggal = (RelativeLayout) itemView.findViewById(R.id.rlPilihTanggal);
        }
    }
}