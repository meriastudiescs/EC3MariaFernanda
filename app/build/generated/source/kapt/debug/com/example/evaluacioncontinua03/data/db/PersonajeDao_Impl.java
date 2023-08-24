package com.example.evaluacioncontinua03.data.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.evaluacioncontinua03.model.PersonajeEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PersonajeDao_Impl implements PersonajeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PersonajeEntity> __insertionAdapterOfPersonajeEntity;

  public PersonajeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPersonajeEntity = new EntityInsertionAdapter<PersonajeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `personaje` (`id`,`frase`,`personaje`,`por`,`imagen`,`isFavorite`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PersonajeEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFrase() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFrase());
        }
        if (value.getPersonaje() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPersonaje());
        }
        if (value.getPor() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPor());
        }
        if (value.getImagen() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImagen());
        }
        final int _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
  }

  @Override
  public Object addPersonajeToFavorite(final PersonajeEntity personaje,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPersonajeEntity.insert(personaje);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<PersonajeEntity> getFavorites() {
    final String _sql = "Select * from personaje";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFrase = CursorUtil.getColumnIndexOrThrow(_cursor, "frase");
      final int _cursorIndexOfPersonaje = CursorUtil.getColumnIndexOrThrow(_cursor, "personaje");
      final int _cursorIndexOfPor = CursorUtil.getColumnIndexOrThrow(_cursor, "por");
      final int _cursorIndexOfImagen = CursorUtil.getColumnIndexOrThrow(_cursor, "imagen");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final List<PersonajeEntity> _result = new ArrayList<PersonajeEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PersonajeEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpFrase;
        if (_cursor.isNull(_cursorIndexOfFrase)) {
          _tmpFrase = null;
        } else {
          _tmpFrase = _cursor.getString(_cursorIndexOfFrase);
        }
        final String _tmpPersonaje;
        if (_cursor.isNull(_cursorIndexOfPersonaje)) {
          _tmpPersonaje = null;
        } else {
          _tmpPersonaje = _cursor.getString(_cursorIndexOfPersonaje);
        }
        final String _tmpPor;
        if (_cursor.isNull(_cursorIndexOfPor)) {
          _tmpPor = null;
        } else {
          _tmpPor = _cursor.getString(_cursorIndexOfPor);
        }
        final String _tmpImagen;
        if (_cursor.isNull(_cursorIndexOfImagen)) {
          _tmpImagen = null;
        } else {
          _tmpImagen = _cursor.getString(_cursorIndexOfImagen);
        }
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new PersonajeEntity(_tmpId,_tmpFrase,_tmpPersonaje,_tmpPor,_tmpImagen,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
