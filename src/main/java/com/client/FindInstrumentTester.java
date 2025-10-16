package com.client;

import java.util.List;

import com.model.Builder;
import com.model.Inventory;
import com.model.Style;
import com.model.Type;
import com.model.Wood;

public class FindInstrumentTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);
    
    GuitarSpec whatErinLikes= new GuitarSpec(Builder.FENDER,"Stratocastor",Type.ELECTRIC,Wood.ALDER,Wood.ALDER,6);
    MandolinSpec whatErinLikes2 = new MandolinSpec(Builder.PRS,"F-5G",Type.ACOUSTIC,Wood.MAPLE,Wood.MAPLE,Style.A);

    List matchingInstruments = inventory.search (whatErinLikes2);  // tester plusieurs recherches
  
    if (!matchingInstruments.isEmpty())
      System.out.println(matchingInstruments);
    else
      System.out.println("Sorry, Erin, we have nothing for you.");

  }



  public static void initializeInventory(Inventory inventory) {

        // Ajout des guitares à l'inventaire
	    inventory.addInstrument("11277", 3999.95,
	      new GuitarSpec(Builder.COLLINGS, "CJ",  Type.ACOUSTIC,
	                     Wood.INDIAN_ROSEWOOD, Wood.SITKA, 6));
	    inventory.addInstrument("V95693", 1499.95,
	      new GuitarSpec(Builder.FENDER, "Stratocastor",Type.ELECTRIC,
	                     Wood.ALDER, Wood.ALDER, 12));
	    inventory.addInstrument("V9512", 1549.95,
	      new GuitarSpec(Builder.FENDER, "Stratocastor",  Type.ELECTRIC,
	                     Wood.ALDER, Wood.ALDER, 6));
	    inventory.addInstrument("122784", 5495.95,
	      new GuitarSpec(Builder.MARTIN, "D-18",  Type.ACOUSTIC,
	                     Wood.MAHOGANY, Wood.ADIRONDACK, 6));
	    inventory.addInstrument("76531", 6295.95,
	      new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC,
	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6));
	    inventory.addInstrument("70108276", 2295.95,
	      new GuitarSpec(Builder.GIBSON, "Les Paul",  Type.ELECTRIC,
	                     Wood.MAHOGANY, Wood.MAHOGANY, 6));
	    inventory.addInstrument("82765501", 1890.95,
	      new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC,
	                     Wood.MAHOGANY, Wood.MAHOGANY, 6));
	    inventory.addInstrument("77023", 6275.95,
	      new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC,
	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6));
	    inventory.addInstrument("1092", 12995.95,
	      new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC,
	                     Wood.INDIAN_ROSEWOOD,Wood.CEDAR, 12));
	    inventory.addInstrument("566-62", 8999.95,
	      new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC,
	                     Wood.COCOBOLO, Wood.CEDAR, 12));
	    inventory.addInstrument("6 29584", 2100.95,
	      new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC,
	                     Wood.MAHOGANY, Wood.MAPLE, 6));

	    // Ajout des mandolines à l'inventaire
	    inventory.addInstrument("8819920", 5495.99 ,
	  	      new MandolinSpec(Builder.PRS, "F-5G", Type.ACOUSTIC,
	  	                     Wood.MAPLE, Wood.MAPLE, Style.F));
	    inventory.addInstrument("9019920", 745.99 ,
	  	      new MandolinSpec (Builder.PRS, "F-5G", Type.ACOUSTIC,
	  	                     Wood.MAPLE, Wood.MAPLE, Style.A));
	  }
}
