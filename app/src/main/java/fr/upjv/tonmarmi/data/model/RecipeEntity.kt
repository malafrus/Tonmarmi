package fr.upjv.tonmarmi.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "recipe_table")
data class RecipeEntity(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "category")
    val category: List<String>?,

    @ColumnInfo(name = "area")
    val area: String?,

    @ColumnInfo(name = "image")
    val image: String?,

    @ColumnInfo(name = "tags")
    val tags: String?,

    @ColumnInfo(name = "youtube")
    val youtube: String?,

    @ColumnInfo(name = "source")
    val source: String?,

    @ColumnInfo(name = "instructions")
    val instructions: String?,

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,

    @ColumnInfo(name = "measures")
    val measures: List<String>,

    @ColumnInfo(name = "time")
    val time: Timestamp,
    )
