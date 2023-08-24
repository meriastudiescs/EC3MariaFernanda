package com.example.evaluacioncontinua03.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/evaluacioncontinua03/data/repository/PersonajeRepository;", "", "db", "Lcom/example/evaluacioncontinua03/data/db/PersonajeDatabase;", "(Lcom/example/evaluacioncontinua03/data/db/PersonajeDatabase;)V", "dao", "Lcom/example/evaluacioncontinua03/data/db/PersonajeDao;", "getDb", "()Lcom/example/evaluacioncontinua03/data/db/PersonajeDatabase;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "addPersonajeToFavorites", "", "personaje", "Lcom/example/evaluacioncontinua03/model/Personaje;", "(Lcom/example/evaluacioncontinua03/model/Personaje;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "agregarPersonajeNuevo", "", "Lcom/example/evaluacioncontinua03/model/NuevoPersonaje;", "(Lcom/example/evaluacioncontinua03/model/NuevoPersonaje;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNuevoFromFirestore", "obtenerPersonaje", "Lcom/example/evaluacioncontinua03/data/PersonajeServiceResult;", "app_debug"})
public final class PersonajeRepository {
    @org.jetbrains.annotations.Nullable()
    private final com.example.evaluacioncontinua03.data.db.PersonajeDatabase db = null;
    private final com.example.evaluacioncontinua03.data.db.PersonajeDao dao = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    
    public PersonajeRepository() {
        super();
    }
    
    public PersonajeRepository(@org.jetbrains.annotations.Nullable()
    com.example.evaluacioncontinua03.data.db.PersonajeDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.evaluacioncontinua03.data.db.PersonajeDatabase getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerPersonaje(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.evaluacioncontinua03.data.PersonajeServiceResult<java.util.List<com.example.evaluacioncontinua03.model.Personaje>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFavorites(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.evaluacioncontinua03.model.Personaje>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addPersonajeToFavorites(@org.jetbrains.annotations.NotNull()
    com.example.evaluacioncontinua03.model.Personaje personaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNuevoFromFirestore(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.evaluacioncontinua03.model.NuevoPersonaje>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object agregarPersonajeNuevo(@org.jetbrains.annotations.NotNull()
    com.example.evaluacioncontinua03.model.NuevoPersonaje personaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}