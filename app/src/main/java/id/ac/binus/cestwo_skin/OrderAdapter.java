package id.ac.binus.cestwo_skin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import id.ac.binus.cestwo_skin.model.Orders;

public class OrderAdapter extends ArrayAdapter<Orders> {
    private Context context;
    private int resource;

    public OrderAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Orders> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getSkinName();
        String price = getItem(position).getSkinPrice();
        String orderType = getItem(position).getSkinSoB();
        String poster = getItem(position).getSkinPoster();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView txtNama = convertView.findViewById(R.id.txtName);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);
        TextView txtOrderType = convertView.findViewById(R.id.txtOrderType);
        TextView txtPoster = convertView.findViewById(R.id.txtPoster);
//        Button btn = convertView.findViewById(R.id.placeBtn);

        txtNama.setText(name);
        txtPrice.setText(price);
        txtOrderType.setText(orderType);
        txtPoster.setText(poster);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), "Trade request has been sent!", Toast.LENGTH_LONG).show();
//            }
//        });

        return convertView;
    }
}
