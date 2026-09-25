package ir.polaris.test.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.data.TeamData
import ir.polaris.test.model.TeamMember
import ir.polaris.test.ui.components.CollaborationTimeline
import ir.polaris.test.ui.components.MemberCard
import ir.polaris.test.ui.components.MemberDetailDialog
import ir.polaris.test.ui.components.PolarisAboutSection
import ir.polaris.test.ui.components.PolarisContactSection
import ir.polaris.test.ui.components.PolarisFooter
import ir.polaris.test.ui.components.PolarisHeader
import ir.polaris.test.ui.components.PolarisHero
import ir.polaris.test.ui.components.ProjectCard
import ir.polaris.test.ui.components.ResponsibilityCard
import ir.polaris.test.ui.components.SkillSection
import ir.polaris.test.ui.components.TeamRepresentativeCard
import ir.polaris.test.ui.theme.PolarisBackground
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary
import kotlinx.coroutines.launch

@Composable
fun MainPortfolioScreen() {
    // Enforce RTL layout for Persian UI per requirement 5
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        var selectedMember by remember { mutableStateOf<TeamMember?>(null) }
        var currentSection by remember { mutableStateOf("hero") }

        // Section indices in the LazyColumn for smooth scrolling
        val heroIndex = 0
        val aboutIndex = 1
        val teamIndex = 2
        val representativeIndex = 3
        val skillsIndex = 4
        val projectsIndex = 5
        val responsibilitiesIndex = 6
        val processIndex = 7
        val contactIndex = 8
        val footerIndex = 9

        fun scrollToSection(sectionKey: String) {
            currentSection = sectionKey
            coroutineScope.launch {
                val targetIndex = when (sectionKey) {
                    "hero" -> heroIndex
                    "about" -> aboutIndex
                    "team" -> teamIndex
                    "representative" -> representativeIndex
                    "skills" -> skillsIndex
                    "projects" -> projectsIndex
                    "responsibilities" -> responsibilitiesIndex
                    "process" -> processIndex
                    "contact" -> contactIndex
                    else -> heroIndex
                }
                listState.animateScrollToItem(targetIndex)
            }
        }

        val showScrollToTop by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 1 }
        }

        Scaffold(
            topBar = {
                PolarisHeader(
                    selectedSection = currentSection,
                    onSectionClick = { sectionKey -> scrollToSection(sectionKey) }
                )
            },
            floatingActionButton = {
                AnimatedVisibility(
                    visible = showScrollToTop,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF1B1C24))
                            .border(1.dp, PolarisGold, CircleShape)
                            .clickable {
                                coroutineScope.launch {
                                    listState.animateScrollToItem(0)
                                }
                            }
                            .testTag("scroll_to_top_button"),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "بازگشت به بالا",
                            tint = PolarisGoldBright
                        )
                    }
                }
            },
            containerColor = PolarisBackground
        ) { paddingValues ->
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PolarisBackground)
                    .testTag("portfolio_scroll_container")
            ) {
                // 1. HERO SECTION
                item {
                    PolarisHero(
                        onExploreTeamClick = { scrollToSection("team") },
                        onProjectsClick = { scrollToSection("projects") }
                    )
                }

                // 2. ABOUT TEST & ABOUT POLARIS
                item {
                    PolarisAboutSection()
                }

                // 3. OUR TEAM MEMBERS (Exact recreation of the reference image)
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        // Section Header matching reference image:
                        // "OUR TEAM"
                        // "اعضای تیم برنامه‌نویسی پولاریس"
                        // "گروهی از توسعه‌دهندگان با تخصص‌های متفاوت و یک هدف مشترک."
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "OUR TEAM",
                                color = PolarisGold,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                letterSpacing = 2.sp,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                            Text(
                                text = "اعضای تیم برنامه‌نویسی پولاریس",
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold,
                                color = PolarisTextPrimary,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                            Text(
                                text = "گروهی از توسعه‌دهندگان با تخصص‌های متفاوت و یک هدف مشترک.",
                                fontSize = 12.5.sp,
                                color = PolarisTextSecondary,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }

                        // Member Cards (Horizontal scrollable carousel + vertical expansion)
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(TeamData.teamMembers) { member ->
                                MemberCard(
                                    member = member,
                                    onClick = { selectedMember = member },
                                    modifier = Modifier.width(280.dp)
                                )
                            }
                        }
                    }
                }

                // 4. TEAM REPRESENTATIVE CARD
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 12.dp)
                    ) {
                        TeamRepresentativeCard()
                    }
                }

                // 5. SKILLS & TECHNOLOGIES
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        Text(
                            text = "SKILLS & TECHNOLOGIES",
                            color = PolarisGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.8.sp,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "مهارت‌ها و فناوری‌های تیم",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = PolarisTextPrimary,
                            modifier = Modifier.padding(bottom = 14.dp)
                        )

                        SkillSection()
                    }
                }

                // 6. PROJECTS
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        Text(
                            text = "PROJECTS",
                            color = PolarisGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.8.sp,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "پروژه‌ها و محصولات مشترک",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = PolarisTextPrimary,
                            modifier = Modifier.padding(bottom = 14.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            TeamData.projects.forEach { project ->
                                ProjectCard(project = project)
                            }
                        }
                    }
                }

                // 7. TEAM RESPONSIBILITIES (Crucial for Polaris assessment)
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        Text(
                            text = "ROLES & RESPONSIBILITIES",
                            color = PolarisGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.8.sp,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "تقسیم وظایف تیم",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = PolarisTextPrimary,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "نحوه توزیع شفاف مسئولیت‌ها بین اعضای گروه Test جهت دستیابی به محصولی منسجم.",
                            fontSize = 12.5.sp,
                            color = PolarisTextSecondary,
                            modifier = Modifier.padding(bottom = 14.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TeamData.responsibilities.forEach { responsibility ->
                                ResponsibilityCard(item = responsibility)
                            }
                        }
                    }
                }

                // 8. COLLABORATION PROCESS (7 steps)
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        Text(
                            text = "COLLABORATION PROCESS",
                            color = PolarisGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.8.sp,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "فرآیند همکاری و چرخه توسعه تیم",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = PolarisTextPrimary,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Text(
                            text = "تاکید بر کار تیمی، هماهنگی، مستندسازی و بازبینی کیفیت در طول مراحل ارزیابی.",
                            fontSize = 12.5.sp,
                            color = PolarisTextSecondary,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        CollaborationTimeline()
                    }
                }

                // 9. GET IN TOUCH (Contact section from reference)
                item {
                    PolarisContactSection()
                }

                // 10. FOOTER (Footer from reference)
                item {
                    PolarisFooter()
                }
            }
        }

        // Member Detail Dialog
        selectedMember?.let { member ->
            MemberDetailDialog(
                member = member,
                onDismiss = { selectedMember = null }
            )
        }
    }
}
