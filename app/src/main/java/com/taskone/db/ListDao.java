package com.taskone.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.taskone.model.MyDbModel;

import java.util.List;

@Dao
public interface ListDao {
    @Query("SELECT * FROM mydbmodel")
    List<MyDbModel> getAll();

    @Insert
    void insertAll(MyDbModel... mydbmodel);

    @Delete
    void delete(MyDbModel mydbmodel);

    @Query("DELETE FROM mydbmodel")
    public void nukeTable();

}
