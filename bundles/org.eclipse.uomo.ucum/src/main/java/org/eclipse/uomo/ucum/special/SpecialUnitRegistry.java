/*******************************************************************************
 * Crown Copyright (c) 2006, 2011, Copyright (c) 2006, 2008 Kestral Computing P/L.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Kestral Computing P/L - initial implementation
 *******************************************************************************/

package org.eclipse.uomo.ucum.special;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.uomo.util.Registry;
import org.unitsofmeasurement.quantity.InformationRate;

@SuppressWarnings("rawtypes")
public class SpecialUnitRegistry implements Registry<SpecialUnitHandler> {
	final Map<String, SpecialUnitHandler> handlers = new HashMap<String, SpecialUnitHandler>();

	public SpecialUnitRegistry() {
		super();
		init();
	}

	private void register(SpecialUnitHandler handler) {
		handlers.put(handler.getCode(), handler);		
	}
	
	private void init() {
		register(new CelsiusHandler());		
		register(new FahrenheitHandler());		
		register(new HoldingHandler("[p'diop]", "deg"));		
		register(new HoldingHandler("%[slope]", "deg"));		
		register(new HoldingHandler("[hp_X]", "1"));		
		register(new HoldingHandler("[hp_C]", "1"));		
		register(new HoldingHandler("[pH]", "mol/l"));		
		register(new HoldingHandler("Np", "1"));		
		register(new HoldingHandler("B", "1"));		
		register(new HoldingHandler("B[SPL]", "10*-5.Pa", new BigDecimal(2)));		
		register(new HoldingHandler("B[V]", "V"));		
		register(new HoldingHandler("B[mV]", "mV"));		
		register(new HoldingHandler("B[uV]", "uV"));		
		register(new HoldingHandler("B[W]", "W"));		
		register(new HoldingHandler("B[kW]", "kW"));		
		register(new HoldingHandler<InformationRate>("bit_s", "1"));		
	}

	public boolean exists(String code) {
		return handlers.containsKey(code);
	}

	public SpecialUnitHandler get(String code) {
		return handlers.get(code);
	}

}
