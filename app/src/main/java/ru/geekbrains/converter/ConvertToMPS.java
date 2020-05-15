package ru.geekbrains.converter;

// Реализация интерфейса ConvertTo.
// Перевод в м/сек из км/час.
class ConvertToMPS implements ConvertTo {
    @Override
    public float Do(float sourceValue){
        return (float)(sourceValue / 3.6); // Вычисление м/сек
    }
}
