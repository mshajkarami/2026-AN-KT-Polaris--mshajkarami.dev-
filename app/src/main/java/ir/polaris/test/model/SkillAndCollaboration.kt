package ir.polaris.test.model

data class CollaborationStep(
    val stepNumber: Int,
    val title: String,
    val subtitle: String,
    val description: String
)

data class SkillCategory(
    val title: String,
    val englishTitle: String,
    val skills: List<String>
)
