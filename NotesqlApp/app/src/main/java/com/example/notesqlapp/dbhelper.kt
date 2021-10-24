package com.example.notesqlapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbhelper(context: Context) : SQLiteOpenHelper(context, "note.db", null, 1) {
    var sqlitedb: SQLiteDatabase =writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {

        if (db != null) {
            db.execSQL("create table tbl_note (Note text) ")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun saveNote(n:String): Long {

        val cv = ContentValues()
        cv.put("Note",n)
        var status = sqlitedb.insert("tbl_note",null,cv)
        return status

    }
}