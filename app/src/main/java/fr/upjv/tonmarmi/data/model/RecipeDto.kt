package fr.upjv.tonmarmi.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class RecipeDto(

    @Expose
    @SerializedName("idMeal")
    val id : Int,

    @Expose
    @SerializedName("strMeal")
    val name : String?,

    @Expose
    @SerializedName("strCategory")
    val category : String,

    @Expose
    @SerializedName("strArea")
    val area : String?,

    @Expose
    @SerializedName("strInstructions")
    val instructions : String?,

    @Expose
    @SerializedName("strMealThumb")
    val image : String?,

    @Expose
    @SerializedName("strTags")
    val tags : String?,

    @Expose
    @SerializedName("strYoutube")
    val youtube : String?,

    @Expose
    @SerializedName("strIngredient1")
    val ingredient1 : String,

    @Expose
    @SerializedName("strIngredient2")
    val ingredient2 : String,

    @Expose
    @SerializedName("strIngredient3")
    val ingredient3 : String,

    @Expose
    @SerializedName("strIngredient4")
    val ingredient4 : String,

    @Expose
    @SerializedName("strIngredient5")
    val ingredient5 : String,

    @Expose
    @SerializedName("strIngredient6")
    val ingredient6 : String,

    @Expose
    @SerializedName("strIngredient7")
    val ingredient7 : String,

    @Expose
    @SerializedName("strIngredient8")
    val ingredient8 : String,

    @Expose
    @SerializedName("strIngredient9")
    val ingredient9 : String,

    @Expose
    @SerializedName("strIngredient10")
    val ingredient10 : String,

    @Expose
    @SerializedName("strIngredient11")
    val ingredient11 : String,

    @Expose
    @SerializedName("strIngredient12")
    val ingredient12 : String,

    @Expose
    @SerializedName("strIngredient13")
    val ingredient13 : String,

    @Expose
    @SerializedName("strIngredient14")
    val ingredient14 : String,

    @Expose
    @SerializedName("strIngredient15")
    val ingredient15 : String,

    @Expose
    @SerializedName("strIngredient16")
    val ingredient16 : String,

    @Expose
    @SerializedName("strIngredient17")
    val ingredient17 : String,

    @Expose
    @SerializedName("strIngredient18")
    val ingredient18 : String,

    @Expose
    @SerializedName("strIngredient19")
    val ingredient19 : String,

    @Expose
    @SerializedName("strIngredient20")
    val ingredient20 : String,

    @Expose
    @SerializedName("strMeasure1")
    val measure1 : String,

    @Expose
    @SerializedName("strMeasure2")
    val measure2 : String,

    @Expose
    @SerializedName("strMeasure3")
    val measure3 : String,

    @Expose
    @SerializedName("strMeasure4")
    val measure4 : String,

    @Expose
    @SerializedName("strMeasure5")
    val measure5 : String,

    @Expose
    @SerializedName("strMeasure6")
    val measure6 : String,

    @Expose
    @SerializedName("strMeasure7")
    val measure7 : String,

    @Expose
    @SerializedName("strMeasure8")
    val measure8 : String,

    @Expose
    @SerializedName("strMeasure9")
    val measure9 : String,

    @Expose
    @SerializedName("strMeasure10")
    val measure10 : String,

    @Expose
    @SerializedName("strMeasure11")
    val measure11 : String,

    @Expose
    @SerializedName("strMeasure12")
    val measure12 : String,

    @Expose
    @SerializedName("strMeasure13")
    val measure13 : String,

    @Expose
    @SerializedName("strMeasure14")
    val measure14 : String,

    @Expose
    @SerializedName("strMeasure15")
    val measure15 : String,

    @Expose
    @SerializedName("strMeasure16")
    val measure16 : String,

    @Expose
    @SerializedName("strMeasure17")
    val measure17 : String,

    @Expose
    @SerializedName("strMeasure18")
    val measure18 : String,

    @Expose
    @SerializedName("strMeasure19")
    val measure19 : String,

    @Expose
    @SerializedName("strMeasure20")
    val measure20 : String,

    @Expose
    @SerializedName("strSource")
    val source : String,
)

data class Meal(
    @SerializedName("meals")
    val meal: List<RecipeDto>
)

fun RecipeDto.toRoom(): RecipeEntity {
    return RecipeEntity(
            id = id,
            name = name,
            category = mutableListOf(category),
            //category = category?.split(","),
            area = area,
            image = image,
            tags = tags,
            youtube = youtube,
            source = source,
            instructions = instructions,
            ingredients = mutableListOf(
                ingredient1,
                ingredient2,
                ingredient3,
                ingredient4,
                ingredient5,
                ingredient6,
                ingredient7,
                ingredient8,
                ingredient9,
                ingredient10,
                ingredient11,
                ingredient12,
                ingredient13,
                ingredient14,
                ingredient15,
                ingredient16,
                ingredient17,
                ingredient18,
                ingredient19,
                ingredient20,
                ).filter { it != "" },
            measures = mutableListOf(
                measure1,
                measure2,
                measure3,
                measure4,
                measure5,
                measure6,
                measure7,
                measure8,
                measure9,
                measure11,
                measure12,
                measure13,
                measure14,
                measure15,
                measure16,
                measure17,
                measure18,
                measure19,
                measure20,
            ).filter { it != "" },
        time = Timestamp(System.currentTimeMillis())
        )
}
