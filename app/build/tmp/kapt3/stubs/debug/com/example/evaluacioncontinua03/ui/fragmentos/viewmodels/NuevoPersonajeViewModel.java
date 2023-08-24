package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/evaluacioncontinua03/ui/fragmentos/viewmodels/NuevoPersonajeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_listaNuevos", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/evaluacioncontinua03/model/NuevoPersonaje;", "listaNuevos", "Landroidx/lifecycle/LiveData;", "getListaNuevos", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/example/evaluacioncontinua03/data/repository/PersonajeRepository;", "agregarNuevoPersonaje", "", "nuevopersonaje", "obtenerNuevosPersonajes", "app_debug"})
public final class NuevoPersonajeViewModel extends androidx.lifecycle.ViewModel {
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacioncontinua03.model.NuevoPersonaje>> _listaNuevos;
    private final com.example.evaluacioncontinua03.data.repository.PersonajeRepository repository = null;
    
    public NuevoPersonajeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.evaluacioncontinua03.model.NuevoPersonaje>> getListaNuevos() {
        return null;
    }
    
    public final void obtenerNuevosPersonajes() {
    }
    
    public final void agregarNuevoPersonaje(@org.jetbrains.annotations.NotNull()
    com.example.evaluacioncontinua03.model.NuevoPersonaje nuevopersonaje) {
    }
}