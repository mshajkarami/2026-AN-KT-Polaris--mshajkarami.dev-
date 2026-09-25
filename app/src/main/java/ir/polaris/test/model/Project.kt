package ir.polaris.test.model

data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val responsibleMember: String,
    val status: String,
    val github: String?,
    val demo: String?
)
