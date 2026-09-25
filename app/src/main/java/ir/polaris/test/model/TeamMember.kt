package ir.polaris.test.model

import androidx.annotation.DrawableRes

data class TeamMember(
    val id: String,
    val number: String,
    val name: String,
    val englishName: String,
    val role: String,
    val bio: String,
    val skills: List<String>,
    val technologies: List<String>,
    val projects: List<String>,
    val github: String?,
    val linkedin: String?,
    val telegram: String?,
    val isRepresentative: Boolean = false,
    @get:DrawableRes val photoRes: Int? = null
)

