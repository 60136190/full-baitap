package oltest.bai13.ThaiVanNam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomListAdapter  extends BaseAdapter {
    private List<Animal> listData;              // Danh sách mục dữ liệu cho Adapter của mình
    private LayoutInflater layoutInflater;
    private Context context;
    public MyCustomListAdapter(List<Animal> listData, Context aContext) {
        this.listData = listData;
        this.context = context;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyCustomItemListView row;
        if (view==null) {
            view = layoutInflater.inflate(R.layout.my_list,null);
            row = new MyCustomItemListView();
            row.imageViewAnimal =(ImageView)view.findViewById(R.id.imAnimal);
            row.textViewAnimal = (TextView)view.findViewById(R.id.tvTenAnimal);
            row.textViewMota = (TextView)view.findViewById(R.id.tvMota);
            r
            view.setTag(row);
        }
        else   {
            row = (MyCustomItemListView)view.getTag();
        }
        Animal quocGia = this.listData.get(i);
        row.textViewAnimal.setText(quocGia.getTenAnimal());
        row.textViewMota.setText("Mô tả: " + quocGia.getMota());
        row.imageViewAnimal.setImageResource(quocGia.getIDanhAnimal());
        return  view;
    }
    static class MyCustomItemListView {
        ImageView imageViewAnimal;
        TextView textViewAnimal;
        TextView textViewMota;
    }
}