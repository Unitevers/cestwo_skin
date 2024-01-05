package id.ac.binus.cestwo_skin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        TextView txtNim = convertView.findViewById(R.id.txtNim);
        TextView txtNama = convertView.findViewById(R.id.txtNama);
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
        TextView txtAlamat = convertView.findViewById(R.id.txtAlamat);

        txtNim.setText(nim);
        txtNama.setText(name);
        txtPhone.setText(phone);
        txtEmail.setText(email);
        txtAlamat.setText(alamat);

        return convertView;

    }
}
