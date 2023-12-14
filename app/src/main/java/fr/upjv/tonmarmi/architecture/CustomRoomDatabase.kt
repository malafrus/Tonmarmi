package fr.upjv.tonmarmi.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.upjv.tonmarmi.data.dao.RecipeDao
import fr.upjv.tonmarmi.data.model.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun RecipeDao(): RecipeDao
}
