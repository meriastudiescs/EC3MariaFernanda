package com.example.evaluacioncontinua03.data.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/example/evaluacioncontinua03/data/db/PersonajeDao;", "", "addPersonajeToFavorite", "", "personaje", "Lcom/example/evaluacioncontinua03/model/PersonajeEntity;", "(Lcom/example/evaluacioncontinua03/model/PersonajeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "", "app_debug"})
public abstract interface PersonajeDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from personaje")
    public abstract java.util.List<com.example.evaluacioncontinua03.model.PersonajeEntity> getFavorites();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object addPersonajeToFavorite(@org.jetbrains.annotations.NotNull()
    com.example.evaluacioncontinua03.model.PersonajeEntity personaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}