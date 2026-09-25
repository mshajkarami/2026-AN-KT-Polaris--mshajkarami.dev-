package ir.polaris.test

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import ir.polaris.test.data.TeamData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class PolarisAppTest {

    @Test
    fun `verify app name resource is Test`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Test", appName)
    }

    @Test
    fun `verify team data has 5 reference members`() {
        assertEquals(5, TeamData.teamMembers.size)
        val memberNumbers = TeamData.teamMembers.map { it.number }
        assertEquals(listOf("01", "02", "03", "04", "05"), memberNumbers)
    }

    @Test
    fun `verify collaboration steps are sequential`() {
        assertEquals(7, TeamData.collaborationSteps.size)
        assertEquals(1, TeamData.collaborationSteps.first().stepNumber)
        assertEquals(7, TeamData.collaborationSteps.last().stepNumber)
    }

    @Test
    fun `verify projects have required properties`() {
        assertTrue(TeamData.projects.isNotEmpty())
        TeamData.projects.forEach { project ->
            assertNotNull(project.title)
            assertNotNull(project.responsibleMember)
            assertNotNull(project.status)
        }
    }

    @Test
    fun `verify typography uses IranYekan font family`() {
        assertEquals(ir.polaris.test.ui.theme.IranYekan, ir.polaris.test.ui.theme.Typography.bodyLarge.fontFamily)
        assertEquals(ir.polaris.test.ui.theme.IranYekan, ir.polaris.test.ui.theme.Typography.titleLarge.fontFamily)
        assertEquals(ir.polaris.test.ui.theme.IranYekan, ir.polaris.test.ui.theme.Typography.displayLarge.fontFamily)
    }

    @Test
    fun `verify iran yekan font resources exist`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val fontRes1 = context.resources.getIdentifier("iran_yekan_regular", "font", context.packageName)
        val fontRes2 = context.resources.getIdentifier("iran_yekan_l", "font", context.packageName)
        assertTrue(fontRes1 != 0)
        assertTrue(fontRes2 != 0)
    }

    @Test
    fun `verify team members have photos from website`() {
        TeamData.teamMembers.forEach { member ->
            assertNotNull(member.photoRes)
            assertTrue(member.photoRes != 0)
        }
    }

    @Test
    fun `verify website hero content matches`() {
        assertEquals("تیمی از برنامه‌نویس‌ها برای ساختن آینده‌ای بهتر.", TeamData.HERO_TITLE)
        assertTrue(TeamData.HERO_DESCRIPTION.contains("ما در پولاریس"))
    }
}
