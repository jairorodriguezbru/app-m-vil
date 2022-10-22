package com.ingenios.roomsqlite.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ingenios.roomsqlite.R;
import com.ingenios.roomsqlite.repository.room.entities.Personas;

import java.util.List;

import static com.ingenios.roomsqlite.repository.room.utils.Utils.getDateOfBirth;

public class PersonasAdapter extends RecyclerView.Adapter<PersonasAdapter.PersonasViewHolder> {
    private onItemClickListener mOnItemClickListener;

    class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtItemNumber, txtLastName, txtFechaNac;
        ImageView btnDelete, btnUpdate;

        private PersonasViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtUserName);
            txtItemNumber = itemView.findViewById(R.id.txtItemNumber);
            txtLastName = itemView.findViewById(R.id.txtUserLastName);
            txtFechaNac = itemView.findViewById(R.id.txtDateNac);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onClick(view, getLayoutPosition());
                    }
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onClick(view, getLayoutPosition());
                    }
                }
            });
        }
    }

    private final LayoutInflater mInflater;
    private List<Personas> mPersonas;

    public PersonasAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.items_list_personas, parent, false);
        return new PersonasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        Personas personas = mPersonas.get(position);

        holder.txtItemNumber.setText((position + 1) + ".");
        holder.txtName.setText(String.format("%s %s", personas.getNombres(), personas.getApellidos()));
        holder.txtFechaNac.setText(getDateOfBirth(personas.getFechanacimiento()));

    }

    public void setPersonas(List<Personas> personas){
        mPersonas = personas;
        notifyDataSetChanged();
    }

    public Personas getPersona(int position) {
        return mPersonas.get(position);
    }

    @Override
    public int getItemCount() {
        if (mPersonas != null)
            return mPersonas.size();
        else return 0;
    }

    public interface onItemClickListener {
        void onClick(View view, int position);
        void onUpdateClick(View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
