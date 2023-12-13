package fr.upjv.tonmarmi.ui.model

import fr.upjv.tonmarmi.data.model.RecipeObject
import java.sql.Timestamp

data class RecipeItemUi(
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
    val time: Timestamp
)

fun List<RecipeObject>.toUi():List<RecipeItemUi>{
    return map {
        eachObject -> eachObject.toUi()
    }
}

fun RecipeObject.toUi():RecipeItemUi{
    return RecipeItemUi(
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
        time = time
    )

}


