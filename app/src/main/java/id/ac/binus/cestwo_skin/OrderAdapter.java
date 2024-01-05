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
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getSkinName();
        String price = getItem(position).getSkinPrice();
        String poster = getItem(position).getSkinPoster();
        String sob = getItem(position).getSkinSoB();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView txtNama = convertView.findViewById(R.id.txtName);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);
        TextView txtPoster = convertView.findViewById(R.id.txtPoster);
        TextView txtSoB = convertView.findViewById(R.id.txtOrderType);
        Button btn = convertView.findViewById(R.id.placeBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Trade request has been sent!", Toast.LENGTH_LONG).show();
            }
        });

        txtNama.setText(name);
        txtPrice.setText(price);
        txtPoster.setText(poster);
        txtSoB.setText(sob);

        return convertView;
    }
}
