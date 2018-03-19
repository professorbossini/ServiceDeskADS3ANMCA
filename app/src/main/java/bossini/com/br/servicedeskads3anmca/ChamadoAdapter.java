package bossini.com.br.servicedeskads3anmca;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rodrigo on 19/03/18.
 */

public class ChamadoAdapter <T> extends BaseAdapter {

    private List<T> chamados;
    private Activity context;
    public ChamadoAdapter(Activity context, List <T> chamados) {
        super();
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.chamados.size();
    }

    @Override
    public T getItem(int i) {
        return this.chamados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =
                (LayoutInflater) context.
                        getSystemService(
                                Context.
                                        LAYOUT_INFLATER_SERVICE);
        View v =
                inflater.inflate(R.layout.linha_chamado, viewGroup, false);
        ImageView imageView =
                v.findViewById(R.id.iconeFilaImageView);
        T chamado = getItem(i);
        Fila f = ((Chamado)chamado).getFila();
        Drawable foto =
                Util.getDrawable(context, f.getIcone());
        imageView.setImageDrawable(foto);
        TextView descricaoTextView =
                view.findViewById(R.id.descricaoTextView);
        descricaoTextView.setText(((Chamado)chamado).getDescricao());
        TextView dataAberturaTextView =
                view.findViewById(R.id.dataAberturaTextView);
        dataAberturaTextView.setText(
                ((Chamado)chamado).getDataAbertura()
                        .toString()
        );
        TextView statusTextView =
                view.findViewById(R.id.statusTextView);
        statusTextView.setText(((Chamado)chamado).getStatus());
        return view;
    }
}
