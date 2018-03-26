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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        ImageView imageView = null;
        TextView dataAberturaTextView;
        TextView descricaoTextView = null;
        TextView statusTextView =null;
        if (convertView == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.
                            getSystemService(
                                    Context.
                                            LAYOUT_INFLATER_SERVICE);
            convertView =
                    inflater.inflate(R.layout.linha_chamado, viewGroup, false);
            imageView =
                    convertView.findViewById(R.id.iconeFilaImageView);
            descricaoTextView =
                    convertView.findViewById(R.id.descricaoTextView);
            dataAberturaTextView =
                    convertView.findViewById(R.id.dataAberturaTextView);
            statusTextView =
                    convertView.findViewById(R.id.statusTextView);
            viewHolder = new ViewHolder();
            viewHolder.iconeFilaImageView = imageView;
            viewHolder.descricaoTextView = descricaoTextView;
            viewHolder.dataAberturaTextView = dataAberturaTextView;
            viewHolder.statusTextView = statusTextView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        T chamado = getItem(i);
        Fila f = ((Chamado)chamado).getFila();
        Drawable foto =
                Util.getDrawable(context, f.getIcone());
        viewHolder.iconeFilaImageView.setImageDrawable(foto);
        viewHolder.descricaoTextView.setText(((Chamado)chamado).getDescricao());
        viewHolder.dataAberturaTextView.setText(
                ((Chamado)chamado).getDataAbertura()
                        .toString()
        );
        viewHolder.statusTextView.setText(((Chamado)chamado).getStatus());
        return convertView;
    }

    private class ViewHolder{
        ImageView iconeFilaImageView;
        TextView descricaoTextView;
        TextView dataAberturaTextView;
        TextView statusTextView;
    }
}
