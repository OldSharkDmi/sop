package com.example.baggage_contracts.enums;

public enum BaggageStatusEnum {
    REGISTERED,  // Зарегистрирован
    LOADED_IN_PLANE,      // Загружен на борт
    IN_TRANSIT,  // В пути
    UNLOADED_FROM_PLANE, // Выгружен из самолета
    ISSUED,   // Доставлен
    LOST         // Потерян
}
