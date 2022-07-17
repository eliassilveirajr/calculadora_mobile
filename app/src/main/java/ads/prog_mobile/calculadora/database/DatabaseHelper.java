package ads.prog_mobile.calculadora.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import ads.prog_mobile.calculadora.R;
import ads.prog_mobile.calculadora.historico.Historico;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "calculadora";
    private static final String TABLE_HISTORICO = "historico";

    private static final String CREATE_TABLE_HISTORICO = "CREATE TABLE "+ TABLE_HISTORICO + "("+
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "operacao VARCHAR(100), " +
            "resultado VARCHAR(30));"; // Primary Key tem que ter _ no SQLite

    private static final String DROP_TABLE_HISTORICO = "DROP TABLE IF EXISTS " + TABLE_HISTORICO;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HISTORICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_HISTORICO);
        onCreate(db);
    }

    // cria tabela
    public long createHistorico (Historico h) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("operacao", h.getOperacao());
        cv.put("resultado", h.getResultado());

        long id = db.insert(TABLE_HISTORICO, null, cv);
        db.close();
        return id;
    }

    // Update para possíveis uso
    public long updateHistorico (Historico h) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("operacao", h.getOperacao());
        cv.put("resultado", h.getResultado());

        long id = db.update(TABLE_HISTORICO, cv,
                "_id = ?", new String[]{String.valueOf(h.getId())});
        db.close();
        return id;
    }

    public long deleteHistorico (Historico h) {
        SQLiteDatabase db = this.getWritableDatabase();


        long id = db.delete(TABLE_HISTORICO,"_id = ?",
                new String[]{String.valueOf(h.getId())});
        db.close();
        return id;
    }

    public void getAllHistorico (Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "operacao", "resultado"};
        Cursor data = db.query(TABLE_HISTORICO, columns, null, null,
                null, null, "id DESC");
        int[] to = {R.id.textViewIdListHistorico, R.id.textViewOperacaoListHistorico, R.id.textViewResultadoListHistorico};

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.historico_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }
}