package ir.polaris.test.data

import ir.polaris.test.model.CollaborationStep
import ir.polaris.test.model.Project
import ir.polaris.test.model.Responsibility
import ir.polaris.test.model.SkillCategory
import ir.polaris.test.model.TeamMember

object TeamData {

    const val APP_TITLE = "Test"
    const val TEAM_SUBTITLE = "Polaris Team"
    const val POLARIS_EYEBROW = "POLARIS SOFTWARE DEVELOPMENT COMPANY"
    const val HERO_TITLE = "Test — یک تیم، چند تخصص، یک هدف"
    const val HERO_DESCRIPTION =
        "ما گروهی از برنامه‌نویسان و متخصصان فناوری هستیم که با ترکیب مهارت‌ها و تجربه‌های مختلف، برای ساخت یک محصول مشترک کنار هم قرار گرفته‌ایم."

    const val ABOUT_TEST_TITLE = "درباره تیم Test"
    const val ABOUT_TEST_CONTENT =
        "گروه Test مجموعه‌ای از افراد با مهارت‌ها و تجربه‌های مختلف در حوزه فناوری است که در چارچوب پروژه Polaris با یکدیگر همکاری می‌کنند. هدف ما شناخت توانمندی‌های اعضا، تقسیم صحیح مسئولیت‌ها و ایجاد یک خروجی کامل از طریق همکاری تیمی است."

    const val ABOUT_POLARIS_EYEBROW = "ABOUT POLARIS"
    const val ABOUT_POLARIS_HEADLINE = "ما فقط کد نمی‌زنیم؛ محصول می‌سازیم."
    const val ABOUT_POLARIS_DESC_1 =
        "پولاریس یک تیم نرم‌افزاری است که روی همکاری، کیفیت کد، طراحی درست و ساخت محصولاتی تمرکز دارد که واقعاً قابل استفاده باشند."
    const val ABOUT_POLARIS_DESC_2 =
        "این پروژه بخشی از فرآیند ارزیابی Polaris است که در آن علاوه بر توانایی فنی، همکاری، مسئولیت‌پذیری، ارتباط و انجام پروژه گروهی مورد توجه قرار می‌گیرد."

    const val CONTACT_EYEBROW = "GET IN TOUCH"
    const val CONTACT_TITLE = "پروژه‌ای داری؟ با ما صحبت کن."
    const val CONTACT_EMAIL = "hello@polaris.dev"

    const val REPRESENTATIVE_TITLE = "نماینده گروه"
    const val REPRESENTATIVE_ROLE = "Team Representative"
    const val REPRESENTATIVE_NAME = "نام نماینده (منتخب تیم)"
    const val REPRESENTATIVE_DESCRIPTION =
        "نماینده مسئول هماهنگی اعضا، پیگیری وظایف و ارتباط با مدیریت Polaris است."

    // Team members matching the reference design and easily editable for final assessment
    val teamMembers: List<TeamMember> = listOf(
        TeamMember(
            id = "member-01",
            number = "01",
            name = "آرمین",
            englishName = "ARMIN",
            role = "Frontend Developer",
            bio = "توسعه رابط‌های مدرن، ریسپانسیو و سریع با تمرکز روی تجربه کاربری.",
            skills = listOf("HTML", "CSS", "JavaScript", "Responsive Design"),
            technologies = listOf("JavaScript", "CSS", "HTML", "TypeScript"),
            projects = listOf("پورتال وب پولاریس", "دیزاین سیستم وب"),
            github = "https://github.com/polaris-test",
            linkedin = "https://linkedin.com",
            telegram = "https://t.me",
            isRepresentative = false
        ),
        TeamMember(
            id = "member-02",
            number = "02",
            name = "ندا",
            englishName = "NEDA",
            role = "Backend Developer",
            bio = "طراحی API، معماری سمت سرور و پیاده‌سازی سرویس‌های قابل توسعه.",
            skills = listOf("Node.js", "Python", "API", "Microservices"),
            technologies = listOf("Node.js", "Python", "API", "PostgreSQL"),
            projects = listOf("سرویس احراز هویت", "میکروسرویس‌های ارزیابی"),
            github = "https://github.com/polaris-test",
            linkedin = "https://linkedin.com",
            telegram = "https://t.me",
            isRepresentative = false
        ),
        TeamMember(
            id = "member-03",
            number = "03",
            name = "حسین",
            englishName = "HOSSEIN",
            role = "Fullstack Developer",
            bio = "اتصال فرانت‌اند و بک‌اند و ساخت اپلیکیشن‌های کامل با معماری تمیز.",
            skills = listOf("React", "Node.js", "SQL", "Clean Architecture"),
            technologies = listOf("React", "Node.js", "SQL", "Next.js"),
            projects = listOf("داشبورد مدیریت یکپارچه", "ماژول همگام‌سازی داده"),
            github = "https://github.com/polaris-test",
            linkedin = "https://linkedin.com",
            telegram = "https://t.me",
            isRepresentative = true
        ),
        TeamMember(
            id = "member-04",
            number = "04",
            name = "سارینا",
            englishName = "SARINA",
            role = "UI/UX & Frontend",
            bio = "طراحی تجربه‌های کاربری ساده و زیبا و تبدیل طراحی به رابط واقعی.",
            skills = listOf("Figma", "UI/UX Design", "React", "Design Systems"),
            technologies = listOf("Figma", "UI", "React", "Tailwind"),
            projects = listOf("سیستم طراحی پولاریس", "پروتوتایپ اپلیکیشن موبایل"),
            github = "https://github.com/polaris-test",
            linkedin = "https://linkedin.com",
            telegram = "https://t.me",
            isRepresentative = false
        ),
        TeamMember(
            id = "member-05",
            number = "05",
            name = "علی",
            englishName = "ALI",
            role = "DevOps & Infrastructure",
            bio = "مدیریت زیرساخت، استقرار پروژه‌ها و پایدار نگه‌داشتن سرویس‌ها.",
            skills = listOf("Linux", "Docker", "CI/CD", "Cloud Architecture"),
            technologies = listOf("CI/CD", "Docker", "Linux", "Kubernetes"),
            projects = listOf("پایپ‌لاین استقرار پیوسته", "پایش و مانیتورینگ سلامت سرویس"),
            github = "https://github.com/polaris-test",
            linkedin = "https://linkedin.com",
            telegram = "https://t.me",
            isRepresentative = false
        )
    )

