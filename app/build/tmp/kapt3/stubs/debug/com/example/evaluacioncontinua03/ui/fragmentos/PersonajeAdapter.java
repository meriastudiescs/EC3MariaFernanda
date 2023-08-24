package com.example.evaluacioncontinua03.ui.fragmentos;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/example/evaluacioncontinua03/ui/fragmentos/PersonajeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/evaluacioncontinua03/ui/fragmentos/PersonajeAdapter$ViewHolder;", "context", "Landroid/content/Context;", "listaPersonajes", "", "Lcom/example/evaluacioncontinua03/model/Personaje;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getListaPersonajes", "()Ljava/util/List;", "setListaPersonajes", "(Ljava/util/List;)V", "getItemCount", "", "mostrarFrase", "", "personaje", "", "imagen", "frase", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class PersonajeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.evaluacioncontinua03.ui.fragmentos.PersonajeAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.evaluacioncontinua03.model.Personaje> listaPersonajes;
    
    public PersonajeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.evaluacioncontinua03.model.Personaje> listaPersonajes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.evaluacioncontinua03.model.Personaje> getListaPersonajes() {
        return null;
    }
    
    public final void setListaPersonajes(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.evaluacioncontinua03.model.Personaje> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.evaluacioncontinua03.ui.fragmentos.PersonajeAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.evaluacioncontinua03.ui.fragmentos.PersonajeAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void mostrarFrase(@org.jetbrains.annotations.NotNull()
    java.lang.String personaje, @org.jetbrains.annotations.NotNull()
    java.lang.String imagen, @org.jetbrains.annotations.NotNull()
    java.lang.String frase, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/evaluacioncontinua03/ui/fragmentos/PersonajeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "cvPersonaje", "Landroidx/cardview/widget/CardView;", "getCvPersonaje", "()Landroidx/cardview/widget/CardView;", "ivPersonaje", "Landroid/widget/ImageView;", "getIvPersonaje", "()Landroid/widget/ImageView;", "tvPersonaje", "Landroid/widget/TextView;", "getTvPersonaje", "()Landroid/widget/TextView;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final androidx.cardview.widget.CardView cvPersonaje = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ivPersonaje = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPersonaje = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View item) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.cardview.widget.CardView getCvPersonaje() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvPersonaje() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPersonaje() {
            return null;
        }
    }
}