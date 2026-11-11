package io.jadiefication

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WebsiteTest {

    @Test
    fun testPortfolioHtmlContent() {
        // Must contain Void Framework
        assertTrue(portfolioHtml.contains("Void"))
        assertTrue(portfolioHtml.contains("v2.3.0"))

        // Must NOT contain deprecated Void-HTML
        assertFalse(portfolioHtml.contains("Void-HTML", ignoreCase = true))

        // Must contain flagship projects from GitHub & portfolio
        assertTrue(portfolioHtml.contains("Ouizja"))
        assertTrue(portfolioHtml.contains("Ethereal"))
        assertTrue(portfolioHtml.contains("Uzyi"))
        assertTrue(portfolioHtml.contains("Haje"))

        // Must contain Education entries from Moje_Portfolio
        assertTrue(portfolioHtml.contains("ZČU"))
        assertTrue(portfolioHtml.contains("INFIS"))
        assertTrue(portfolioHtml.contains("KFY/FZKV"))

        // Must contain Experience & Achievements
        assertTrue(portfolioHtml.contains("Cloudflight Coding Contest"))
        assertTrue(portfolioHtml.contains("G+SOŠ Rokycany"))
        assertTrue(portfolioHtml.contains("Co-Hackathon"))
        assertTrue(portfolioHtml.contains("PrintHack"))

        // Must contain Notes / Quantum Research
        assertTrue(portfolioHtml.contains("Atom Simulation"))
        assertTrue(portfolioHtml.contains("QUANTUM / BELL STATE"))
        assertTrue(portfolioHtml.contains("GPGPU / WORKGROUP"))

        // Check layout sections 01 - 06
        assertTrue(portfolioHtml.contains("01 / Projects"))
        assertTrue(portfolioHtml.contains("02 / Tools"))
        assertTrue(portfolioHtml.contains("03 / Education"))
        assertTrue(portfolioHtml.contains("04 / Experience"))
        assertTrue(portfolioHtml.contains("05 / Notes"))
        assertTrue(portfolioHtml.contains("06 / Contact"))

        // Footer check
        assertTrue(portfolioHtml.contains("Powered by Void Framework"))
    }
}
