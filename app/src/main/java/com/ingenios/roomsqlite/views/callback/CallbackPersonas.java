package com.ingenios.roomsqlite.views.callback;

import androidx.recyclerview.widget.DiffUtil;

import com.ingenios.roomsqlite.repository.room.entities.Personas;

import java.util.List;

public class CallbackPersonas extends DiffUtil.Callback {

    private List<Personas> newUserList;
    private List<Personas> oldUserList;


    public CallbackPersonas(List<Personas> newUserList, List<Personas> oldUserList) {
        this.newUserList = newUserList;
        this.oldUserList = oldUserList;
    }

    @Override
    public int getOldListSize() {
        return oldUserList != null ? oldUserList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newUserList != null ? newUserList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUserList.get(oldItemPosition).getId() == newUserList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUserList.get(oldItemPosition).equals(newUserList.get(newItemPosition));
    }
}
