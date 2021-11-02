package ru.geekbrains.converter;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ConvertActivity extends AppCompatActivity {

    private EditText sourceText;    // Элемент с входным значением, которое надо сконвертировать
    private EditText destText;      // Элемент с результирующим значением
    private Button button;          // Кнопка конвертации
    private TextView inText;        // Элемент с наименованием
    private TextView outText;       // Элемент с наименованием

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        sourceText = findViewById(R.id.celsiusValue);
        destText = findViewById(R.id.fahrenheitValue);
        button = findViewById(R.id.toMPSButton);
        inText = findViewById(R.id.celsiusLabel);
        outText = findViewById(R.id.fahrenheitLabel);
    }

    // обработка нажатия
    public void onToMPSClick(View view) {
        // получить входное значение
        if(!sourceText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(sourceText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertMPS
            float destValue = converter.Convert(new ConvertToMPS()).GetResult();
            // записать результат в элемент
            destText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else if(!destText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(destText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertToKPH
            float destValue = converter.Convert(new ConvertToKPH()).GetResult();
            // записать результат в элемент
            sourceText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else {
            inText.setText(R.string.mph);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.toMPHButton);
            button.setVisibility(View.VISIBLE);
        }
    }

    // обработка нажатия
    public void onToMPHClick(View view) {
        // получить входное значение
        if(!sourceText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(sourceText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertMPS
            float destValue = converter.Convert(new ConvertToMile()).GetResult();
            // записать результат в элемент
            destText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else if(!destText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(destText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertToKPH
            float destValue = converter.Convert(new ConvertToKM()).GetResult();
            // записать результат в элемент
            sourceText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else {
            inText.setText(R.string.celsius);
            outText.setText(R.string.fahrenheit);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.toFahrengeitButton);
            button.setVisibility(View.VISIBLE);
        }
    }

    // обработка нажатия
    public void onToFahrenheit(View view) {
        // получить входное значение
        if(!sourceText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(sourceText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertMPS
            float destValue = converter.Convert(new ConvertToFahrenheit()).GetResult();
            // записать результат в элемент
            destText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else if(!destText.getText().toString().equals("")) {
            float sourceValue = Float.parseFloat(destText.getText().toString());
            // инстанцировать конвертер
            Converter converter = new Converter(sourceValue);
            // преобразовать, обратите внимание на параметр ConvertToKPH
            float destValue = converter.Convert(new ConvertToCelsius()).GetResult();
            // записать результат в элемент
            sourceText.setText(String.format(Locale.ENGLISH,"%.02f", destValue));
        } else {
            inText.setText(R.string.kph);
            outText.setText(R.string.mph);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.toMPSButton);
            button.setVisibility(View.VISIBLE);
        }
    }
}
