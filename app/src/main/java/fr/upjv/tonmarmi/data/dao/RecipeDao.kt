package fr.upjv.tonmarmi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.tonmarmi.data.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe_table ORDER BY time ASC")
    fun selectAll(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe_table WHERE id = :recipeId")
    fun selectRecipeById(recipeId: Int): Flow<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insert(recipeEntity: RecipeEntity)

    @Query("DELETE FROM recipe_table")
    fun deleteAll()
}