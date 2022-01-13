package vn.edu.huflit.yogadaily;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemVH> implements Filterable {
    ArrayList<Items> arrayList;
    ArrayList<Items> arrayListFilter;
    Listener listener;

    public ItemAdapter(ArrayList<Items> arrayList, Listener listener) {
        this.arrayList = arrayList;
        this.arrayListFilter = arrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_items, parent, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemVH holder, int position) {
        Items items = arrayList.get(position);
        holder.img_item.setImageResource(items.itemImg);
        holder.txt_item_name.setText(items.itemName);
        holder.txt_item_des.setText(items.itemDes);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(items);
            }
        });
    }
    interface Listener{
        void onClick(Items items);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return new ItemsFilter();
    }

    class ItemVH extends RecyclerView.ViewHolder{
        ImageView img_item;
        TextView txt_item_name;
        TextView txt_item_des;
        public ItemVH(@NonNull View itemView) {
            super(itemView);
            img_item = itemView.findViewById(R.id.imageItem);
            txt_item_name = itemView.findViewById(R.id.textItemName);
            txt_item_des = itemView.findViewById(R.id.textItemDes);
        }
    }

    class ItemsFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            if (charString.isEmpty()){
                arrayListFilter = arrayList;
            }
            else {
                ArrayList<Items> filteredList = new ArrayList<>();
                for (Items row : arrayList){
                    if (row.itemName.toLowerCase().contains(charString.toLowerCase()) || row.itemDes.contains(charString)){
                        filteredList.add(row);
                    }
                }

                arrayListFilter = filteredList;
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = arrayListFilter;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            arrayListFilter = (ArrayList<Items>) results.values;
            notifyDataSetChanged();
        }
    }
}
