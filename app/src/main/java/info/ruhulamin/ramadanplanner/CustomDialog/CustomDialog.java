package info.ruhulamin.ramadanplanner.CustomDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.ruhulamin.ramadanplanner.R;

public class CustomDialog {
    public Dialog customDialog(Context context){

        Dialog customD = new Dialog(context);
        customD.setContentView(R.layout.custom_dialog);

        Button btn_custom_dialog = (Button) customD.findViewById(R.id.btn_custom_dialog);

        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customD.dismiss();
            }
        });
        return  customD;
    }

    public Dialog customDialog(Context context, String details){

        Dialog customD = new Dialog(context);
        customD.setContentView(R.layout.custom_dialog);

        Button btn_custom_dialog = (Button) customD.findViewById(R.id.btn_custom_dialog);
        TextView tv_custom_dialog_details = (TextView) customD.findViewById(R.id.tv_custom_dialog_details);
        tv_custom_dialog_details.setText(details);
        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customD.dismiss();
            }
        });
        return  customD;
    }

    public Dialog customDialog(Context context, String title, String details){

        Dialog customD = new Dialog(context);
        customD.setContentView(R.layout.custom_dialog);

        Button btn_custom_dialog = (Button) customD.findViewById(R.id.btn_custom_dialog);
        TextView tv_custom_dialog_details = (TextView) customD.findViewById(R.id.tv_custom_dialog_details);
        TextView tv_custom_dialog_title = (TextView) customD.findViewById(R.id.tv_custom_dialog_title);
        tv_custom_dialog_title.setText(title);
        tv_custom_dialog_details.setText(details);
        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customD.dismiss();
            }
        });
        return  customD;
    }
    public Dialog customDialog(Context context, String title, String details, int icon){

        Dialog customD = new Dialog(context);
        customD.setContentView(R.layout.custom_dialog);

        Button btn_custom_dialog = (Button) customD.findViewById(R.id.btn_custom_dialog);
        TextView tv_custom_dialog_details = (TextView) customD.findViewById(R.id.tv_custom_dialog_details);
        ImageView custom_dialog_icon = (ImageView) customD.findViewById(R.id.custom_dialog_icon);
        TextView tv_custom_dialog_title = (TextView) customD.findViewById(R.id.tv_custom_dialog_title);
        custom_dialog_icon.setImageResource(icon);
        tv_custom_dialog_details.setText(details);
        tv_custom_dialog_title.setText(title);

        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customD.dismiss();
            }
        });
        return  customD;
    }
    public Dialog customDialog(Context context, String title, String details, int icon, String buttonTitle){

        Dialog customD = new Dialog(context);
        customD.setContentView(R.layout.custom_dialog);

        Button btn_custom_dialog = (Button) customD.findViewById(R.id.btn_custom_dialog);
        TextView tv_custom_dialog_details = (TextView) customD.findViewById(R.id.tv_custom_dialog_details);
        ImageView custom_dialog_icon = (ImageView) customD.findViewById(R.id.custom_dialog_icon);
        TextView tv_custom_dialog_title = (TextView) customD.findViewById(R.id.tv_custom_dialog_title);
        custom_dialog_icon.setImageResource(icon);
        tv_custom_dialog_details.setText(details);
        tv_custom_dialog_title.setText(title);
        btn_custom_dialog.setText(buttonTitle);

        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customD.dismiss();
            }
        });
        return  customD;
    }
}
