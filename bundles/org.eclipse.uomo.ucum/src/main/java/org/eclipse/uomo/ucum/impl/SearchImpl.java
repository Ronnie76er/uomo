/*******************************************************************************
 * Crown Copyright (c) 2006, 2008, Copyright (c) 2006, 2008 Kestral Computing P/L.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Kestral Computing P/L - initial implementation
 *******************************************************************************/

package org.eclipse.uomo.ucum.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uomo.ucum.Search;
import org.eclipse.uomo.ucum.model.Concept;
import org.eclipse.uomo.ucum.model.ConceptKind;
import org.eclipse.uomo.ucum.model.Prefix;
import org.eclipse.uomo.ucum.model.UcumModel;
import org.eclipse.uomo.ucum.model.UcumUnit;

class SearchImpl implements Search {

	public List<Concept> doSearch(UcumModel model, ConceptKind kind, String text, boolean isRegex) {
		List<Concept> concepts = new ArrayList<Concept>();
		if (kind == null || kind == ConceptKind.PREFIX)
			searchPrefixes(concepts, model.getPrefixes(), text, isRegex);
		if (kind == null || kind == ConceptKind.BASEUNIT)
			searchUnits(concepts, model.getBaseUnits(), text, isRegex);
		if (kind == null || kind == ConceptKind.UNIT)
			searchUnits(concepts, model.getDefinedUnits(), text, isRegex);
		return concepts;
	}
	
	private void searchUnits(List<Concept> concepts, List<? extends UcumUnit> units, String text, boolean isRegex) {
		for (UcumUnit unit : units) {
			if (matchesUnit(unit, text, isRegex))
				concepts.add(unit);
		}
	}

	private boolean matchesUnit(UcumUnit unit, String text, boolean isRegex) {
		return matches(unit.getProperty(), text, isRegex) || matchesConcept(unit, text, isRegex);
	}

	private void searchPrefixes(List<Concept> concepts, List<? extends Prefix> prefixes, String text, boolean isRegex) {
		for (Concept concept : prefixes) {
			if (matchesConcept(concept, text, isRegex))
				concepts.add(concept);
		}		
	}

	private boolean matchesConcept(Concept concept, String text, boolean isRegex) {
		for (String name : concept.getNames()) {
			if (matches(name, text, isRegex))
				return true;
		}
		if (matches(concept.getCode(), text, isRegex))
			return true;
		if (matches(concept.getCodeUC(), text, isRegex))
			return true;
		if (matches(concept.getPrintSymbol(), text, isRegex))
			return true;
		return false;
	}

	private boolean matches(String value, String text, boolean isRegex) {
		return (value != null) && ((isRegex  && value.matches(text)) || (!isRegex && value.toLowerCase().contains(text.toLowerCase())));
	}


}

