package ru.geekbrains.converter;

// Реализация интерфейса ConvertTo.
// Перевод в км/час из м/сек.
class ConvertToKPH implements ConvertTo {
    @Override
    public float Do(float sourceValue){
        return (float)(sourceValue * 3.6); // Вычисление км/час
    }
}
