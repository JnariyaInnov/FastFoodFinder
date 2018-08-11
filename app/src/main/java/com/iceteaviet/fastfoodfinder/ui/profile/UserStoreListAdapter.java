package com.iceteaviet.fastfoodfinder.ui.profile;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iceteaviet.fastfoodfinder.R;
import com.iceteaviet.fastfoodfinder.data.remote.user.model.UserStoreList;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MyPC on 12/5/2016.
 */
public class UserStoreListAdapter extends RecyclerView.Adapter<UserStoreListAdapter.ListViewHolder> {

    private List<UserStoreList> mListPackets;
    private OnItemClickListener mListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    UserStoreListAdapter() {
        mListPackets = new ArrayList<>();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }

    public void addListPacket(UserStoreList listPacket) {
        mListPackets.add(listPacket);
        notifyItemRangeInserted(mListPackets.size(), 1);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mListener = onItemClickListener;
    }

    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_new_list, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        UserStoreList listPacket = mListPackets.get(position);
        holder.tvName.setText(listPacket.getListName());
        holder.cvIcon.setImageResource(listPacket.getIconId());
    }

    @Override
    public int getItemCount() {
        return mListPackets.size();
    }

    public interface OnItemLongClickListener {
        void onClick(int position);
    }

    public interface OnItemClickListener {
        void onClick(UserStoreList listPacket);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNameList)
        TextView tvName;
        @BindView(R.id.iconNewList)
        CircleImageView cvIcon;

        ListViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserStoreList listPacket = mListPackets.get(getAdapterPosition());
                    mListener.onClick(listPacket);

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    final int position = getAdapterPosition();
                    //final UserStoreList userStoreList = mListPackets.get(position);
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(R.string.delete_favourite_location)
                            .setMessage(R.string.are_you_sure)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mListPackets.remove(position);
                                    notifyDataSetChanged();
                                    mOnItemLongClickListener.onClick(position);

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    return true;
                }
            });
        }
    }
}