    // Skills & Technologies categorized per prompt specifications
    val skillCategories: List<SkillCategory> = listOf(
        SkillCategory(
            title = "موبایل",
            englishTitle = "Mobile",
            skills = listOf("Android", "Kotlin", "Kotlin Multiplatform", "Jetpack Compose", "Flutter")
        ),
        SkillCategory(
            title = "فرانت‌اند و وب",
            englishTitle = "Web",
            skills = listOf("HTML5", "CSS3", "JavaScript", "TypeScript", "React", "Next.js")
        ),
        SkillCategory(
            title = "بک‌اند و سرویس‌ها",
            englishTitle = "Backend",
            skills = listOf("Spring Boot", "Ktor", "Node.js", "Python", "REST API", "SQL", "PostgreSQL")
        ),
        SkillCategory(
            title = "ابزارها و زیرساخت",
            englishTitle = "Tools & DevOps",
            skills = listOf("Git", "GitHub", "Docker", "Linux", "CI/CD Pipelines", "Figma")
        )
    )

    // Projects representing the team's collaborative output
    val projects: List<Project> = listOf(
        Project(
            title = "اپلیکیشن نیتیو اندروید Test",
            description = "پیاده‌سازی نسخه نیتیو اپلیکیشن پورتفولیو و ارزیابی تیم در چارچوب مسابقات استخدامی Polaris با جت‌پک کامپوز و متریال ۳.",
            technologies = listOf("Kotlin", "Jetpack Compose", "Material 3", "Coroutines"),
            responsibleMember = "تیم توسعه اندروید",
            status = "تکمیل شده",
            github = "https://github.com/polaris-test/android-app",
            demo = null
        ),
        Project(
            title = "سامانه ارزیابی و همکاری تیمی",
            description = "سرویس یکپارچه توزیع مسئولیت‌ها، ترکینگ گام‌های توسعه و گزارش‌دهی پیشرفت تسک‌های ارزیابی.",
            technologies = listOf("Node.js", "REST API", "PostgreSQL", "Docker"),
            responsibleMember = "تیم بک‌اند",
            status = "در حال توسعه",
            github = "https://github.com/polaris-test/team-service",
            demo = null
        ),
        Project(
            title = "سیستم طراحی و پروتوتایپ پولاریس",
            description = "مجموعه کامپوننت‌های بصری، توکن‌های طراحی، تایپوگرافی لوکس دارک و مستندات تجربه کاربری.",
            technologies = listOf("Figma", "Design Tokens", "UI/UX"),
            responsibleMember = "تیم طراحی رابط کاربری",
            status = "تکمیل شده",
            github = null,
            demo = "https://polaris.dev"
        ),
        Project(
            title = "پایپ‌لاین استقرار خودکار و تست کیفی",
            description = "کانفیگ خودکار بیلد، تست‌های محلی و استقرار مداوم برای تضمین کیفیت خروجی اعضای تیم.",
            technologies = listOf("CI/CD", "GitHub Actions", "Docker", "Linux"),
            responsibleMember = "تیم DevOps",
            status = "فعال",
            github = "https://github.com/polaris-test/devops-config",
            demo = null
        )
    )

