/*
 * The MIT License
 *
 * Copyright (c) 2009-2023 PrimeTek Informatics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.integrationtests.panel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.AbstractPrimePageTest;
import org.primefaces.selenium.component.CommandButton;
import org.primefaces.selenium.component.Panel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Panel002Test extends AbstractPrimePageTest {

    @Test
    @DisplayName("Panel: collapsed state in MVS")
    public void testMultiViewStateNormal(Page page) {
        // Arrange
        CommandButton update = page.updateForm;
        Panel panel1 = page.panel1;
        Panel panel2 = page.panel2;

        // Act
        panel1.toggle();
        update.click();

        // Assert
        assertTrue(panel1.isCollapsed());
        assertFalse(panel2.isCollapsed());
    }

    @Test
    @DisplayName("Panel: collapsed state in MVS with Panel inside ui:repeat")
    public void testMultiViewStateUiRepeat(Page page) {
        // Arrange
        CommandButton update = page.updateForm;
        Panel repeatPanel1 = page.repeatPanel1;
        Panel repeatPanel2 = page.repeatPanel2;

        // Act
        repeatPanel1.toggle();
        update.click();

        // Assert
        assertTrue(repeatPanel1.isCollapsed());
        assertFalse(repeatPanel2.isCollapsed());
    }

    public static class Page extends AbstractPrimePage {
        @FindBy(id = "form:updateForm")
        CommandButton updateForm;

        @FindBy(id = "form:panel1")
        Panel panel1;
        @FindBy(id = "form:panel2")
        Panel panel2;

        @FindBy(id = "form:repeat:0:panel")
        Panel repeatPanel1;
        @FindBy(id = "form:repeat:1:panel")
        Panel repeatPanel2;

        @Override
        public String getLocation() {
            return "panel/panel002.xhtml";
        }
    }
}
