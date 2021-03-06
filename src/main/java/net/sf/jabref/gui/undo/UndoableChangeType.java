/*  Copyright (C) 2003-2011 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package net.sf.jabref.gui.undo;

import net.sf.jabref.logic.l10n.Localization;
import net.sf.jabref.logic.util.strings.StringUtil;
import net.sf.jabref.model.entry.BibEntry;

/**
 * This class represents the change of type for an entry.
 */
public class UndoableChangeType extends AbstractUndoableJabRefEdit {
    private final String oldType;
    private final String newType;
    private final BibEntry entry;

    public UndoableChangeType(BibEntry entry, String oldType, String newType) {
        this.oldType = oldType;
        this.newType = newType;
        this.entry = entry;
    }

    @Override
    public String getPresentationName() {
        return Localization.lang("change type of entry %0 from %1 to %2",
                StringUtil.boldHTML(entry.getCiteKey(), ""),
                StringUtil.boldHTML(oldType, Localization.lang("undefined")),
                StringUtil.boldHTML(newType));
    }

    @Override
    public void undo() {
        super.undo();
        entry.setType(oldType);
    }

    @Override
    public void redo() {
        super.redo();
        entry.setType(newType);
    }
}