    // Responsibilities division evaluated in the Polaris assessment
    val responsibilities: List<Responsibility> = listOf(
        Responsibility(
            title = "مدیریت پروژه و هماهنگی (Project Management)",
            responsibleMember = "نماینده گروه",
            status = "فعال",
            description = "برنامه‌ریزی جلسات هماهنگی، اولویت‌بندی نیازمندی‌ها، پیگیری پیشرفت اعضا و ارتباط با داوران Polaris."
        ),
        Responsibility(
            title = "طراحی رابط و تجربه کاربری (UI/UX Design)",
            responsibleMember = "سارینا (طراح UI/UX)",
            status = "تکمیل شده",
            description = "انطباق بصری موبایل با سایت مرجع، انتخاب پالت رنگی دارک و تایپوگرافی لوکس، و ساختاردهی کامپوننت‌ها."
        ),
        Responsibility(
            title = "توسعه کلاینت اندروید (Android Development)",
            responsibleMember = "آرمین و حسین",
            status = "تکمیل شده",
            description = "پیاده‌سازی نیتیو با Jetpack Compose، رعایت معماری تمیز، پشتیبانی کامل RTL و انیمیشن‌های روان."
        ),
        Responsibility(
            title = "معماری بک‌اند و وب (Backend & Web Development)",
            responsibleMember = "ندا و حسین",
            status = "در حال پیشرفت",
            description = "طراحی ساختار داده‌ها، مدل‌های مشترک، اندپوینت‌های ارتباطی و استانداردسازی ارتباط لایه‌ها."
        ),
        Responsibility(
            title = "تست و اعتبارسنجی کیفی (Testing & QA)",
            responsibleMember = "تمامی اعضای تیم",
            status = "فعال",
            description = "اجرای تست‌های کارکردی، بررسی خوانایی کدهای کاتلین، سازگاری روی ابعاد مختلف صفحه و اطمینان از عملکرد آفلاین."
        ),
        Responsibility(
            title = "مستندسازی و تحویل پروژه (Documentation & Delivery)",
            responsibleMember = "علی و نماینده گروه",
            status = "فعال",
            description = "نگارش ساختار ریپازیتوری، راهنمای راه‌اندازی، ارائه نحوه تقسیم وظایف و آمادگی برای ارزیابی نهایی."
        )
    )

    // 7 Collaboration Steps communicating teamwork focus
    val collaborationSteps: List<CollaborationStep> = listOf(
        CollaborationStep(
            stepNumber = 1,
            title = "شناخت اعضا",
            subtitle = "Team Discovery",
            description = "بررسی مهارت‌ها، سوابق و حوزه‌های علاقه‌مندی تک‌تک اعضای تیم برای توزیع بهینه تسک‌ها."
        ),
        CollaborationStep(
            stepNumber = 2,
            title = "برنامه‌ریزی",
            subtitle = "Planning & Scope",
            description = "تعیین چشم‌انداز محصول، بررسی دقیق تصویر مرجع وب‌سایت و زمان‌بندی مراحل اجرای ارزیابی."
        ),
        CollaborationStep(
            stepNumber = 3,
            title = "تقسیم وظایف",
            subtitle = "Task Allocation",
            description = "واگذاری شفاف مسئولیت‌ها (مدیریت، طراحی، اندروید، بک‌اند، دوآپس) بر اساس نقاط قوت هر عضو."
        ),
        CollaborationStep(
            stepNumber = 4,
            title = "توسعه",
            subtitle = "Agile Development",
            description = "پیاده‌سازی گام‌به‌گام با معماری تمیز، کامپوننت‌های ماژولار و کدهای مدرن و بدون باگ."
        ),
        CollaborationStep(
            stepNumber = 5,
            title = "تست و بازبینی",
            subtitle = "Testing & Review",
            description = "کد ریویو بین اعضا، تست ابعاد و ریسپانسیو بودن در دیوایس‌های مختلف، و رفع ایرادات جزئی."
        ),
        CollaborationStep(
            stepNumber = 6,
            title = "مستندسازی",
            subtitle = "Documentation",
            description = "آماده‌سازی راهنماها، کامنت‌های ساختاریافته و تدوین گزارش کار تیمی برای تیم ارزیابی Polaris."
        ),
        CollaborationStep(
            stepNumber = 7,
            title = "تحویل",
            subtitle = "Final Delivery",
            description = "ارائه نسخه نهایی اپلیکیشن نیتیو، نمایش هماهنگی تیمی و خروجی باکیفیت به عنوان تیم Test."
        )
    )
}
