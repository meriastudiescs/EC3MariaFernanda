package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\u0011R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/evaluacioncontinua03/ui/fragmentos/viewmodels/PersonajeFavoriteViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_favorites", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/evaluacioncontinua03/model/Personaje;", "favorites", "Landroidx/lifecycle/LiveData;", "getFavorites", "()Landroidx/lifecycle/LiveData;", "setFavorites", "(Landroidx/lifecycle/LiveData;)V", "repository", "Lcom/example/evaluacioncontinua03/data/repository/PersonajeRepository;", "", "app_debug"})
public final class PersonajeFavoriteViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.example.evaluacioncontinua03.data.repository.PersonajeRepository repository = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacioncontinua03.model.Personaje>> _favorites;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.example.evaluacioncontinua03.model.Personaje>> favorites;
    
    public PersonajeFavoriteViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.evaluacioncontinua03.model.Personaje>> getFavorites() {
        return null;
    }
    
    public final void setFavorites(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.example.evaluacioncontinua03.model.Personaje>> p0) {
    }
    
    public final void getFavorites() {
    }
}