package fr.upjv.tonmarmi.data.model

import java.sql.Timestamp

data class RecipeObject(
    val id : Int,
    val name : String?,
    val category : List<String>?,
    val area : String?,
    val image : String?,
    val tags : String?,
    val youtube : String?,
    val source : String?,
    val instructions : String?,
    val ingredients : List<String>,
    val measures: List<String>,
    val time: Timestamp,
)

fun List<RecipeEntity>.toDomain():List<RecipeObject>{
    return map{eachEntity -> eachEntity.toDomain()
    }
}

fun RecipeEntity.toDomain():RecipeObject{
    return RecipeObject(
        id = id,
        name = name,
        category = category,
        area = area,
        image = image,
        tags = tags,
        youtube = youtube,
        source = source,
        instructions = instructions,
        ingredients = ingredients,
        measures = measures,
        time = time,
    )
}
