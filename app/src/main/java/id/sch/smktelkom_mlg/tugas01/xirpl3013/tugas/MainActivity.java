package id.sch.smktelkom_mlg.tugas01.xirpl3013.tugas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    RadioButton rbL, rbP;
    CheckBox cbNL, cbBC, cbOR;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        cbNL = (CheckBox) findViewById(R.id.checkBoxNL);
        cbBC = (CheckBox) findViewById(R.id.checkBoxBC);
        cbOR = (CheckBox) findViewById(R.id.checkBoxOR);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama Anda adalah : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

    private void doClick() {
        {
            String hasil = null;

            if (rbL.isChecked()) {
                hasil = rbL.getText().toString();
            } else if (rbP.isChecked()) {
                hasil = rbP.getText().toString();
            }
            if (hasil == null) {
                tvHasil.setText("Anda belum memilih Jenis Kelamin !!");
            } else {
                tvHasil.setText("Anda adalah seorang : " + hasil);
            }
        }
        {
            String hasil = "Hobi Anda : \n";
            int startlen = hasil.length();
            if (cbNL.isChecked()) hasil += cbNL.getText() + "\n";
            if (cbBC.isChecked()) hasil += cbBC.getText() + "\n";
            if (cbOR.isChecked()) hasil += cbOR.getText() + "\n";

            if (hasil.length() == startlen) hasil += "Anda belum Memilih Hobi !!";

            tvHasil.setText(hasil);
        }
    }
}


